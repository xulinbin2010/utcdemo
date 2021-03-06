package com.ntt.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

    private static final String DATEFORMAT = "yyyy-MM-dd";
    private static final String DATEFORMAT4 = "MMM d";
    private static final String DATEFORMAT_8 = "yyyyMMdd";

    public static String convertDay(Date day) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMAT4,Locale.ENGLISH);
        String format = sdf.format(day);
        return format;
    }

    public static String convertCommon(Date day) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMAT);
        String format = sdf.format(day);
        return format;
    }

    public static Date format(String day) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMAT);
        Date format = null;
        try {
            format = sdf.parse(day);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return format;
    }

//

    /**
     * 计算2个日期的差值天数 date2-date1, 注意要删除掉时分秒
     * @param date1
     * @param date2
     * @return
     */
    public static int daysBetween(Date date1, Date date2) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        long time1 = cal.getTimeInMillis();
        cal.setTime(date2);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(between_days));
    }

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
//        String dateStr="2018-03-04";
//        System.out.println("dateStr = " + dateStr);
//        int plusDay=13;
//        SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMAT);
//        try {
//            Date parseDate = sdf.parse(dateStr);
//            Date dateAfter = getDateAfter(parseDate, plusDay);
//            String format = sdf.format(dateAfter);
//            System.out.println("dateAfter = " + format);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        Date date = new Date();
//        System.out.println(convertDay(date));
//        String dt1="2018-04-17";
//        String dt2="2018-04-19";
//        int i = daysBetween(format(dt2), format(dt1));
//        System.out.println("i = " + i);

        String dt1="2018-05-17";
        String dt2="2018-05-19";
        int i = DateUtils.daysBetween(format(dt2),format(dt1));
        System.out.println("i = " + i);


    }

}
