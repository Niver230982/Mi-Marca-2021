package com.niverarrigonni.mimarca.webservices.models;

public class Mensaje {
    public Mensaje(Params params){
        //this.jsonrpc ="2.0";
        this.params = params;
    }

    public static class Params extends ParametrosBase{

        public Params(String doc, String asunto, String mensaje, String adjuntos) {
            super();
            this.doc = doc;
            this.asunto = asunto;
            this.mensaje = mensaje;
            this.adjuntos = adjuntos;
        }

        public String doc;
        public String asunto;
        public String mensaje;
        public String adjuntos;
    }

    //public String jsonrpc;
    public Params params;
}
