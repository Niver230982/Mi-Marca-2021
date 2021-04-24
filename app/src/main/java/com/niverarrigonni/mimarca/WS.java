package com.niverarrigonni.mimarca;

public class WS {
    public WS(Params params){
        this.jsonrpc ="2.0";
        this.params = params;
    }

    public static class Params {

        public Params(String doc, String pin){
            this.db = "odoo14";
            this.login = "admin";
            this.password = "admin";
            this.doc = doc;
            this.pin = pin;
        }
        public Params(String doc){
            this.db = "odoo14";
            this.login = "admin";
            this.password = "admin";
            this.doc = doc;
        }

        public String db;
        public String login;
        public String password;
        public String doc;
        public String pin;
    }

    public String jsonrpc;
    public Params params;

}
