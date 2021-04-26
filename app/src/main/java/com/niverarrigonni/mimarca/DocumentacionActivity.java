package com.niverarrigonni.mimarca;

import android.os.Bundle;
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

import com.niverarrigonni.mimarca.utils.DocumentosUtils;
import com.niverarrigonni.mimarca.webservices.api.DocumentosAPI;
import com.niverarrigonni.mimarca.webservices.models.Documentos;
import com.niverarrigonni.mimarca.webservices.models.ResponseDocumentos;
import com.niverarrigonni.mimarca.webservices.sesion.Sesion;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DocumentacionActivity extends AppCompatActivity {


    private ArrayList<ResponseDocumentos.Result> listadocs;
    private Button actualizar;
    private ListView lv1;
    private TextView tvInfoDocs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documentacion);

        actualizar = findViewById(R.id.actualizar);
        tvInfoDocs = findViewById(R.id.tvInfoDocs);
        listadocs = new ArrayList<>();
        
        AdaptadorDocumentos adaptador = new AdaptadorDocumentos (this);
        lv1 = findViewById(R.id.list1);
        lv1.setAdapter(adaptador);
        lv1.setAdapter(adaptador);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                //A VER Q PASA
                Toast.makeText(DocumentacionActivity.this,"...", Toast.LENGTH_LONG).show();
                //listadocs.get(i).params.asunto
            }
        });

        actualizar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ActualizarAPI(v);
            }
        });
    }

    class AdaptadorDocumentos extends ArrayAdapter<ResponseDocumentos.Result> {

        AppCompatActivity appCompatActivity;

        AdaptadorDocumentos(AppCompatActivity context) {
            super(context, R.layout.activity_documentacion, listadocs);
            appCompatActivity = context;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = appCompatActivity.getLayoutInflater();
            View item = inflater.inflate(R.layout.documento, null);

            TextView textView1 = item.findViewById(R.id.textView);
            //textView1.setText(listadocs.get(position).params.asunto);

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

        final Documentos docSend = new Documentos(new Documentos.Params(doc));

        //Llamo a la API
        DocumentosAPI documentosAPI = retrofit.create(DocumentosAPI.class);
        Call<ResponseDocumentos> call = documentosAPI.recibirDocs(docSend);
        call.enqueue(new Callback<ResponseDocumentos>() {

            @Override
            public void onResponse(Call<ResponseDocumentos> call, Response<ResponseDocumentos> response) {
                if(response.isSuccessful()){
                    List<ResponseDocumentos.Result> resultados = response.body().result;
                    if(!resultados.isEmpty()){
                        for (int i=0; i>resultados.size(); i++) {
                            ResponseDocumentos.Result result = resultados.get(i);
                            listadocs.add(result);
                            //tvInfoDocs.setText(DocumentosUtils.crearDocumentos(result));
                        }
                    }
                    Toast.makeText(DocumentacionActivity.this, "Recibida la Api", Toast.LENGTH_SHORT).show();

                }else {
                    tvInfoDocs.setText("LPM");
                    Toast.makeText(DocumentacionActivity.this, "No se pudo Recibir API", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseDocumentos> call, Throwable t) {
                tvInfoDocs.setText(t.getMessage());
            }
        });

        Toast.makeText(this,"Actualizar Archivos", Toast.LENGTH_LONG).show();
    }

}