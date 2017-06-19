package at.mandic.trackmynight;

import android.database.Cursor;
import android.provider.CallLog;

import java.util.ArrayList;

/**
 * Created by dario on 19.06.2017.
 */


public class ReadSMSLogs {

    public ArrayList<String> getNumbers(Cursor cursor) {
        ArrayList<String> numbers = new ArrayList<>();
        cursor.moveToLast();
        for (int i = 0; i < cursor.getCount(); i++) {
            String dateString = cursor.getString(cursor.getColumnIndexOrThrow("date")).toString();
            Long dateLong = Long.valueOf(dateString);
            if (dateLong >= Global.startzeit && dateLong <= Global.endzeit) {

                String number = cursor.getString(cursor.getColumnIndexOrThrow("address"));
                numbers.add(number);
            }
            cursor.moveToPrevious();
        }
        return numbers;

    }

    public ArrayList<String> getTypes(Cursor cursor) {
        ArrayList<String> types = new ArrayList<>();
        cursor.moveToLast();
        for (int i = 0; i < cursor.getCount(); i++) {
            String dateString = cursor.getString(cursor.getColumnIndexOrThrow("date")).toString();
            Long dateLong = Long.valueOf(dateString);
            if (dateLong >= Global.startzeit && dateLong <= Global.endzeit) {

                String smsType = cursor.getString(cursor.getColumnIndexOrThrow("type"));
                String type = null;

                switch (Integer.parseInt(smsType)) {
                    case 1:
                        type = "Empfangen";
                        break;

                    case 2:
                        type = "Gesendet";
                        break;

                    case 3:
                        type = "Vorlage";
                        break;
                }
                types.add(type);
            }
            cursor.moveToPrevious();
        }
        return types;

    }

    public ArrayList<String> getDates(Cursor cursor) {
        ArrayList<String> dates = new ArrayList<>();
        cursor.moveToLast();
           for (int i = 0; i < cursor.getCount(); i++) {
               String dateString = cursor.getString(cursor.getColumnIndexOrThrow("date")).toString();
               Long dateLong = Long.valueOf(dateString);
                     if (dateLong >= Global.startzeit && dateLong <= Global.endzeit) {
               String date = Global.convertDateSMS(dateLong);
               dates.add(date);
              }
                    cursor.moveToPrevious();
        }
        return dates;

    }



    public ArrayList<String> getBodys(Cursor cursor) {
        ArrayList<String> bodys = new ArrayList<>();
        cursor.moveToLast();
        for (int i = 0; i < cursor.getCount(); i++) {
            String dateString = cursor.getString(cursor.getColumnIndexOrThrow("date")).toString();
            Long dateLong = Long.valueOf(dateString);
            if (dateLong >= Global.startzeit && dateLong <= Global.endzeit) {

                String body = cursor.getString(cursor.getColumnIndexOrThrow("body"));
                bodys.add(body);
            }
            cursor.moveToPrevious();
        }
        return bodys;

    }

}

