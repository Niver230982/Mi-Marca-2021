package com.niverarrigonni.mimarca.webservices.models;

public class WS {
    public WS(Params params){
        this.jsonrpc ="2.0";
        this.params = params;
    }

    public static class Params extends ParametrosBase {

        public Params(String doc, String pin){
            super();
            this.doc = doc;
            this.pin = pin;
        }
        public Params(String doc){
            super();
            this.doc = doc;
        }

        public String doc;
        public String pin;
    }

    public String jsonrpc;
    public Params params;

}
