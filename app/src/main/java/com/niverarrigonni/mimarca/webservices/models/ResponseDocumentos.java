package com.niverarrigonni.mimarca.webservices.models;

import java.util.List;

public class ResponseDocumentos {
    public ResponseDocumentos(List<Result> result) {this.result = result;}

    public static class Result{
        public Result(String fecha, String asunto, String docEncode){
            this.fecha = fecha;
            this.asunto = asunto;
            this.docEncode = docEncode;
        }
        public String fecha;
        public String asunto;
        public String docEncode;
    }
    public List<Result> result;
}
