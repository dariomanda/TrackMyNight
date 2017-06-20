package at.mandic.trackmynight;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
