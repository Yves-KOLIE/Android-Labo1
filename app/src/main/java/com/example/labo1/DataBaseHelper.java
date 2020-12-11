package com.example.labo1;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper
{
    // Nom de la base de donnée
    private static final String DATABASE_NAME = "labo1.db";
    private static final int DATABASE_VERSION = 2;


    private static final String TABLE_CLIENTS = "clients";
    private static final String COL_EMAIL = "email";
    private static final String COL_NOM = "nom";
    private static final String COL_PRENOM = "prenom";
    private static final String COL_PHONE = "phone";
    private static final String COL_PASSWORD = "password";

    private static final String TABLE_COMPTE= "compte";
    private static final float COLL_SOLDE = 0.0f;
    private static final float COLL_CREDIT = 0.0f;



    public DataBaseHelper(@Nullable Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE " + this.TABLE_CLIENTS + "(email TEXT PRIMARY KEY, nom TEXT NOT NULL, prenom TEXT NOT NULL, phone TEXT NOT NULL, " +
                "password TEXT NOT NULL)");

        db.execSQL("CREATE TABLE " + this.TABLE_COMPTE + "(email TEXT NOT NULL PRIMARY KEY, solde REAL NOT NULL, credit REAL NOT NULL, phone TEXT NOT NULL, " + "FOREIGN KEY(email) REFERENCES clients(email))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + this.TABLE_COMPTE);
        db.execSQL("DROP TABLE IF EXISTS " + this.TABLE_CLIENTS);
        onCreate(db);
    }

    // Insertion Client
    public boolean InsertClient(String email, String nom, String prenom, String phone, String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_EMAIL, email);
        contentValues.put(COL_NOM, nom);
        contentValues.put(COL_PRENOM, prenom);
        contentValues.put(COL_PHONE, phone);
        contentValues.put(COL_PASSWORD, password);
        long result = db.insert(TABLE_CLIENTS, null, contentValues);
        if(result == -1){
            return false;
        }
        else {
            return true;
        }
    }

    // Suppression Compte
    public boolean DeleteCompte(String email, String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "DELETE FROM compte WHERE email = " + email + " AND password = " + password;
        try {
            db.execSQL(sql);
            return true;
        }catch (Exception e){
            return  false;
        }
    }


    // Modification Compte
    public boolean UpdateCompte(String email, String newPassword)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            String sql1 = "UPDATE clients SET password = " + newPassword + "WHERE email = " + email;
            db.execSQL(sql1);
            return true;
            //db.execSQL(sql1);
//            String sql2 = "UPDATE clients SET password = " + newPassword + "WHERE email = " + email;
//            db.execSQL(sql2);
            //return true;
        } catch (Exception e){
            return false;
        }
    }
    // Il faut revoir ce code puisque ça ne marche pas
    public Cursor ListeCompteDelinquant()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery(" SELECT TABLE_CLIENTS.nom, TABLE_CLIENTS.prenom, TABLE_CLIENTS.email, TABLE_COMPTE.credit FROM TABLE_COMPTE, TABLE_CLIENTS WHERE TABLE_CLIENTS.email = TABLE_COMPTE.email  AND  TABLE_COMPTE.credit < ?", new String[]{"0.00f"});
        return res;

    }


}
