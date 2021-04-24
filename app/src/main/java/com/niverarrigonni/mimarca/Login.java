package com.niverarrigonni.mimarca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity {
    Button btnLogin;
    EditText txUserId;
    EditText txPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        txUserId = findViewById(R.id.txUserId);
        txPassword = findViewById(R.id.txPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                logincall(txUserId.getText().toString(),txPassword.getText().toString());
            }
        });
    }

    public void logincall(final String doc, final String pin) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://165.227.110.148:8069/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        Usuario usuario = new Usuario();
        usuario.setDoc(doc);
        usuario.setPin(pin);

        final WS ws = new WS(new WS.Params(doc, pin));

        LoginAPI loginAPI = retrofit.create(LoginAPI.class);
        Call<WS> call = loginAPI.logincall(ws);
        call.enqueue(new Callback<WS>() {
            @Override
            public void onResponse(Call<WS> call, Response<WS> response) {
                try {
                    if (response.isSuccessful()) {
                        WS w = response.body();
                        //Log.d("value of x is ---> ", String.valueOf(w));
                        Usuario uss = new Usuario();
                        uss.setDoc(doc);
                        uss.setPin(pin);
                        Intent intent = new Intent(Login.this, Menu_Lateral.class);
                        startActivity(intent);
                    }
                } catch (Exception ex) {
                    Toast.makeText(Login.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<WS> call, Throwable t) {
                Toast.makeText(Login.this,"Error Inesperado", Toast.LENGTH_SHORT).show();
                //Log.e("ERROR", t.getStackTrace().toString());
            }
        });
    }

    //Metodo de boton logueado
   /* public void Ingresar(View view) {
        Intent ingresar = new Intent(this, Menu_Lateral.class);
        startActivity(ingresar);

    }*/
}