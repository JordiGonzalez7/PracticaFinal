package com.example.jordi.practicafinal.memorias;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.jordi.practicafinal.MainActivity;
import com.example.jordi.practicafinal.R;

public class Memorias extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memorias);

        Button btn = (Button) findViewById(R.id.atras);
        Button btn1 = (Button)findViewById(R.id.interna);
        Button btn2 = (Button)findViewById(R.id.externa);
        Button btn3 = (Button)findViewById(R.id.raw);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(v.getContext(),MainActivity.class);
                startActivityForResult(i, 0);

            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(v.getContext(),Memorias2.class);
                String tipo = "interna";

                    i.putExtra("Tipo",tipo);
                    startActivity(i);




            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(v.getContext(),Memorias2.class);
                String tipo = "externa";

                    i.putExtra("Tipo",tipo);
                    startActivity(i);


            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(v.getContext(),MemoriaRaw.class);
                startActivityForResult(i, 0);

            }
        });




    }
}
