package com.niverarrigonni.mimarca;

public class Documentos {
    private String nombre;
    private String fecha;

    public Documentos(String nombre, String fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}