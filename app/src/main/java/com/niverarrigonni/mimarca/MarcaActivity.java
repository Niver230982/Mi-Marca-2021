package com.niverarrigonni.mimarca;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.niverarrigonni.mimarca.utils.MensajeUtils;
import com.niverarrigonni.mimarca.webservices.api.MensajeAPI;
import com.niverarrigonni.mimarca.webservices.api.PlanificacionApi;
import com.niverarrigonni.mimarca.webservices.models.Mensaje;
import com.niverarrigonni.mimarca.webservices.models.Planificacion;
import com.niverarrigonni.mimarca.webservices.models.ResponsePlanificacion;
import com.niverarrigonni.mimarca.webservices.models.WS;
import com.niverarrigonni.mimarca.webservices.sesion.Sesion;

import java.util.List;
import java.util.Objects;

import java.io.ByteArrayOutputStream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;




public class MarcaActivity extends AppCompatActivity {

    TextView plan_dia;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marca);
        plan_dia= findViewById(R.id.plan_dia);
        recibirPlanApi();
    }



    //Botónes de marcado

    public void Entrada(View view) {
       Toast.makeText(this, "Marcar entrada", Toast.LENGTH_LONG).show();



    }

    public void Descanso(View view) {
        Toast.makeText(this, "Iniciar descanso", Toast.LENGTH_LONG).show();
    }

    public void Retorno(View view) {
        Toast.makeText(this, "Fin de descanso", Toast.LENGTH_LONG).show();
    }

    public void Salida(View view) {
        Toast.makeText(this, "Marcar salida", Toast.LENGTH_LONG).show();
    }





    public void recibirPlanApi() {
    //public void Entrada(View view) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://165.227.110.148:8069/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        String doc = Sesion.getInstance().getDocuemnt();
        //String asunto = asuntoText.getText().toString() != null ?  asuntoText.getText().toString(): "";
        //String msjText =mensajeText.getText().toString() != null ? mensajeText.getText().toString(): "";
        //String image = "";


        final Planificacion planificacion = new Planificacion(new Planificacion.Params(doc));

        PlanificacionApi planificacionApi = retrofit.create(PlanificacionApi.class);
        Call<ResponsePlanificacion> call = planificacionApi.enviar(planificacion);
        call.enqueue(new Callback<ResponsePlanificacion>() {

            @Override
            public void onResponse(Call<ResponsePlanificacion> call, Response<ResponsePlanificacion> response) {
                if (response.isSuccessful()) {
                    List<ResponsePlanificacion.Result> resultados =  response.body().result;
                    if(!resultados.isEmpty()){
                        ResponsePlanificacion.Result result = resultados.get(0);
                        plan_dia.setText(MensajeUtils.crearMensajePlanificacion(result));
                    }
                    Toast.makeText(MarcaActivity.this, "Recibida la Api", Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(MarcaActivity.this, "No se pudo Recibir API", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponsePlanificacion> call, Throwable t) {
                Toast.makeText(MarcaActivity.this,"Error Inesperado", Toast.LENGTH_SHORT).show();
            }
        });
    }











}