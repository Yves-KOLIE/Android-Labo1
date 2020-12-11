package com.example.labo1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.sql.PreparedStatement;

public class Request
{
    private String email;
    private String nom;
    private String prenom;
    private String phone;
    private String password;
    private float solde;
    private float credit;

    public Request(String email, String nom, String prenom, String phone, String password)
    {
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.phone = phone;
        this.password = password;
    }

    public Request(String email, float solde, float credit)
    {
        this.email = email;
        this.solde = solde;
        this.credit = credit;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    public float getCredit() {
        return credit;
    }

    public void setCredit(float credit) {
        this.credit = credit;
    }

    // methode pour la création d'un compte client
//    public void creationCompteClient(String email, String nom, String prenom, String phone, String password, SQLiteDatabase db, Context context)
//    {
//        String insertion = "INSERT INTO clients VALUES(" + email + "," + nom + "," + prenom + "," + "," + phone
//                + "," + password + ")";
//
////        PreparedStatement pstmt = db.prepareStatement("UPDATE EMPLOYEES
////                SET SALARY = ? WHERE ID = ?");
////        pstmt.setBigDecimal(1, 153833.00)
////        pstmt.setInt(2, 110592)
//        // this.db = this.getWritableDatabase().execSQL(insertion);
//        db.execSQL(insertion);
//
//    }
}
