package com.example.labo1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class liste_comptes_delinquants extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_comptes_delinquants);

        final DataBaseHelper dataBaseHelper = new DataBaseHelper(this);

        Button compteDelinquant = (Button) findViewById(R.id.listeCompteDelinquant);

        compteDelinquant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Cursor cursor = dataBaseHelper.ListeCompteDelinquant();

                if(cursor.getCount() > 0)
                {
                    StringBuffer stringBuffer = new StringBuffer();
                    while (cursor.moveToNext())
                    {
                        stringBuffer.append("NOM : " + cursor.getString(0) + "\n");
                        stringBuffer.append("PRENOM : " + cursor.getString(1) + "\n");
                        stringBuffer.append("EMAIL : " + cursor.getString(2) + "\n");
                        stringBuffer.append("CREDIT : " + cursor.getDouble(3) + "\n\n");
                    }
                    ShowMessage("DATA", stringBuffer.toString());

                }
                else
                {
                    ShowMessage("Erreur", "Aucune donnée");
                }

            }
        });
    }


    public void ShowMessage(String title, String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}