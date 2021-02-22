package willie.com.revenue.utils.digital;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class DecimalUtil {
    public static String format(BigDecimal bigDecimal) {
        DecimalFormat decimalFormat = new DecimalFormat("##,###,###,###,##0");
        return decimalFormat.format(bigDecimal);
    }
}
