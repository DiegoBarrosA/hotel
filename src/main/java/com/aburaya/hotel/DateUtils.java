package com.aburaya.hotel;
import java.util.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
public abstract class DateUtils {
    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(date);
        } catch (ParseException e) {
            return null;
        }
     }
}
