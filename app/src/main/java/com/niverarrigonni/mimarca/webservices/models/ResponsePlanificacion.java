package com.niverarrigonni.mimarca.webservices.models;

import java.util.List;

public class ResponsePlanificacion {

    public ResponsePlanificacion(List<Result> result){
        this.result = result;
    }

    public static class Result{

        public Result(String fecha, String entrada, String salida, String local, String calle) {
            this.fecha = fecha;
            this.entrada = entrada;
            this.salida = salida;
            this.local = local;
            this.calle = calle;
        }

        public String fecha;
        public String entrada;
        public String salida;
        public String local;
        public String calle;
    }

    public List<Result> result;
}