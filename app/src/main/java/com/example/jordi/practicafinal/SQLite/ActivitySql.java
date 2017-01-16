package com.example.jordi.practicafinal.SQLite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jordi.practicafinal.R;

public class ActivitySql extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql);

        Button btn = (Button)findViewById(R.id.crear);
        final EditText nombrebbdd = (EditText)findViewById(R.id.name);
        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {


                Intent intent = new Intent (v.getContext(),ActivitySql2.class);
                String name=nombrebbdd.getText().toString();
                if (name.equals("")){

                    prueba1(v);

                } else {
                    intent.putExtra("nombre", name);
                    startActivity(intent);
                }

            }


        });
    }

    public void prueba1(View v) {
        Toast toast = Toast.makeText(this, "La BBDD debe tener un nombre", Toast.LENGTH_SHORT);
        toast.show();
    }




}
