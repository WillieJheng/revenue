package willie.com.revenue.enums.system;

public enum PageManager {
    LOGIN("login"),
    INDEX("index"),
    MAIN("public/layout/main"),

    ERROR_403("errors/page-error-403"),
    ERROR_404("errors/page-error-404"),

    MEMBER_STATUS_MANAGER("page/member/member_m110"),
    MEMBER_CHANGE_PASSWORD("page/member/member_f300"),

    PLAYERS("page/player/player_m100"),

    SCORE_MANAGER("page/player/score/score_add"),
    SCORE_REPORT("page/player/report/score_report"),
    ;

    private String path;

    PageManager(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
