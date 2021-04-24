package com.niverarrigonni.mimarca.webservices.api;

import com.niverarrigonni.mimarca.webservices.models.Mensaje;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface MensajeAPI {
    @POST("odoo-api/mensajes")
    Call<Mensaje> enviar(@Body Mensaje mensaje);
}
