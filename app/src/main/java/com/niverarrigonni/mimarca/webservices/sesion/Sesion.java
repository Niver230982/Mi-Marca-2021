package com.niverarrigonni.mimarca.webservices.sesion;

public class Sesion {
    private static Sesion instance;

    private String docuemnt;

    private Sesion() {}

    public static Sesion getInstance() {
        if( instance == null) {
            instance = new Sesion();
        }
        return instance;
    }

    public String getDocuemnt() {
        return docuemnt;
    }

    public void setDocuemnt(String docuemnt) {
        this.docuemnt = docuemnt;
    }
}
