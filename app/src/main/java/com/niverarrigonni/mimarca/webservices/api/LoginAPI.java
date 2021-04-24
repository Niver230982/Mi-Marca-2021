package com.niverarrigonni.mimarca.webservices.api;

import com.niverarrigonni.mimarca.webservices.models.WS;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginAPI {
    @POST("odoo-api/login/inicio")
    Call<WS> logincall(@Body WS loginicio);
}
