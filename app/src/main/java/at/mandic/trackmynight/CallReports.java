package at.mandic.trackmynight;

import android.database.Cursor;
import android.provider.CallLog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class CallReports extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_reports);
        TextView log = (TextView) findViewById(R.id.callList);
        log.setText(getCallDetails());
        addLogs();
        einfuegen();

    }

    public ArrayList<ArrayList> addLogs(){
        Cursor managedCursor = managedQuery(CallLog.Calls.CONTENT_URI, null, null, null, null);
        ArrayList<ArrayList> callLog = new ArrayList();
        ArrayList logs =  new ArrayList();

        int number = managedCursor.getColumnIndex(CallLog.Calls.NUMBER);
        while (managedCursor.moveToNext()){
            Long callDate = Long.parseLong(managedCursor.getString(managedCursor.getColumnIndex(android.provider.CallLog.Calls.DATE)));
            if(callDate >= Global.startzeit && callDate <= Global.endzeit){
                String phNumber = managedCursor.getString(number);
                logs.add(phNumber);
                callLog.add(logs);
            }
        }
        return callLog;
    }
    public void einfuegen() {
        TextView log2 = (TextView) findViewById(R.id.callList2);
        for (int i = 0; i < addLogs().size(); i++) {
            String numbers = (String) addLogs().get(i).get(i);

            log2.setText(numbers+"\n");
        }
    }
    private String getCallDetails() {

        StringBuffer sb = new StringBuffer();
        Cursor managedCursor = managedQuery(CallLog.Calls.CONTENT_URI, null, null, null, null);
        int number = managedCursor.getColumnIndex(CallLog.Calls.NUMBER);
        int type = managedCursor.getColumnIndex(CallLog.Calls.TYPE);
        int date = managedCursor.getColumnIndex(CallLog.Calls.DATE);
        int duration = managedCursor.getColumnIndex(CallLog.Calls.DURATION);
        sb.append("Call Details :");
        while (managedCursor.moveToNext()) {
            Long callDate = Long.parseLong(managedCursor.getString(managedCursor.getColumnIndex(android.provider.CallLog.Calls.DATE)));

              if(callDate >= Global.startzeit && callDate <= Global.endzeit) {
                String phNumber = managedCursor.getString(number);
                String callType = managedCursor.getString(type);
                String callDuration = managedCursor.getString(duration);
                String dir = null;
                int dircode = Integer.parseInt(callType);
                switch (dircode) {
                    case CallLog.Calls.OUTGOING_TYPE:
                        dir = "OUTGOING";
                        break;

                    case CallLog.Calls.INCOMING_TYPE:
                        dir = "INCOMING";
                        break;

                    case CallLog.Calls.MISSED_TYPE:
                        dir = "MISSED";
                        break;
                }
                sb.append("\nPhone Number:--- " + phNumber + " \nCall Type:--- "
                        + dir + " \nCall Date:--- " + Global.convertDate(callDate)//callDayTime
                        + " \nCall duration in sec :--- " + callDuration);
                sb.append("\n----------------------------------");
            }
        }
        managedCursor.close();
        return sb.toString();

    }
}
