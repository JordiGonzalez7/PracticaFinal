package com.example.jordi.practicafinal.StartActivityForResult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jordi.practicafinal.R;
import com.example.jordi.practicafinal.calculadoraShared.SharedPrefs;
import com.example.jordi.practicafinal.intents.intent1;

public class StartActivityFor extends AppCompatActivity {

    private final static int Marca = 0;
    private final static int Tipo = 1;
    EditText tipo, marca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_for);

        tipo = (EditText)findViewById(R.id.tipotxt);
        marca = (EditText)findViewById(R.id.marcatxt);
    }


    public void rellenarTipo(View v) {
        Intent i = new Intent(this, StartActivityFor2.class);
        startActivityForResult(i, Tipo);
    }
    public void rellenarMarca(View v) {
        Intent i = new Intent(this, StartActivityFor2.class);
        startActivityForResult(i, Marca);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "Resultado cancelado", Toast.LENGTH_SHORT).show();
        } else {
            String resultado = data.getExtras().getString("RESULTADO");
            switch (requestCode) {
                case Tipo:
                    tipo.setText(resultado);
                    break;
                case Marca:
                    marca.setText(resultado);
                    break;
            }
        }
    }
}
