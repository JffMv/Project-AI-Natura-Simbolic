package com.ai.prolog.natura.api_ai_prolog.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

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
        return "jabon italico";
    }
}
