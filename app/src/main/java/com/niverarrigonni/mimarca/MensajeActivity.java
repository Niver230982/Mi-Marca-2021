package com.niverarrigonni.mimarca;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.niverarrigonni.mimarca.webservices.api.LoginAPI;
import com.niverarrigonni.mimarca.webservices.api.MensajeAPI;
import com.niverarrigonni.mimarca.webservices.models.Mensaje;
import com.niverarrigonni.mimarca.webservices.models.WS;
import com.niverarrigonni.mimarca.webservices.sesion.Sesion;

import java.io.ByteArrayOutputStream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MensajeActivity extends AppCompatActivity {

    public static final int PICK_IMAGE = 1;

    Toolbar toolbar;
    EditText asuntoText;
    EditText mensajeText;
    ImageView imagen;

    private boolean imagenCargada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);

        asuntoText = findViewById(R.id.asuntoText);
        mensajeText = findViewById(R.id.mensajeText);
        imagen= findViewById(R.id.Imagen_Subida);


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void Subir_Archivo(View view) {
        cargarImagen();
    }

    private void cargarImagen() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
//        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//        intent.setType("image/");
//        startActivityForResult(intent.createChooser(intent,"Seleccione la Aplicación"), 10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            Uri path=data.getData();
            imagen.setImageURI(path);
            imagenCargada = true;
        }
    }

    public void enviarMensajeAPI(View view) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://165.227.110.148:8069/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        String doc = Sesion.getInstance().getDocuemnt();
        String asunto = asuntoText.getText().toString() != null ?  asuntoText.getText().toString(): "";
        String msjText =mensajeText.getText().toString() != null ? mensajeText.getText().toString(): "";


        String image = "";
        if(imagenCargada) {
            Drawable drawable = imagen.getDrawable();
            Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG,100,bos);
            byte[] bb = bos.toByteArray();
            image = Base64.encodeToString(bb, Base64.DEFAULT);
        }


        final Mensaje mensaje = new Mensaje(new Mensaje.Params(doc, asunto, msjText, image));

        MensajeAPI mensajeAPI = retrofit.create(MensajeAPI.class);
        Call<Mensaje> call = mensajeAPI.enviar(mensaje);
        call.enqueue(new Callback<Mensaje>() {

            @Override
            public void onResponse(Call<Mensaje> call, Response<Mensaje> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(MensajeActivity.this, "Mensaje enviado", Toast.LENGTH_SHORT).show();
                    } else{
                        Toast.makeText(MensajeActivity.this, "No se pudo enviar el mensaje", Toast.LENGTH_SHORT).show();
                    }
            }

            @Override
            public void onFailure(Call<Mensaje> call, Throwable t) {
                Toast.makeText(MensajeActivity.this,"Error Inesperado", Toast.LENGTH_SHORT).show();
            }
        });
    }
}