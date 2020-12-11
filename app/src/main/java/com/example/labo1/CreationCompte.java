package com.example.labo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CreationCompte extends AppCompatActivity {

    private Button inscrireClient; // Button pour inscrire un client

    /*
        Instanciation de la Class qui contient tout le code pour la connexion à la base de données
        Et la manipulation de ces données
    */

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_compte);

        inscrireClient = (Button) findViewById(R.id.inscription);
        inscrireClient.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                /*
                   1- Récupération les données dans les TextView
                   2- Conversion des données en String
                   3- Insertion des données converties dans la base de données
                */

                TextView textViewNom = (TextView) findViewById(R.id.nom);
                String nom = textViewNom.getText().toString();

                TextView textViewPrenom = (TextView) findViewById(R.id.prenom);
                String prenom = textViewPrenom.getText().toString();

                TextView textViewEmail = (TextView) findViewById(R.id.email);
                String email = textViewEmail.getText().toString();

                TextView textViewPhone = (TextView) findViewById(R.id.phone);
                String phone = textViewPhone.getText().toString();

                TextView textViewPassword = (TextView) findViewById(R.id.password);
                String password = textViewPassword.getText().toString();

                DataBaseHelper dataBaseHelper = new DataBaseHelper(CreationCompte.this);

                boolean InsertNewClient = dataBaseHelper.InsertClient(email, nom, prenom, phone, password);
                if(InsertNewClient == true){
                    Toast.makeText(getApplicationContext(),"Insertion Ok !",Toast.LENGTH_LONG).show();
                    textViewEmail.setText("");
                    textViewNom.setText("");
                    textViewPrenom.setText("");
                    textViewPhone.setText("");
                    textViewPassword.setText("");
                }else {
                    Toast.makeText(getApplicationContext(),"Une Erreur s'est produite",Toast.LENGTH_LONG).show();
                }


            }
        });


    }
}