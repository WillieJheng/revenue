package willie.com.revenue.utils.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateTimeUtil {
    public static final String EC_PAY_FORMAT = "yyyy/MM/dd HH:mm:ss";

    public static final String SYS_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String SYS_FORMAT_DATE = "yyyy-MM-dd";

    public static final String YYYY_MM = "yyyyMM";

    public static final TimeZone TIME_ZONE_CN = TimeZone.getTimeZone("GMT+8");

    public static String formatForEcPay(Date date) {
        return format(date, EC_PAY_FORMAT);
    }

    public static String format(Date date) {
        return format(date, SYS_FORMAT);
    }

    public static String format(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static Calendar getCalendar(TimeZone timeZone) {
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar;
    }

    public static Calendar getCalendar(Date dateTime, TimeZone timeZone) {
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTime(dateTime);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar;
    }

    public static Calendar toCalendar(String dateTimeStr) {
        Calendar calendar = getCalendar(TIME_ZONE_CN);
        calendar.set(Calendar.YEAR, Integer.valueOf(dateTimeStr.substring(0, 4)));
        calendar.set(Calendar.MONTH, Integer.valueOf(dateTimeStr.substring(5, 7)) - 1);
        calendar.set(Calendar.DATE, Integer.valueOf(dateTimeStr.substring(8, 10)));
        if(dateTimeStr.length()>10){
            calendar.set(Calendar.HOUR_OF_DAY, Integer.valueOf(dateTimeStr.substring(11, 13)));
            calendar.set(Calendar.MINUTE, Integer.valueOf(dateTimeStr.substring(14, 16)));
            calendar.set(Calendar.SECOND, Integer.valueOf(dateTimeStr.substring(17, 19)));
        } else {
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
        }
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar;
    }

    public static void setStartDateTime(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 00);
        calendar.set(Calendar.MINUTE, 00);
        calendar.set(Calendar.SECOND, 00);
        calendar.set(Calendar.MILLISECOND, 0);
    }

    public static void setEndDateTime(Calendar calendar) {
        setStartDateTime(calendar);
        calendar.add(Calendar.DATE, 1);
        calendar.add(Calendar.SECOND, -1);
    }
}
