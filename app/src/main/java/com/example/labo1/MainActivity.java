package com.example.labo1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import open.activity.OpenActivity;

public class MainActivity extends AppCompatActivity
{
    private Button btnCreateAccount; // Bouton pour ouvrir la page de creation d'un compte
    private Button btnSupressAccount; // Bouton pour supprimer un compte
    private Button btnUpdateAccount; // Boutton pour la modification d'un compte
    private Button btnInfosAccount; // Boutton pour les infos d'un compte
    private Button btnOffendersAccount; // Button pour la liste des compte delinquants
    private Button bntCreditChange; // Cutton pour la modification du crédit
    private Button bntUpdateBalance; // Cutton pour la modification du crédit

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instanciation de la Class contenant le code de la Base de données
        DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);

        // Ouvrir l'activite creation de compte
        btnCreateAccount = (Button) findViewById(R.id.creationCompte);
        btnCreateAccount.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                CreateAccount();
            }
        });

        // Ouvrir l'activite pour la suppression d'un compte
        btnSupressAccount = (Button) findViewById(R.id.supprimerCompte);
        btnSupressAccount.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                SuppressAccount();
            }
        });

        // Ouvrir l'activite pour la Modification d'un compte
        btnUpdateAccount = (Button) findViewById(R.id.modifierCompte);
        btnUpdateAccount.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                UpdateAccount();
            }
        });


        // Ouvrir l'activite pour obtenir les infos d'un compte
        btnInfosAccount = (Button) findViewById(R.id.infosCompte);
        btnInfosAccount.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                InfosAccount();
            }
        });

        // Ouvrir l'activite pour obtenir des comptes delinquants
        btnOffendersAccount = (Button) findViewById(R.id.listeCompteDelinquant);
        btnOffendersAccount.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                OffendersAccount();
            }
        });

        // Ouvrir l'activite pour la modification du crédit
        bntCreditChange = (Button) findViewById(R.id.modifierCreditCompte);
        bntCreditChange.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                CreditChange();
            }
        });


        // Ouvrir l'activite pour la modification du solde
        bntUpdateBalance = (Button) findViewById(R.id.modifierSoldeCompte);
        bntUpdateBalance.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                UpdateBalance();
            }
        });



    }

    // Pour la creation de compte
    public void CreateAccount()
    {
        Intent intent = new Intent(this, CreationCompte.class);
        startActivity(intent);
    }

    // Pour la suppression d'un compte
    public void SuppressAccount()
    {
        Intent intent = new Intent(this, suppression_compte.class);
        startActivity(intent);
    }

    // Pour la modification d'un compte
    private void UpdateAccount()
    {
        Intent intent = new Intent(this, modifier_compte.class);
        startActivity(intent);
    }

    // Pour l'obtension des infos d'un compte
    private void InfosAccount()
    {
        Intent intent = new Intent(this, informations_compte.class);
        startActivity(intent);
    }

    // Pour l'obtension de la liste des comptes delinquants
    private void OffendersAccount()
    {
        Intent intent = new Intent(this, liste_comptes_delinquants.class);
        startActivity(intent);
    }

    // Pour la modification du crédit
    private void CreditChange()
    {
        Intent intent = new Intent(this, modification_credit.class);
        startActivity(intent);
    }

    // Pour la modification du solde
    private void UpdateBalance()
    {
        Intent intent = new Intent(this, modification_solde.class);
        startActivity(intent);
    }

}