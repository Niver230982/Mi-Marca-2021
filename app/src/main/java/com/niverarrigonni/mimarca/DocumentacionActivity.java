package com.niverarrigonni.mimarca;

import android.os.Bundle;
import android.se.omapi.Session;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.niverarrigonni.mimarca.webservices.api.DocumentosAPI;
import com.niverarrigonni.mimarca.webservices.models.Documentos;
import com.niverarrigonni.mimarca.webservices.sesion.Sesion;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DocumentacionActivity extends AppCompatActivity {

    Toolbar toolbar;

    private ArrayList<Documentos> listadocs;
    private Button actualizar;
    private ListView lv1;
    private TextView tvInfoDocs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documentacion);

        actualizar = findViewById(R.id.actualizar);
        tvInfoDocs = findViewById(R.id.tvInfoDocs);
        listadocs = new ArrayList<Documentos>();

        /*toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/
        
        AdaptadorDocumentos adaptador = new AdaptadorDocumentos (this);
        lv1 = findViewById(R.id.list1);
        lv1.setAdapter(adaptador);
        lv1.setAdapter(adaptador);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                //A VER Q PASA
                Toast.makeText(DocumentacionActivity.this,listadocs.get(i).params.asunto, Toast.LENGTH_LONG).show();
            }
        });

        actualizar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ActualizarAPI(v);
            }
        });
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }

    class AdaptadorDocumentos extends ArrayAdapter<Documentos> {

        AppCompatActivity appCompatActivity;

        AdaptadorDocumentos(AppCompatActivity context) {
            super(context, R.layout.activity_documentacion, listadocs);
            appCompatActivity = context;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = appCompatActivity.getLayoutInflater();
            View item = inflater.inflate(R.layout.documento, null);

            TextView textView1 = item.findViewById(R.id.textView);
            textView1.setText(listadocs.get(position).params.asunto);

            ImageView imageView1 = item.findViewById(R.id.imageView);
            imageView1.setImageResource(R.drawable.icon_doc);
            return (item);
        }
    }

    public void ActualizarAPI(View view){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://165.227.110.148:8069/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        //Recupero el doc desde la session guardada en el login
        String doc = Sesion.getInstance().getDocuemnt();

        //Llamo a la API
        DocumentosAPI documentosAPI = retrofit.create(DocumentosAPI.class);
        Call<Documentos> call = documentosAPI.recibirDocs(doc);
        call.enqueue(new Callback<Documentos>() {
            @Override
            public void onResponse(Call<Documentos> call, Response<Documentos> response) {
                if(response.isSuccessful()){
                    Documentos d = response.body();
                    for(int i=0; i<=0; i++){
                        listadocs.add(d);
                        tvInfoDocs.setText("Aca andamos");
                    }

                }else {
                    tvInfoDocs.setText("LPM");
                }

            }

            @Override
            public void onFailure(Call<Documentos> call, Throwable t) {

            }
        });

        Toast.makeText(this,"Actualizar Archivos", Toast.LENGTH_LONG).show();
    }

}