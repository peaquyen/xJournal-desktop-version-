package com.github.peaquyen.com.xjournal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Utils {
    public static String convertDateToUTC(String date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sdf.setTimeZone(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
            Date localDate = sdf.parse(date);
            sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
            return sdf.format(localDate);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String convertDateFromUTC(String date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date utcDate = sdf.parse(date);
            sdf.setTimeZone(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
            return sdf.format(utcDate);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
