package com.ai.prolog.natura.api_ai_prolog.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.jpl7.Query;
import org.jpl7.Term;
import org.jpl7.Variable;

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

    public String process(){
        String githubRawUrl = "https://github.com/JffMv/prolog-AI/blob/main/proyecto%20final%20IA.pl";
        Query.hasSolution("consult('" + githubRawUrl + "')");

        // Define los parámetros que deseas pasar a la regla
        //Term arg1 = new Variable("P");
        //Term arg2 = new Variable("Arg2");

        // Construye la consulta Prolog con la regla y los parámetros
        Query query = new Query("consultaConDuplicados(P)" );

        if (query.hasSolution()) {
            Term result1 = query.getSolution().get("P");
            query.close();
            System.out.println("Resultado 1: " + result1);
            setName(result1.toString());
            return result1.toString();
        } else {
            System.out.println("No hay solución para la consulta.");
            return "No hay solución para la consulta.";
        }




    }
}
