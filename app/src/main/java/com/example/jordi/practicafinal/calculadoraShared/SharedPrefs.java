package com.example.jordi.practicafinal.calculadoraShared;


import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.jordi.practicafinal.R;


public class SharedPrefs extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_prefs);


        TextView tv = (TextView) findViewById(R.id.resu);

        SharedPreferences prefs =
                getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

        String res = prefs.getString("resultado",null);
        tv.setText(res);

    }



    Double numero1, numero2, resultado;
    String operador;

    public void onClickIgual(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.resu);
        numero2 = Double.parseDouble(tv.getText().toString());

        if(operador.equals("+"))
        {
            resultado= numero1+numero2;
        }
        else if(operador.equals("-"))
        {
            resultado= numero1-numero2;
        }
        else if(operador.equals("*"))
        {
            resultado= numero1*numero2;
        }
        else if(operador.equals("/"))
        {
            resultado= numero1/numero2;
        }


        tv.setText(String.format("%.2f",resultado));
    }

    public void onClickSuma(View miView)
    {
        operador="+";
        onClickOperacionCapturaNumero1(miView);
    }
    public void onClickResta(View miView)
    {
        operador="-";
        onClickOperacionCapturaNumero1(miView);
    }
    public void onClickMultiplicacion(View miView)
    {
        operador="*";
        onClickOperacionCapturaNumero1(miView);
    }
    public void onClickDivision(View miView)
    {
        operador="/";
        onClickOperacionCapturaNumero1(miView);
    }

    public void onClickOperacionCapturaNumero1(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.resu) ;
        numero1 = Double.parseDouble(tv.getText().toString());
        tv.setText("");
    }

    public void onClickLimpia(View miView)
    {
        numero1=0.0;
        numero2=0.0;
        TextView tv = (TextView) findViewById(R.id.resu) ;
        tv.setText("");
    }

    public void onClickBtn1(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.resu) ;
        tv.setText(tv.getText() + "1");
    }
    public void onClickBtn2(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.resu) ;
        tv.setText(tv.getText() + "2");
    }
    public void onClickBtn3(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.resu) ;
        tv.setText(tv.getText() + "3");
    }
    public void onClickBtn4(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.resu) ;
        tv.setText(tv.getText() + "4");
    }
    public void onClickBtn5(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.resu) ;
        tv.setText(tv.getText() + "5");
    }
    public void onClickBtn6(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.resu) ;
        tv.setText(tv.getText() + "6");
    }
    public void onClickBtn7(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.resu) ;
        tv.setText(tv.getText() + "7");
    }
    public void onClickBtn8(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.resu) ;
        tv.setText(tv.getText() + "8");
    }
    public void onClickBtn9(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.resu) ;
        tv.setText(tv.getText() + "9");
    }
    public void onClickBtn0(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.resu) ;
        tv.setText(tv.getText() + "0");
    }
    public void onClickBtnPunto(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.resu) ;
        tv.setText(tv.getText() + ".");
    }

    public void onClickBtnGuardar(View miView){


        SharedPreferences prefs =
                getSharedPreferences("MisPreferencias",Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("resultado", resultado.toString());
        editor.commit();



    }

}



