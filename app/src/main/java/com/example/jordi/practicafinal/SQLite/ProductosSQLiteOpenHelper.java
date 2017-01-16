package com.example.jordi.practicafinal.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ProductosSQLiteOpenHelper extends SQLiteOpenHelper {

    String sqlCreate = "CREATE TABLE Productes (identificador INTEGER, tipus TEXT, marca TEXT, nom TEXT, preu REAL)";

    public ProductosSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Productes");

        db.execSQL(sqlCreate);

    }
}
