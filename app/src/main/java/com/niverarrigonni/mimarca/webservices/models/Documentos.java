package com.niverarrigonni.mimarca.webservices.models;

import com.google.gson.annotations.SerializedName;

public class Documentos {
    //public String jsonrpc;
    public Params params;
    private String fecha, asunto;

    @SerializedName("body")
    private String docEncode;

    public Documentos(Params params){
        //this.jsonrpc ="2.0";
        this.params = params;
        fecha = "";
        asunto="";
        docEncode ="";
    }

    public static class Params extends ParametrosBase{
        public String doc;

        public Params(String doc) {
            super();
            this.doc = doc;

        }
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDocEncode() {
        return docEncode;
    }

    public void setDocEncode(String docEncode) {
        this.docEncode = docEncode;
    }
}