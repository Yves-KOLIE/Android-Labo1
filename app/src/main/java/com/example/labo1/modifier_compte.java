package com.example.labo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class modifier_compte extends AppCompatActivity
{
    private Button UpdatePassword; // Button pour éffectuer une mise à jour

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier_compte);

        UpdatePassword = (Button) findViewById(R.id.updateAccount);
        UpdatePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DataBaseHelper dataBaseHelper = new DataBaseHelper(modifier_compte.this);

                TextView textViewEmail = (TextView) findViewById(R.id.email);
                String email = textViewEmail.getText().toString();

                TextView oldPassword = (TextView) findViewById(R.id.Ancienpassword);
                String ancienPassword = oldPassword.getText().toString();

                TextView newPassword = (TextView) findViewById(R.id.Nouveaupassword);
                String NouveauPassword = newPassword.getText().toString();

                boolean update = dataBaseHelper.UpdateCompte(email, NouveauPassword);
                if (update == true){
                    textViewEmail.setText("");
                    oldPassword.setText("");
                    newPassword.setText("");
                    Toast.makeText(getApplicationContext(),"Mise à jour Ok !",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(),"Erreur de mise à jour",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}