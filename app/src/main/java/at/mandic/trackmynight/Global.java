package at.mandic.trackmynight;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dario on 01.06.2017.
 */

public class Global {
    public static String valueStartTime = null;
    public static String promille = "";
    public static String valueEndTime;
    public static Long endzeit;
    public static Long startzeit;

    public static String convertToStringDate(String s){
        SimpleDateFormat fromFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        SimpleDateFormat toFormat = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
        return s;
    }
    public static long convertToMillis(String s) {
        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");

        long milliseconds = 0;
        try {
            Date d = formatter.parse(s);
            milliseconds = d.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return milliseconds;
    }
}
