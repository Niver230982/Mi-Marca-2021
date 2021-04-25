package com.niverarrigonni.mimarca.webservices.models;

import com.google.gson.annotations.SerializedName;

public class Documentos {
    //public String jsonrpc;
    public Params params;

    public Documentos(Params params){
        //this.jsonrpc ="2.0";
        this.params = params;
    }

    public static class Params extends ParametrosBase{
        public String doc;

        public Params(String doc) {
            super();
            this.doc = doc;

        }
    }

}