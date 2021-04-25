package com.niverarrigonni.mimarca.utils;

import com.niverarrigonni.mimarca.webservices.models.ResponseDocumentos;

public final class DocumentosUtils {

    private  DocumentosUtils(){}

    public static String crearDocumentos(ResponseDocumentos.Result result) {
        StringBuffer buffer =  new StringBuffer();
        buffer.append("Fecha: " + result.fecha);
        buffer.append("\n");
        buffer.append("Asunto: " + result.asunto);
        buffer.append("\n");
        buffer.append("DocEncode: " + result.docEncode);
        return buffer.toString();
    }
}
