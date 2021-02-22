package willie.com.revenue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import willie.com.revenue.utils.date.DateTimeUtil;

import java.util.Calendar;

@SpringBootTest
class RevenueApplicationTests {

    @Test
    void contextLoads() {
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);

        int day = cal.get(Calendar.DAY_OF_WEEK);

        System.out.println(day);

        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);

        System.out.println(DateTimeUtil.format(cal.getTime()));
    }

}
