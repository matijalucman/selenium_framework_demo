package com.ml.demo.core.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {

    private String dateTimeString;

    private String dateTimeFormat;

    private DateHelper(String dateString, String dateFormat) {

        this.dateTimeString = dateString;
        this.dateTimeFormat = dateFormat;
    }

    // Return date in string format from method
    public String asString() {

        return dateTimeString;
    }

    // Parse string to date
    public Date asDate() throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat(dateTimeFormat);
        return formatter.parse(dateTimeString);
    }


    /* get current date and time in format dd.MM.yyyy HH:mm:ss */
    public static DateHelper getCurrentDateTime(String dateTimeFormat) {

        Calendar now = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat(dateTimeFormat);
        String dateTime = formatter.format(now.getTime());
        return new DateHelper(dateTime, dateTimeFormat);
    }
}
