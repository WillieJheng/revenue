package willie.com.revenue.beans.query.score;

import willie.com.revenue.utils.date.DateTimeUtil;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class ScoreQueryBean {
    public static final String DATE_TIME_CONCAT_STR = " - ";

    private String startDate;

    private String endDate;

    {
        Calendar calendar = GregorianCalendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        calendar.add(Calendar.DATE, calendar.getFirstDayOfWeek() - day);

        setStartDate(DateTimeUtil.format(calendar.getTime(),DateTimeUtil.SYS_FORMAT_DATE));

        calendar.add(Calendar.DAY_OF_WEEK, 6);
        setEndDate(DateTimeUtil.format(calendar.getTime(),DateTimeUtil.SYS_FORMAT_DATE));
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDateRange() {
        return getStartDate() + DATE_TIME_CONCAT_STR + getEndDate();
    }

    public void setDateRange(String dateRange) {
        String[] dateAry = dateRange.split(DATE_TIME_CONCAT_STR);
        if (dateAry != null && dateAry.length > 1) {
            setStartDate(dateAry[0].replace("/","-"));
            setEndDate(dateAry[1].replace("/","-"));
        }
    }
}
