package open.activity;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import com.example.labo1.CreationCompte;
import com.example.labo1.MainActivity;

public final class OpenActivity
{
    public static void CreateAccount()
    {
        AppCompatActivity appCompatActivity = new AppCompatActivity();
        Intent intent = new Intent(new MainActivity(), CreationCompte.class); // Intent pour la création de compte
        appCompatActivity.startActivity(intent);
    }
}
