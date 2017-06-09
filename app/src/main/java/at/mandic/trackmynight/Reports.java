package at.mandic.trackmynight;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Reports extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);
    }
    public void callsReport(View view){
    Intent callReports = new Intent(this, CallReports.class);
        startActivity(callReports);
    }
}
