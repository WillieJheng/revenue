package willie.com.revenue.utils;

public class StringUtil {
    public static Boolean isNotEmpty(String value) {
        return !isEmpty(value);
    }

    public static Boolean isEmpty(String value) {
        return nullToSpace(value).equals("");
    }

    public static String nullToSpace(String value) {
        if (value == null) {
            return "";
        }
        return value;
    }

    public static String toString(Integer value){
        return String.valueOf(value);
    }

    public static String toString(Long value){
        return String.valueOf(value);
    }
}
