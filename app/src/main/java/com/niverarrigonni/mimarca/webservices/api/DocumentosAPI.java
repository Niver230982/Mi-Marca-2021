package com.niverarrigonni.mimarca.webservices.api;

import com.niverarrigonni.mimarca.webservices.models.Documentos;
import com.niverarrigonni.mimarca.webservices.models.ResponseDocumentos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface DocumentosAPI {
    @POST("odoo-api/documentos")
    Call<ResponseDocumentos> recibirDocs(@Body Documentos doc);
}
