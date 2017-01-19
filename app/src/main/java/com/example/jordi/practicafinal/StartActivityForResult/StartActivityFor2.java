package com.example.jordi.practicafinal.StartActivityForResult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jordi.practicafinal.R;

public class StartActivityFor2 extends AppCompatActivity {

    Button btnAceptar, btnCancelar;
    EditText result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_for2);

        btnAceptar = (Button)findViewById(R.id.good);
        btnCancelar = (Button)findViewById(R.id.bad);
        result = (EditText)findViewById(R.id.etxt);


        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (result.getText().length() != 0) {
                    String resultado = result.getText().toString();
                    Intent i = getIntent();
                    i.putExtra("RESULTADO", resultado);
                    setResult(RESULT_OK, i);
                    finish();

                } else {
                    Toast.makeText(StartActivityFor2.this, "No se ha introducido nada en el campo de texto", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();

            }
        });


    }
}
