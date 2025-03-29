
package com.smsgatewayadapter.ft.dynamic.utils;

import org.apache.commons.lang3.time.FastDateFormat;

import java.text.ParseException;
import java.util.Date;
import java.util.TimeZone;

public class DateFormatUtils {

    private static final FastDateFormat dateFormat =
            FastDateFormat.getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", TimeZone.getTimeZone("UTC"));

    public static String format(Date date) {
        return dateFormat.format(date);
    }

    public static Date parse(String dateStr) throws ParseException {
        return dateFormat.parse(dateStr);
    }

}