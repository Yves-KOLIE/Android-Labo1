//package com.example.labo1;
//
//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//import android.database.sqlite.SQLiteTableLockedException;
//import android.util.Log;
//
//public class DataBaseManager extends SQLiteOpenHelper
//{
//    private  static  final String DATABASE_NAME = "Labo1Fernand.db";
//    private  static  final int DATABASE_VERSION = 1;
//
//    public DataBaseManager(Context context)
//    {
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db)
//    {
//        try
//        {
//            String clients = " CREATE TABLE clients ("
//
//                    + " email TEXT NOT NULL,"
//                    + " nom TEXT NOT NULL,"
//                    + " prenom TEXT NOT NULL,"
//                    + " phone TEXT NOT NULL,"
//                    + " password TEXT NOT NULL,"
//                    + " CONSTRAINT pk_clients PRIMARY KEY (email)" +
//                    ")";
//            db.execSQL(clients);
//
//            String compte = " CREATE TABLE compte ("
//
//                    + " email TEXT NOT NULL,"
//                    + " solde REAL NOT NULL,"
//                    + " credit REAL NOT NULL"
//                    + " CONSTRAINT pk_compte PRIMARY KEY (email) REFERENCES clients(email)" +
//                    ")";
//
//            db.execSQL(compte);
//
//        }catch (SQLiteTableLockedException ex)
//        {
//            Log.i("DATABASE", "OnCreate ERROR");
//        }
//
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
//    {
//        String dropTableCompte = "DROP TABLE compte";
//        db.execSQL(dropTableCompte);
//
//        String dropTableClient = "DROP TABLE client";
//        db.execSQL(dropTableClient);
//
//        this.onCreate(db);
//
//        Log.i("DATABASE", "onUpgrade invoked");
//
//    }
//
//    public void inscription(String email, String nom, String prenom, String phone, String password)
//    {
//        email.replace("'", "''");
//        nom.replace("'", "''");
//        prenom.replace("'", "''");
//        phone.replace("'", "''");
//
//        try
//        {
//            String inscription = " INSERT INTO clients VALUES ('" + email + "', '" + nom + "', '" + prenom + "', '" + email + "') ";
//
//            this.getWritableDatabase().execSQL(inscription);
//        }
//        catch (SQLiteTableLockedException ex)
//        {
//            Log.i("DATABASE", "inscription ERROR");
//        }
//
//
//    }
//}
