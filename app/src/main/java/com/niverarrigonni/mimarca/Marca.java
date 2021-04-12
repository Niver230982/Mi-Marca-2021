package com.niverarrigonni.mimarca;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.Objects;

public class Marca extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marca);



    }

    //Botón Atrás


   /// @Override
  //  public boolean onOptionsItemSelected(@NonNull MenuItem item) {
   //     switch (item.getItemId()){
    //        case android.R.id.home:
     //           finish();
      //          return true;
      //  }
       // return super.onOptionsItemSelected(item);
   // }

    //Botónes de marcado

    public void Entrada(View view) {
        Toast.makeText(this, "Marcar entrada", Toast.LENGTH_LONG).show();
    }

    public void Descanso(View view) {
        Toast.makeText(this, "Iniciar descanso", Toast.LENGTH_LONG).show();
    }

    public void Salida(View view) {
        Toast.makeText(this, "Marcar salida", Toast.LENGTH_LONG).show();
    }

    public void Atras(View view) {

    }

}