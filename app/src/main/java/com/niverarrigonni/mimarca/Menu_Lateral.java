package com.niverarrigonni.mimarca;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
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
                Toast.makeText(getApplicationContext(),R.string.menu_marcar, Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_mi_ubicación:
                Toast.makeText(getApplicationContext(),R.string.menu_mi_ubicación, Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_parte_mensual:
                Toast.makeText(getApplicationContext(),R.string.menu_parte_mensual, Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_documentación:
                Toast.makeText(getApplicationContext(),R.string.menu_documentación, Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_mensaje:
                Toast.makeText(getApplicationContext(),R.string.menu_mensaje, Toast.LENGTH_LONG).show();
                break;
            default:
                throw new IllegalArgumentException("Opcion no existente");
        }

        return true;
    }

}