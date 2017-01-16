package com.example.jordi.practicafinal.memorias;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jordi.practicafinal.R;
import com.example.jordi.practicafinal.memorias.Memorias;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class Memorias2 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memorias2);

        final TextView tipo = (TextView)findViewById(R.id.tipo);
        final EditText nombre = (EditText)findViewById(R.id.nombre);
        final EditText texto = (EditText)findViewById(R.id.texto);
        final TextView path = (TextView) findViewById(R.id.ruta);
        Button btn=(Button)findViewById(R.id.atras);
        Button btn2=(Button)findViewById(R.id.crear);


        String TIPO = null;
        Intent intent = getIntent();
        Bundle extras=intent.getExtras();
        if  (extras != null) {
            TIPO= (String) extras.get("Tipo");
            tipo.setText(TIPO);
        }



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(v.getContext(),Memorias.class);
                startActivityForResult(i,0);
            }
        });


        final String finalTIPO = TIPO;
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String nom = nombre.getText().toString();
                String text = texto.getText().toString();







                if(finalTIPO.equals("interna")){

                    try
                    {
                        OutputStreamWriter fout=
                                new OutputStreamWriter(
                                        openFileOutput(nom, Context.MODE_PRIVATE));

                        fout.write(text);
                        fout.close();

                        Toast.makeText(getApplicationContext(),"Todo correcto, fichero creado",
                                Toast.LENGTH_LONG).show();


                    }
                    catch (Exception ex)
                    {

                        Log.e("Ficheros", "Error al escribir fichero a memoria interna");
                        Toast.makeText(getApplicationContext(), "Error",
                                Toast.LENGTH_LONG).show();
                    }

                    path.setText("La ruta es: /data/data/com.example.jordipracticafinal/files");



                }else if(finalTIPO.equals("externa")){

                    boolean sdDisponible = false;
                    boolean sdAccesoEscritura = false;

                    String estado = Environment.getExternalStorageState();

                    File ruta_sd_app_musica = getExternalFilesDir(Environment.DIRECTORY_MUSIC);
                    String rutam= (ruta_sd_app_musica.getAbsolutePath());

                    if (estado.equals(Environment.MEDIA_MOUNTED))
                    {
                        sdDisponible = true;
                        sdAccesoEscritura = true;
                    }
                    else if (estado.equals(Environment.MEDIA_MOUNTED_READ_ONLY))
                    {
                        sdDisponible = true;
                        sdAccesoEscritura = false;
                    }
                    else
                    {
                        sdDisponible = false;
                        sdAccesoEscritura = false;
                    }

                    try
                    {



                        File f = new File(ruta_sd_app_musica.getAbsolutePath(), nom);

                        OutputStreamWriter fout =
                                new OutputStreamWriter(
                                        new FileOutputStream(f));

                        fout.write(text);
                        fout.close();

                        Toast.makeText(getApplicationContext(),"Todo correcto, fichero creado",
                                Toast.LENGTH_LONG).show();
                    }
                    catch (Exception ex)
                    {
                        Log.e("Ficheros", "Error al escribir fichero a tarjeta SD");
                    }

                   path.setText(rutam);








                }else{

                    Toast.makeText(getApplicationContext(), "Error",
                            Toast.LENGTH_LONG).show();

                }
            }
        });

    }

}
