package com.niverarrigonni.mimarca;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class Marca extends AppCompatActivity {



    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marca);





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


}