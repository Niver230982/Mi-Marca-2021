package com.niverarrigonni.mimarca;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Menu_Lateral extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__lateral);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_marcar:
                Intent marcar = new Intent(this, MarcaActivity.class);
                startActivity(marcar);
                break;
            case R.id.nav_mi_ubicación:
                Intent miUbicación = new Intent(this, MainActivity.class);
                startActivity(miUbicación);
                break;
            case R.id.nav_parte_mensual:
                Toast.makeText(getApplicationContext(),R.string.menu_parte_mensual, Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_documentación:
                Intent docs = new Intent(this, DocumentacionActivity.class);
                startActivity(docs);
                break;
            case R.id.nav_mensaje:
                Intent mensaje = new Intent(this, MensajeActivity.class);
                startActivity(mensaje);
                break;
            case R.id.nav_salir:
                Intent login = new Intent(this, LoginActivity.class);
                startActivity(login);
                break;
            default:
                throw new IllegalArgumentException("Opcion no existente");
        }
        return true;
    }



}