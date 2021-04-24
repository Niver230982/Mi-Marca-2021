package com.niverarrigonni.mimarca;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DocumentacionActivity extends AppCompatActivity {

    private ArrayList<Documentos> listadocs;
    private Button actualizar;
    private ListView lv1;
    private TextView tvInfoDocs;
    //private Uss uss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documentacion);

        Date fecha = new Date(Calendar.DATE);
        actualizar = findViewById(R.id.actualizar);
        tvInfoDocs = findViewById(R.id.tvInfoDocs);

        listadocs = new ArrayList<Documentos>();

        AdaptadorDocumentos adaptador = new AdaptadorDocumentos (this);
        lv1 = findViewById(R.id.list1);
        lv1.setAdapter(adaptador);
        lv1.setAdapter(adaptador);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                Toast.makeText(DocumentacionActivity.this,listadocs.get(i).getNombre(), Toast.LENGTH_LONG).show();
            }
        });

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
            textView1.setText(listadocs.get(position).getNombre());

            ImageView imageView1 = item.findViewById(R.id.imageView);
            imageView1.setImageResource(R.drawable.icon_doc);
            return (item);
        }
    }
    public void Actualizar(View view){
        Toast.makeText(this,"Actualizar Archivos", Toast.LENGTH_LONG).show();
    }

}