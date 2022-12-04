package com.mehdilagdimi.marocair_api.util.TimeHelper;


import org.apache.commons.lang3.StringUtils;

import java.sql.Timestamp;

public abstract class TimeUtil {
    public static Timestamp stringToTimestamp (String date) {
        if (StringUtils.countMatches(date, ":") == 1) {
            date += ":00";
        }
        Timestamp timestamp = Timestamp.valueOf(date.replace("T", " "));
        return timestamp;
    }
    public static String timestampToHtmlDateTimeLocal (String date) {
        if (StringUtils.countMatches(date, ":") == 1) {
            date += ":00";
        }
//        System.out.println(" st " + date.replace(" ", "T"));
//        System.out.println(" st " + date.replace(" ", "T").split("\\.")[0]);
        return date.replace(" ", "T").split("\\.")[0];
    }

}
