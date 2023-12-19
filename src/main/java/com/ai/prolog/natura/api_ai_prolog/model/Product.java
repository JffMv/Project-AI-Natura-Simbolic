package com.ai.prolog.natura.api_ai_prolog.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.jpl7.Query;
import org.jpl7.Term;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.net.URL;

@Setter
@Getter
@Builder
public class Product {
    private String name;
    private String line;
    private String parteDelCuerpo;
    private String objetivo;
    private String estadoDeLaParte;
    private String momentoAplicar;
    private String genero;
    private String precio;
    private String quieroEstaTecnologia;

    public String process() {
        String githubRawUrl = "https://raw.githubusercontent.com/JffMv/prolog-AI/main/proyecto%20final%20IA.pl";

        System.out.println("paso 1");
        String loadQuery = "consult('" + githubRawUrl + "')";
        Query loadQueryObj = new Query(loadQuery);
        System.out.println("paso 3");

        if (loadQueryObj.hasSolution()) {
            System.out.println("Carga del código Prolog exitosa");

            // Ahora puedes realizar consultas adicionales
            String consulta = "consultaConDuplicados(RESULTADO)";
            Query queryObj = new Query(consulta);

            // Ejecutar la consulta
            if (queryObj.hasSolution()) {
                String resultadoString = queryObj.oneSolution().get("RESULTADO").toString();
                String[] resultadoArray = resultadoString.split(",");
                List<String> resultadoList = Arrays.asList(resultadoArray);
                setName(resultadoList.get(0));
                while (queryObj.hasMoreSolutions()) {
                    Term solution = queryObj.nextSolution().get("Variable");
                    System.out.println("Resultado: " + solution.toString());
                }
            } else {
                System.out.println("La consulta no tiene solución.");
            }
        } else {
            System.out.println("Error al cargar el código Prolog");
        }
    return "";
    }

}
