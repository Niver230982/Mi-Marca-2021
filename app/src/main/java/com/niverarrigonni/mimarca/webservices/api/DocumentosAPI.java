package com.niverarrigonni.mimarca.webservices.api;

import com.niverarrigonni.mimarca.webservices.models.Documentos;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DocumentosAPI {
    @POST("odoo-api/documentos")
    Call<Documentos> recibirDocs(@Body String doc);
}
