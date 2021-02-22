package willie.com.revenue.enums.member;

public enum RoleEnum {
    MEMBER_MANAGER("900","會員管理者"),
    MEMBER("100","一般會員"),
    ;

    private String id;

    private String name;

    RoleEnum(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
