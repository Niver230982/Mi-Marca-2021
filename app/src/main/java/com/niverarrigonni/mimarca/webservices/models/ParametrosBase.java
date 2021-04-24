package com.niverarrigonni.mimarca.webservices.models;

public class ParametrosBase {

    public String db;
    public String login;
    public String password;

    public ParametrosBase(){
        this.db = "odoo14";
        this.login = "admin";
        this.password = "admin";
    }
}
