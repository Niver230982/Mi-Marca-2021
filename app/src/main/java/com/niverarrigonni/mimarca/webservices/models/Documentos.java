package com.niverarrigonni.mimarca.webservices.models;

public class Documentos {
    public Documentos(Params params){
        //this.jsonrpc ="2.0";
        this.params = params;
    }

    public static class Params extends ParametrosBase{

        public Params(String doc) {
            super();
            this.doc = doc;
            this.fecha = "";
            this.asunto = "";
            this.docCode = "";
        }

        public String doc;
        public String fecha;
        public String asunto;
        public String docCode;
    }

    //public String jsonrpc;
    public Params params;
}