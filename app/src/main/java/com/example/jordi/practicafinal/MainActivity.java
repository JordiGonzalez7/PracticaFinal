package com.example.jordi.practicafinal;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.jordi.practicafinal.SQLite.ActivitySql;
import com.example.jordi.practicafinal.calculadoraShared.SharedPrefs;
import com.example.jordi.practicafinal.intents.intent1;
import com.example.jordi.practicafinal.memorias.Memorias;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button)findViewById(R.id.IntentID);
        Button btn2 = (Button)findViewById(R.id.shared);
        Button btn3 = (Button)findViewById(R.id.sql);
        Button btn4 = (Button)findViewById(R.id.ficheros);

        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(),intent1.class);
                startActivityForResult(intent, 0);

            }


        });

        btn2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(),SharedPrefs.class);
                startActivityForResult(intent, 0);

            }


        });

        btn3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(),ActivitySql.class);
                startActivityForResult(intent, 0);

            }


        });

        btn4.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(),Memorias.class);
                startActivityForResult(intent, 0);

            }


        });





    }
}
