package com.example.jordi.practicafinal.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jordi.practicafinal.MainActivity;
import com.example.jordi.practicafinal.R;

public class intent2 extends AppCompatActivity {

    TextView tlf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent2);

        tlf = (TextView) findViewById(R.id.tlf);

        Intent intent = getIntent();
        Bundle extras=intent.getExtras();
        if  (extras != null) {
            String TLF= (String) extras.get("Telefono");
            tlf.setText(TLF);
        }

        Button btn = (Button)findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),MainActivity.class);
                startActivityForResult(intent, 0);

            }


        });
    }
}
