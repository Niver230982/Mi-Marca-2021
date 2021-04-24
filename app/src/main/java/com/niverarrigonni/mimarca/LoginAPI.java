package com.niverarrigonni.mimarca;

import com.niverarrigonni.mimarca.Usuario;

import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.Call;

public interface LoginAPI {
    @POST("odoo-api/login/inicio")
    Call<WS> logincall(@Body WS loginicio);
}
