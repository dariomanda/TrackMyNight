package at.mandic.trackmynight;

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


    public static Long getTime() {
        Date date = new Date();
        Long time = date.getTime();
        return time;
    }

    public static String convertDate(Long d){
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy");
        String dateString = dateFormat.format(getTime());
        return dateString;
    }
}
