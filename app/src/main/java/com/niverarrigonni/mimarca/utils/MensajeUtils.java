package com.niverarrigonni.mimarca.utils;

import com.niverarrigonni.mimarca.webservices.models.ResponsePlanificacion;

public final class MensajeUtils {
    private MensajeUtils() {}

    public static String obtenerHoraFormateada(String horaSinFormatear) {
        return horaSinFormatear;
    }

    public static String crearMensajePlanificacion(ResponsePlanificacion.Result result) {
        StringBuffer buffer =  new StringBuffer();
        buffer.append("Fecha: " + result.fecha);
        buffer.append("\n");
        buffer.append("Hora: " + obtenerHoraFormateada(result.entrada) +
                " a " + obtenerHoraFormateada(result.salida));
        buffer.append("\n");
        buffer.append("Local: " + result.local);
        buffer.append("\n");
        buffer.append("Dirección: " + result.calle);
        return buffer.toString();
    }
}
