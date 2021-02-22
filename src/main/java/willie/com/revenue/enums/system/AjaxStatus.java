package willie.com.revenue.enums.system;

public enum AjaxStatus {
    SUCCESS("OK","SUCCESS"),

    驗証碼有誤("E100","驗証碼有誤"),

    查無開單資料("E400","查無開單資料"),
    已有觸發過了("E410","已有觸發過了"),
    ;

    private String status;

    private String msg;

    AjaxStatus(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }
}
