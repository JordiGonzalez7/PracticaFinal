package com.example.jordi.practicafinal.SQLite;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jordi.practicafinal.ProductosSQLiteOpenHelper;
import com.example.jordi.practicafinal.R;

public class ActivitySql2 extends AppCompatActivity {

    private TextView bbddnombre,res;
    private String NombreBBDD;
    private EditText id,type,brand,name,price;
    private Button btnInsertar,btnEliminar,btnConsultar,btnModificar,btnlimpiar;
    private SQLiteDatabase db;
    private ProductosSQLiteOpenHelper DBPRODUCTS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql2);

        res = (TextView) findViewById(R.id.resultadoConsulta);
        bbddnombre = (TextView) findViewById(R.id.bbddname);
        btnInsertar = (Button)findViewById(R.id.insertar);
        btnModificar = (Button)findViewById(R.id.actu);
        btnEliminar = (Button)findViewById(R.id.eliminar);
        btnConsultar = (Button)findViewById(R.id.consultar);
        btnlimpiar = (Button)findViewById(R.id.limpiar);
        id = (EditText) findViewById(R.id.idpro);
        type = (EditText) findViewById(R.id.tipo);
        brand = (EditText) findViewById(R.id.marca);
        name = (EditText) findViewById(R.id.nom);
        price = (EditText) findViewById(R.id.preu);



        final Intent intent = getIntent();
        Bundle extras=intent.getExtras();
        if  (extras != null) {
            NombreBBDD= (String) extras.get("nombre");
            bbddnombre.setText("BBDD: "+NombreBBDD);
        }

         DBPRODUCTS = new ProductosSQLiteOpenHelper(this, NombreBBDD , null, 1);

            db = DBPRODUCTS.getWritableDatabase();


        if(db != null)
        {
            db.execSQL("INSERT INTO Productes VALUES (10001,'Impresora','canon','pixma mg2550S',39.91)");
            db.execSQL("INSERT INTO Productes VALUES (10002,'Impresora','hp','desjet 2130',49.99)");
            db.execSQL("INSERT INTO Productes VALUES (10003,'Portatil','asus','f540lj-xx439t',499.00)");
            db.execSQL("INSERT INTO Productes VALUES (10004,'Portatil','msi','gp62mvr 6rf',1299.00)");
            db.execSQL("INSERT INTO Productes VALUES (10005,'Antivirus','kaspersky','1 equipo 2017 base',29.95)");
            //Mis entradas
            db.execSQL("INSERT INTO Productes VALUES (10006,'Portatil','apple','macbookPro',1327.00)");
            db.execSQL("INSERT INTO Productes VALUES (10007,'Raton','madcatz','mad catz r.a.t 5',56.95)");
            db.execSQL("INSERT INTO Productes VALUES (10008,'Alfombrilla','sharkon','sharkon keto',7.75)");
            db.execSQL("INSERT INTO Productes VALUES (10009,'Monitor','acer','acer v196hqlab ',69.00)");
            db.execSQL("INSERT INTO Productes VALUES (10010,'Tarjet Grafica','nvidia','gtx1080 g1 8gb',714.00)");
            //todos los productos los he sacado de https://www.pccomponentes.com/.
            db.close();

        }




        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db = DBPRODUCTS.getWritableDatabase();
                boolean pasa=true;

                    String ID = id.getText().toString();
                    String TIPO = type.getText().toString();
                    String MARCA = brand.getText().toString();
                    String NOMBRE = name.getText().toString();
                    String PRECIO = price.getText().toString();

                if (ID.equals("") || TIPO.equals("") || MARCA.equals("") || NOMBRE.equals("") || PRECIO.equals("") ) {

                    Toast toast = Toast.makeText(getApplicationContext(), "Faltan campos por rellenar", Toast.LENGTH_SHORT);
                    toast.show();
                    db.close();

                 } else {



                    Cursor c = db.rawQuery("SELECT identificador FROM Productes", null);

                    if (c.moveToFirst()) {

                        do {
                            String cod = c.getString(0);
                            if (cod.equals(ID)) {

                                pasa=false;

                            }

                            } while((c.moveToNext()) && (pasa));
                    }

                                if (pasa) {

                                    ContentValues nuevoRegistro = new ContentValues();
                                    nuevoRegistro.put("identificador", ID);
                                    nuevoRegistro.put("tipus", TIPO);
                                    nuevoRegistro.put("marca", MARCA);
                                    nuevoRegistro.put("nom", NOMBRE);
                                    nuevoRegistro.put("preu", PRECIO);
                                    db.insert("Productes", null, nuevoRegistro);



                                    Toast.makeText(getApplicationContext(), "Entrada insertada",
                                            Toast.LENGTH_LONG).show();
                                    db.close();
                                } else {

                                    Toast.makeText(getApplicationContext(), "Id repetida, inserta una diferente",
                                            Toast.LENGTH_LONG).show();
                                    db.close();

                                }


                }
            }
        });



        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = DBPRODUCTS.getWritableDatabase();

                String ID = id.getText().toString();
                String TIPO = type.getText().toString();
                String MARCA = brand.getText().toString();
                String NOMBRE = name.getText().toString();
                String PRECIO = price.getText().toString();


                if (ID.equals("") || ( !TIPO.equals("") || !MARCA.equals("") || !NOMBRE.equals("") || !PRECIO.equals("")) ) {

                    Toast toast = Toast.makeText(getApplicationContext(), "Debes introducir solo el ID a eliminar", Toast.LENGTH_SHORT);
                    toast.show();
                    db.close();
                    }else{
                    db.delete("Productes", "identificador=" + ID, null);

                    Toast.makeText(getApplicationContext(), "Entrada eliminada",
                            Toast.LENGTH_LONG).show();
                    db.close();

                    }

            }
        });


        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db = DBPRODUCTS.getWritableDatabase();


                String ID = id.getText().toString();
                String TIPO = type.getText().toString();
                String MARCA = brand.getText().toString();
                String NOMBRE = name.getText().toString();
                String PRECIO = price.getText().toString();

                if (ID.equals("") || TIPO.equals("") || MARCA.equals("") || NOMBRE.equals("") || PRECIO.equals("") ) {

                    Toast toast = Toast.makeText(getApplicationContext(), "Faltan campos por rellenar", Toast.LENGTH_SHORT);
                    toast.show();
                    } else {

                    ContentValues valores = new ContentValues();

                    valores.put("tipus",TIPO);
                    valores.put("marca",MARCA);
                    valores.put("nom",NOMBRE);
                    valores.put("preu",PRECIO);
                    db.update("Productes", valores, "identificador=" +ID , null);

                    Toast.makeText(getApplicationContext(), "Entrada modificada",
                            Toast.LENGTH_LONG).show();

                    }



            }
        });



        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db = DBPRODUCTS.getWritableDatabase();


                String ID ;
                String TIPO;
                String MARCA;
                String NOMBRE;
                String PRECIO;
                String concat="";
                Cursor c;
                String[] campos = new String[] {"identificador", "tipus", "marca", "nom", "preu"};
                String[] args;



                        /*
                        if(!id.getText().toString().equals("")){

                            args = new String[] {id.getText().toString()};

                            c = db.query("Productes", campos, "identificador=?", args, null, null, null);



                            if (c.moveToFirst()) {

                                do {



                                    ID = c.getString(0);
                                    TIPO = c.getString(1);
                                    MARCA = c.getString(2);
                                    NOMBRE = c.getString(3);
                                    PRECIO = c.getString(4);


                                    concat +=(" " + ID + " - " + TIPO + " - " + MARCA + " - " + NOMBRE + " - " + PRECIO + "\n");


                                } while (c.moveToNext());

                            }

                        }

                        if(!type.getText().toString().equals("")){

                            args = new String[] {type.getText().toString()};

                            c = db.query("Productes", campos, "tipus=?", args, null, null, null);

                            if (c.moveToFirst()) {

                                do {



                                    ID = c.getString(0);
                                    TIPO = c.getString(1);
                                    MARCA = c.getString(2);
                                    NOMBRE = c.getString(3);
                                    PRECIO = c.getString(4);


                                    concat +=(" " + ID + " - " + TIPO + " - " + MARCA + " - " + NOMBRE + " - " + PRECIO + "\n");


                                } while (c.moveToNext());

                            }


                        }

                        if(!brand.getText().toString().equals("")){

                            args = new String[] {brand.getText().toString()};

                            c = db.query("Productes", campos, "marca=?", args, null, null, null);


                            if (c.moveToFirst()) {

                                do {



                                    ID = c.getString(0);
                                    TIPO = c.getString(1);
                                    MARCA = c.getString(2);
                                    NOMBRE = c.getString(3);
                                    PRECIO = c.getString(4);


                                    concat +=(" " + ID + " - " + TIPO + " - " + MARCA + " - " + NOMBRE + " - " + PRECIO + "\n");


                                } while (c.moveToNext());

                            }


                        }

                        if(!name.getText().toString().equals("")){

                            args = new String[] {name.getText().toString()};

                            c = db.query("Productes", campos, "nom=?", args, null, null, null);


                            if (c.moveToFirst()) {

                                do {



                                    ID = c.getString(0);
                                    TIPO = c.getString(1);
                                    MARCA = c.getString(2);
                                    NOMBRE = c.getString(3);
                                    PRECIO = c.getString(4);


                                    concat +=(" " + ID + " - " + TIPO + " - " + MARCA + " - " + NOMBRE + " - " + PRECIO + "\n");


                                } while (c.moveToNext());

                            }


                        }

                        if(!price.getText().toString().equals("")){


                            args = new String[] {price.getText().toString()};

                            c = db.query("Productes", campos, "preu=?", args, null, null, null);


                            if (c.moveToFirst()) {

                                do {



                                    ID = c.getString(0);
                                    TIPO = c.getString(1);
                                    MARCA = c.getString(2);
                                    NOMBRE = c.getString(3);
                                    PRECIO = c.getString(4);


                                    concat +=(" " + ID + " - " + TIPO + " - " + MARCA + " - " + NOMBRE + " - " + PRECIO + "\n");


                                } while (c.moveToNext());

                            }

                        }
                        */
                if (id.getText().toString().equals("") && type.getText().toString().equals("") && brand.getText().toString().equals("") && name.getText().toString().equals("") && price.getText().toString().equals("")){
                    c = db.rawQuery("SELECT * FROM Productes", null);


                    if (c.moveToFirst()) {

                        do {
                            ID = c.getString(0);
                            TIPO = c.getString(1);
                            MARCA = c.getString(2);
                            NOMBRE = c.getString(3);
                            PRECIO = c.getString(4);


                            concat +=(" " + ID + " - " + TIPO + " - " + MARCA + " - " + NOMBRE + " - " + PRECIO + "\n");

                        } while (c.moveToNext());

                    }

                    concat+=("\n");
                    res.setText(concat);
                    db.close();
                } else

                if(!id.getText().toString().equals("") && type.getText().toString().equals("") && brand.getText().toString().equals("") && name.getText().toString().equals("") && price.getText().toString().equals("")){


                    args = new String[] {id.getText().toString()};

                    c = db.query("Productes", campos, "identificador=?", args, null, null, null);

                    if (c.moveToFirst()) {

                        do {
                            ID = c.getString(0);
                            TIPO = c.getString(1);
                            MARCA = c.getString(2);
                            NOMBRE = c.getString(3);
                            PRECIO = c.getString(4);


                            concat +=(" " + ID + " - " + TIPO + " - " + MARCA + " - " + NOMBRE + " - " + PRECIO + "\n");

                        } while (c.moveToNext());

                    }


                    concat+=("\n");
                    res.setText(concat);
                    db.close();
                }else  {

                    Toast toast = Toast.makeText(getApplicationContext(), "Debes introducir solo el ID a consultar", Toast.LENGTH_SHORT);
                    toast.show();
                    db.close();
                }




            }



        });

        btnlimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ID = id.getText().toString();
                String TIPO = type.getText().toString();
                String MARCA = brand.getText().toString();
                String NOMBRE = name.getText().toString();
                String PRECIO = price.getText().toString();

                if (ID.equals("") && TIPO.equals("") && MARCA.equals("") && NOMBRE.equals("") && PRECIO.equals("") ) {

                    Toast.makeText(getApplicationContext(), "Entradas vacias",
                            Toast.LENGTH_LONG).show();
                }else{
                    id.setText("");
                    type.setText("");
                    brand.setText("");
                    name.setText("");
                    price.setText("");

                    res.setText("");



                    Toast.makeText(getApplicationContext(), "Entradas vaciadas",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }








}
