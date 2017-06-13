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

        Button callsReport = (Button)findViewById(R.id.calls);
        callsReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callsReport(v);
            }
        });
    }
    public void callsReport(View view){
        ReadCallLogs logs = new ReadCallLogs();


        Intent callReports = new Intent(this, CallReports.class);
        startActivity(callReports);
    }
}
