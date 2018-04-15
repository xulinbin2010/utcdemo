package com.ntt.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    private static final String DATEFORMAT = "yyyy-MM-dd";
    private static final String DATEFORMAT_8 = "yyyyMMdd";
    /**
     * 得到几天前的时间
     *
     * @param d
     * @param day
     * @return
     */
    public static Date getDateBefore(Date d, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
        return now.getTime();
    }
    /**
     * 得到几天后的时间
     *
     * @param d
     * @param day
     * @return
     */
    public static Date getDateAfter(Date d, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
        return now.getTime();
    }


    public static void main(String[] args) {
        String dateStr="2018-03-04";
        System.out.println("dateStr = " + dateStr);
        int plusDay=13;
        SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMAT);
        try {
            Date parseDate = sdf.parse(dateStr);
            Date dateAfter = getDateAfter(parseDate, plusDay);
            String format = sdf.format(dateAfter);
            System.out.println("dateAfter = " + format);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
