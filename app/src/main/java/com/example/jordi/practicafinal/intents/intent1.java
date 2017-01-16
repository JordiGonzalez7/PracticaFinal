package com.example.jordi.practicafinal.intents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jordi.practicafinal.R;

public class intent1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent1);

        Button btn = (Button)findViewById(R.id.enviar);
        final EditText tlf = (EditText)findViewById(R.id.tlf);

        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),intent2.class);
                String tlfpas=tlf.getText().toString();
                if (tlfpas.equals("")){

                    prueba1(v);

                } else {
                    i.putExtra("Telefono",tlfpas);
                    startActivity(i);
                }

            }


        });

    }

    public void prueba1(View v) {
        Toast toast = Toast.makeText(this, "Introduce un numero de tlf porfavor", Toast.LENGTH_SHORT);
        toast.show();
    }
}
