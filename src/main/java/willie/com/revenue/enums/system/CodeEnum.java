package willie.com.revenue.enums.system;

public enum CodeEnum {
    SYS_SYS_URL("SYS", "SYS", "URL"),
    SYS_JOB_CRON("SYS", "JOB", "CRON"),

    MEMBER_SERVER_SERVER("MEMBER", "SERVER", "SERVER"),

    PAYMENT_VENDOR_NAME("PAYMENT", "VENDOR", "NAME"),

    PAYMENT_ECPAY_BANK("PAYMENT", "ECPAY", "BANK"),
    PAYMENT_ECPAY_URL("PAYMENT", "ECPAY", "URL"),

    PAYMENT_OPAY_URL("PAYMENT", "OPAY", "URL"),

    PAYMENT_NEWEB_URL("PAYMENT", "NEWEB", "URL"),

    PLAYER_PLAYER_ACTIVATE("PLAYER", "PLAYER", "ACTIVATE"),


    ;

    private String sys;

    private String subSys;

    private String type;

    CodeEnum(String sys, String subSys, String type) {
        this.sys = sys;
        this.subSys = subSys;
        this.type = type;
    }

    public String getSys() {
        return sys;
    }

    public String getSubSys() {
        return subSys;
    }

    public String getType() {
        return type;
    }
}
