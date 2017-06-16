package at.mandic.trackmynight;

import android.database.Cursor;
import android.provider.CallLog;
import java.util.ArrayList;


public class ReadCallLogs{


    public ArrayList<String> getNumbers(Cursor managedCursor) {
        ArrayList<String> numbers =  new ArrayList<>();
        int numbersLocation = managedCursor.getColumnIndex(CallLog.Calls.NUMBER);
        while (managedCursor.moveToNext()){
            Long callDate = Long.parseLong(managedCursor.getString(managedCursor.getColumnIndex(android.provider.CallLog.Calls.DATE)));
            if(callDate >= Global.startzeit && callDate <= Global.endzeit){
                String number = managedCursor.getString(numbersLocation);
                numbers.add(number);
            }
        }
        managedCursor.move(-managedCursor.getPosition());
        return numbers;
    }

    public ArrayList<String> getTypes(Cursor managedCursor) {
        ArrayList<String> types =  new ArrayList<>();
        int typesLocation = managedCursor.getColumnIndex(CallLog.Calls.TYPE);
        while (managedCursor.moveToNext()){
            Long callDate = Long.parseLong(managedCursor.getString(managedCursor.getColumnIndex(android.provider.CallLog.Calls.DATE)));
            if(callDate >= Global.startzeit && callDate <= Global.endzeit){
                int typeCode = Integer.parseInt(managedCursor.getString(typesLocation));
                String type = null;
                switch (typeCode) {
                    case CallLog.Calls.OUTGOING_TYPE:
                        type = "Ausgehend";
                        break;

                    case CallLog.Calls.INCOMING_TYPE:
                        type = "Eingehend";
                        break;

                    case CallLog.Calls.MISSED_TYPE:
                        type = "Verpasst";
                        break;
                }
                types.add(type);
            }
        }
        managedCursor.move(-managedCursor.getPosition());
        return types;
    }

    public ArrayList<String> getDurations(Cursor managedCursor) {
        ArrayList<String> durations =  new ArrayList<>();
        int durationsLocation = managedCursor.getColumnIndex(CallLog.Calls.DURATION);
        while (managedCursor.moveToNext()){
            Long callDate = Long.parseLong(managedCursor.getString(managedCursor.getColumnIndex(android.provider.CallLog.Calls.DATE)));
            if(callDate >= Global.startzeit && callDate <= Global.endzeit){
                String duration = managedCursor.getString(durationsLocation);
                durations.add(duration);
            }
        }
        managedCursor.move(-managedCursor.getPosition());
        return durations;
    }

    public ArrayList<String> getDates(Cursor managedCursor) {
        ArrayList<String> dates =  new ArrayList<>();
        int dateLocation = managedCursor.getColumnIndex(CallLog.Calls.DATE);
        while (managedCursor.moveToNext()){
            Long callDate = Long.parseLong(managedCursor.getString(managedCursor.getColumnIndex(android.provider.CallLog.Calls.DATE)));
            if(callDate >= Global.startzeit && callDate <= Global.endzeit){
                Long dateValue = Long.parseLong(managedCursor.getString(dateLocation));
                String date = Global.convertDate(dateValue);
                dates.add(date);
            }
        }
        managedCursor.close();
        return dates;
    }
}
