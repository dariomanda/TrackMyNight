package at.mandic.trackmynight;

import android.database.Cursor;
import android.provider.CallLog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CallReports extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_reports);
        ListView callLogs = (ListView) findViewById(R.id.callLogs);

        Cursor managedCursor = managedQuery(CallLog.Calls.CONTENT_URI, null, null, null, null);
        ReadCallLogs logs = new ReadCallLogs();

        ArrayList<String> numbers = new ArrayList<>(logs.getNumbers(managedCursor));
        ArrayList<String> types = new ArrayList<>(logs.getTypes(managedCursor));
        ArrayList<String> durations = new ArrayList<>(logs.getDurations(managedCursor));
        ArrayList<String> dates = new ArrayList<>(logs.getDates(managedCursor));

        //Testen der Ausgabe

        ArrayList<String> completeList = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            completeList.add("Anruflog "+String.valueOf(i+1)+":");
            completeList.add("Rufnummer: "+numbers.get(i));
            completeList.add("Art: "+types.get(i));
            completeList.add("Anrufdauer: "+durations.get(i)+" Sekunden");
            completeList.add("Uhrzeit: "+dates.get(i));
        }
        if(numbers.isEmpty()){
            completeList.add("Keine Anrufe. Du warst wohl nicht betrunken!");
        }
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, completeList);
        callLogs.setAdapter(adapter);
    }

}
