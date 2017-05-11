package at.mandic.trackmynight;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void userprofil(View view) {
        Intent intent = new Intent(this, UserProfilActivity.class);
        startActivity(intent);
    }

    public void getraenkeauswahl(View view) {
        Intent intent = new Intent(this, Drinks.class);
        startActivity(intent);
    }

    public void promilleberechnen(View view) {
        SharedPreferences sharedpreferences = getSharedPreferences("UserSettings", Context.MODE_PRIVATE);
        String Name = sharedpreferences.getString("Name", "");
        double promillewert = promille();
        if (promillewert == 0) {
            Toast.makeText(MainActivity.this, "Keine Getränke ausgewählt", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(MainActivity.this, Name + " hat ca. " + promillewert + " Promille ", Toast.LENGTH_LONG).show();
        }
    }
    

    public double promille() {

        SharedPreferences sharedpreferences = getSharedPreferences("UserSettings", Context.MODE_PRIVATE);
        String Alter = sharedpreferences.getString("Date", "0");
        String Gewicht = sharedpreferences.getString("Weight", "0");
        String Groesse = sharedpreferences.getString("Height", "0");
        Boolean GenderMale = sharedpreferences.getBoolean("Male", false);
        Boolean GenderFemale = sharedpreferences.getBoolean("Female", false);

        int alter = Integer.parseInt(String.valueOf(Alter));
        int masse = Integer.parseInt(String.valueOf(Gewicht));
        int groesse = Integer.parseInt(String.valueOf(Groesse));
        boolean geschlecht = false;

        geschlecht = GenderMale;

        double var1m = 2.447;
        double var2m = 0.09516;
        double var3m = 0.1074;
        double var4m = 0.3362;

        double var1w = -2.097;
        double var2w = 0.07;
        double var3w = 0.1069;
        double var4w = 0.2466;

        double gkw;
        double r;
        double c = 0;
        double A;

        double varx = 1.055;
        double vary = 0.8;

        //Berechnung Gesamt Koerperwasser Maenner
        if (geschlecht) {
            gkw = (var1m - var2m * alter + var3m * groesse + var4m * masse);
        }
        //Berechnung Gesamt Koerperwasser Frauen
        else {
            gkw = (var1w - var2w * alter + var3w * groesse + var4w * masse);
        }
        //Verteilungsfaktor im Koerper
        r = (varx * gkw) / (vary * masse);

        A = alkoholmasse();

        c = (vary * A) / (varx * gkw);
        c = Math.round(1000.0 * c) / 1000.0;

        return c;
    }

    public double alkoholmasse() {

        SharedPreferences sharedpreferences = getSharedPreferences("Getraenke", Context.MODE_PRIVATE);
        String Bier = sharedpreferences.getString("Bier", "");
        String Wein = sharedpreferences.getString("Wein", "");
        String Schnaps = sharedpreferences.getString("Schnaps", "");
        String Vodka = sharedpreferences.getString("Vodka", "");
        String Whisky = sharedpreferences.getString("Whisky", "");

        int bier = Integer.parseInt(String.valueOf(Bier));
        int wein = Integer.parseInt(String.valueOf(Wein));
        int schnaps = Integer.parseInt(String.valueOf(Schnaps));
        int vodka = Integer.parseInt(String.valueOf(Vodka));
        int whisky = Integer.parseInt(String.valueOf(Whisky));

        double biergehalt = 0.05;
        double weingehalt = 0.12;
        double schnapsgehalt = 0.35;
        double vodkagehalt = 0.40;
        double whiskygehalt = 0.43;

        int biereinheit = 500;
        int weineinheit = 125;
        int schnapseinheit = 20;
        int vodkaeinheit = 20;
        int whiskyeinheit = 20;

        double A;
        double p = 0.8;

        double biergesamt = (biereinheit * bier) * biergehalt * p;
        double weingesamt = (weineinheit * wein) * weingehalt * p;
        double schnapsgesamt = (schnapseinheit * schnaps) * schnapsgehalt * p;
        double vodkagesamt = (vodkaeinheit * vodka) * vodkagehalt * p;
        double whiskygesamt = (whiskyeinheit * whisky) * whiskygehalt * p;

        return (biergesamt + weingesamt + schnapsgesamt + vodkagesamt + whiskygesamt);
    }

}
