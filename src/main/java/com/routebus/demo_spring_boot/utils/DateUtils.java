package com.routebus.demo_spring_boot.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class DateUtils {
    public static Timestamp getNowTimestamp(){
        return Timestamp.from(Instant.ofEpochSecond(System.currentTimeMillis()));
    }
    public static String getNowDateStringFormat(String format){
        Date date = new Date();
        SimpleDateFormat sdf =
                new java.text.SimpleDateFormat(format);

        return sdf.format(date);
    }
}
