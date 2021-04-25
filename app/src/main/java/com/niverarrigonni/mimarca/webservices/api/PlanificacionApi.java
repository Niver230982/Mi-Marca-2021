package com.niverarrigonni.mimarca.webservices.api;
import com.niverarrigonni.mimarca.webservices.models.Planificacion;
import com.niverarrigonni.mimarca.webservices.models.ResponsePlanificacion;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PlanificacionApi {
    @POST("odoo-api/dia")
    Call<ResponsePlanificacion> enviar(@Body Planificacion planificacion);
}



