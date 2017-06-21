package at.mandic.trackmynight;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

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
        SharedPreferences sharedpreferences = getSharedPreferences("Zeit", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        long start = sharedpreferences.getLong("StartTime", 0);

        if (start == 0) {
            Global.valueStartTime = Global.convertDate(Global.getTime());
            Global.startzeit = Global.getTime();
            editor.putLong("StartTime", Global.startzeit);
            editor.apply();
        }
        startActivity(intent);
    }

    public void Zurücksetzen(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Wircklich zurücksetzen ?");
        builder.setPositiveButton("Ja", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                reset();
            }
        });
        builder.setNegativeButton("Nein", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void reset() {
        TextView countBier = (TextView) findViewById(R.id.cntBier);
        TextView countWein = (TextView) findViewById(R.id.cntWein);
        TextView countSchnaps = (TextView) findViewById(R.id.cntSchnaps);
        TextView countVodka = (TextView) findViewById(R.id.cntVodka);
        TextView countWhisky = (TextView) findViewById(R.id.cntWhisky);
        SharedPreferences sharedpreferences = getSharedPreferences("Getraenke", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        Global.valueStartTime = null;
        Global.valueEndTime = null;
        SharedPreferences sharedpreferenc = getSharedPreferences("Zeit", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedpreferenc.edit();
        edit.putLong("StartTime", 0);
        edit.apply();

        editor.putString("Bier", "0");
        editor.putString("Wein", "0");
        editor.putString("Schnaps", "0");
        editor.putString("Vodka", "0");
        editor.putString("Whisky", "0");
        editor.apply();

        final EditText name = (EditText) findViewById(R.id.editText);
        final EditText height = (EditText) findViewById(R.id.editText2);
        final EditText birthdate = (EditText) findViewById(R.id.editText3);
        final EditText weight = (EditText) findViewById(R.id.editText4);

        final CheckBox maennlich = (CheckBox) findViewById(R.id.checkBox);
        final CheckBox weiblich = (CheckBox) findViewById(R.id.checkBox2);

        SharedPreferences sharedpreferences2 = getSharedPreferences("UserSettings", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor2 = sharedpreferences2.edit();

        editor2.putString("Name", "");
        editor2.putString("Date", "");
        editor2.putString("Weight", "");
        editor2.putString("Height", "");
        editor2.putBoolean("Male", false);
        editor2.putBoolean("Female", false);
        editor2.apply();
    }
}
