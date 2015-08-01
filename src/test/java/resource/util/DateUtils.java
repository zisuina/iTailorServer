package resource.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by liker on 01/08/2015 0001.
 * Group iTailor.hunters.neu.edu.cn
 */

public class DateUtils {

    /**
     * 格式化时间
     */
    public static String formatTime(long showTime) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Long
                .valueOf(showTime));
    }

    /**
     * 格式化时间
     */
    public static String formatTime(String showTime) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Long
                .valueOf(showTime));
    }

    /**
     * 获取时间的毫秒数
     */
    public static long getMillis() throws ParseException {
        return System.currentTimeMillis();
    }

    /**
     * 获取指定时间的毫秒数，参数格式： yyyy-MM-dd HH:mm:ss，返回null代表计算失败
     */
    public static long getMillis(String dstr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(dstr);
        long s1 = date.getTime();
        return s1;
    }

    /**
     * 返回 指定时间的毫秒数 减 当前日期的毫秒数；参数格式： yyyy-MM-dd HH:mm:ss，返回null代表计算失败
     */
    public static long getMillisDistanceNow(String dstr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(dstr);
        long s1 = date.getTime();
        long s2 = System.currentTimeMillis();
        return s1 - s2;
    }

    /**
     * 返回格式：2015-07-08
     */
    public static String getTodayDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String now = sdf.format(Long.valueOf(System.currentTimeMillis()));
        return now;
    }

    /**
     * 返回格式：2015-07-08 08:00:00
     */
    public static String getTodayTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        String now = sdf.format(Long.valueOf(System.currentTimeMillis()));
        return now;
    }

    /**
     * 返回格式：2015-07-08
     */
    public static String getTomorrowDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String date = sdf
                .format(Long.valueOf(System.currentTimeMillis() + 1 * 24 * 60 * 60 * 1000));
        return date;
    }

    /**
     * 返回格式：2015-07-08 00:00:00
     */
    public static String getTomorrowTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String now = sdf.format(Long.valueOf(System.currentTimeMillis() + 1 * 24 * 60 * 60 * 1000));

        long zeroHourMillis = 0;
        try {
            zeroHourMillis = getMillis(now + " " + "00:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        String time = sdf.format(Long.valueOf(zeroHourMillis));
        return time;
    }

    /**
     * 比较日期的大小，
     */
    public static int compareDate(String date1, String date2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date d1 = null;
        Date d2 = null;
        try {
            d1 = sdf.parse(date1);
            d2 = sdf.parse(date2);
        } catch (ParseException e) {
            e.printStackTrace();
            return -1;
        }
        return d1.compareTo(d2);
    }

    /**
     * 比较日期与当前日期的大小，
     */
    public static int compareDate(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String now = sdf.format(Long.valueOf(System.currentTimeMillis()));
        Date date = null;
        Date nowdate = null;
        try {
            date = sdf.parse(dateStr);
            nowdate = sdf.parse(now);
        } catch (ParseException e) {
            e.printStackTrace();
            return -1;
        }
        return nowdate.compareTo(date);
    }
}
