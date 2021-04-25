package com.niverarrigonni.mimarca.webservices.models;


public class Planificacion {

    public Planificacion(Params params){

        this.params = params;
    }

    public static class Params extends ParametrosBase{

        public Params(String doc) {
            super();
            this.doc = doc;
        }
        public String doc;

    }

    public Params params;
}