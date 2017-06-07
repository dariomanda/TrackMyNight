package at.mandic.trackmynight;

import android.database.Cursor;
import android.provider.CallLog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CallReports extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_reports);
        TextView log = (TextView) findViewById(R.id.callList);
        log.setText(getCallDetails());

    }
    private String getCallDetails() {

        StringBuffer sb = new StringBuffer();
        Cursor managedCursor = managedQuery(CallLog.Calls.CONTENT_URI, null,
                null, null, null);
        int number = managedCursor.getColumnIndex(CallLog.Calls.NUMBER);
        int type = managedCursor.getColumnIndex(CallLog.Calls.TYPE);
        int date = managedCursor.getColumnIndex(CallLog.Calls.DATE);
        int duration = managedCursor.getColumnIndex(CallLog.Calls.DURATION);
      //  long seconds=Long.parseLong(call);
        sb.append("Call Details :");
        while (managedCursor.moveToNext()) {
            String call = managedCursor.getString(managedCursor.getColumnIndex(android.provider.CallLog.Calls.DATE));
            Long callDate = Long.parseLong(call);
            Long startTime = Long.parseLong(Global.valueStartTime);
            Long endTime = Long.parseLong(Global.valueEndTime);
//            Date callDayTime = new Date(Long.valueOf(callDate));

              if(callDate >= startTime && callDate <= endTime) {String phNumber = managedCursor.getString(number);
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
                        + dir + " \nCall Date:--- " + callDate//callDayTime
                        + " \nCall duration in sec :--- " + callDuration);
                sb.append("\n----------------------------------");
            }
        }
        managedCursor.close();
        return sb.toString();

    }
}
