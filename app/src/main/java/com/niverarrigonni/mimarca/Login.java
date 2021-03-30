package com.niverarrigonni.mimarca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }

    //Metodo de boton logueado
    public void Ingresar(View view){
        Intent ingresar = new Intent(this, MainActivity.class);
        startActivity(ingresar);
    }
}