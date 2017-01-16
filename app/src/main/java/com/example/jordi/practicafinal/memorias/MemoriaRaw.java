package com.example.jordi.practicafinal.memorias;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jordi.practicafinal.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MemoriaRaw extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memoria_raw);

        Button btn = (Button) findViewById(R.id.atras);
        TextView txt = (TextView) findViewById(R.id.fichraw);


        String linea = "";

        try
        {
            InputStream fraw =
                    getResources().openRawResource(R.raw.pruebadelraw);

            BufferedReader brin =
                    new BufferedReader(new InputStreamReader(fraw));

            linea = brin.readLine();
            fraw.close();

            Log.i("Ficheros", "Fichero RAW leido");
            Log.i("Ficheros", "Contenido: " + linea);
            txt.setText("Contenido: "+linea);
        }
        catch (Exception ex)
        {
            Log.e("Ficheros", "Error al leer fichero desde recurso raw");;
        }





        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(v.getContext(),Memorias.class);
                startActivityForResult(i, 0);

            }
        });
    }
}
