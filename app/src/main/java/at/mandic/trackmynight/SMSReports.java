package at.mandic.trackmynight;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SMSReports extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smsreports);
        ListView smsList = (ListView) findViewById(R.id.smsList);
        Cursor cursor = getContentResolver().query(Uri.parse("content://sms"), null, null, null, null);
        ReadSMSLogs logs = new ReadSMSLogs();

        ArrayList<String> numbers = new ArrayList<>(logs.getNumbers(cursor));
        ArrayList<String> dates = new ArrayList<>(logs.getDates(cursor));
        ArrayList<String> bodys = new ArrayList<>(logs.getBodys(cursor));
        ArrayList<String> types = new ArrayList<>(logs.getTypes(cursor));

        // Testen Der Ausgabe

        ArrayList<String> completeList = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            completeList.add("SMS Log "+String.valueOf(i+1)+":");
            completeList.add("Nummer: "+numbers.get(i));
            completeList.add("Postfach: "+types.get(i));
            completeList.add("Inhalt: "+bodys.get(i));
            completeList.add("Uhrzeit: "+dates.get(i));
        }

        if(numbers.isEmpty()){
            completeList.add("Keine SMS. Du warst wohl nicht betrunken!");
        }

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, completeList);
        smsList.setAdapter(adapter);
    }
}
