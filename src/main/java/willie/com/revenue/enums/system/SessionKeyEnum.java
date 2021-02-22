package willie.com.revenue.enums.system;

public enum SessionKeyEnum {
    MEMBER("member"),
    ROLES("roles"),
    MAIN_MENU("mainMenu"),
    RIGHT_MENU("rightMenu"),
    ;

    private String key;

    SessionKeyEnum(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
