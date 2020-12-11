package com.example.labo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class suppression_compte extends AppCompatActivity {

    private Button DeleteCompte = null;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suppression_compte);

        this.DeleteCompte = (Button) findViewById(R.id.suppression);

        this.DeleteCompte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Recupération des valeurs du formulaire
                TextView textViewEmail = (TextView) findViewById(R.id.email);
                String email = textViewEmail.getText().toString();

                TextView textViewPassword = (TextView) findViewById(R.id.password);
                String password = textViewPassword.getText().toString();
                // Suppression
                DataBaseHelper dataBaseHelper = new DataBaseHelper(getBaseContext());
                boolean del = dataBaseHelper.DeleteCompte(email, password);
                if(del)
                {
                    // On vide les champs
                    textViewEmail.setText("");
                    textViewPassword.setText("");
                    Toast.makeText(getApplicationContext(),"Suppression Ok !",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Erreur de suppression !",Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}