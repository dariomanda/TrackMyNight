package at.mandic.trackmynight;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Reports extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);

        Button smsReports = (Button)findViewById(R.id.sms);
        Button callsReport = (Button)findViewById(R.id.calls);
        callsReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callsReport(v);
            }
        });
        smsReports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                smsReports(v);
            }
        });
    }

    public void promilleberechnen(View view) {
        SharedPreferences sharedpreferences = getSharedPreferences("UserSettings", Context.MODE_PRIVATE);
        String Name = sharedpreferences.getString("Name", "");
        String Alter = sharedpreferences.getString("Date", "0");
        String Gewicht = sharedpreferences.getString("Weight", "0");
        String Groesse = sharedpreferences.getString("Height", "0");
        Boolean GenderMale = sharedpreferences.getBoolean("Male", false);
        Boolean GenderFemale = sharedpreferences.getBoolean("Female", false);


        if (Alter.equals("0") || Gewicht.equals("0") || Groesse.equals("0") || (GenderMale.equals(false) && GenderFemale.equals(false))) {
            Toast.makeText(Reports.this, "User Profil muss vollständig ausgefüllt sein !", Toast.LENGTH_LONG).show();
        } else {
            Berechnung berechnung = new Berechnung(this);
            double promillewert = berechnung.promille(5);
            Toast.makeText(Reports.this, Name + " hat ca. " + promillewert + " Promille ", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, PromilleAuswertungsActivity.class);
            startActivity(intent);
        }
    }

    public void callsReport(View view){
        ReadCallLogs logs = new ReadCallLogs();


        Intent callReports = new Intent(this, CallReports.class);
        startActivity(callReports);
    }

    public void smsReports(View view){
        Intent smsReports = new Intent(this, SMSReports.class);
        startActivity(smsReports);
    }
}
