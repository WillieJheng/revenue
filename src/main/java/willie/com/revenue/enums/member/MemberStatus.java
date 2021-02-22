package willie.com.revenue.enums.member;


import willie.com.revenue.beans.html.views.system.CodeBean;
import willie.com.revenue.utils.StringUtil;

import java.util.ArrayList;
import java.util.List;

public enum MemberStatus {
    正常(1, "正常", "label label-pill label-success"),
    已停用(2, "已停用", "label label-pill label-danger"),
    已鎖定(3, "已鎖定", "label label-pill label-primary"),
    已過期(4, "已過期", "label label-pill label-danger"),
    ;

    private Integer status;

    private String desc;

    private String cssClass;

    MemberStatus(Integer status, String desc, String cssClass) {
        this.status = status;
        this.desc = desc;
        this.cssClass = cssClass;
    }

    public Integer getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }

    public static String getDesc(Integer status) {
        for (MemberStatus memberStatus : MemberStatus.values()) {
            if (memberStatus.getStatus().equals(status)) {
                return memberStatus.getDesc();
            }
        }
        return "";
    }

    public String getCssClass() {
        return cssClass;
    }

    public static String getCssClass(Integer status) {
        for (MemberStatus memberStatus : MemberStatus.values()) {
            if (memberStatus.getStatus().equals(status)) {
                return memberStatus.getCssClass();
            }
        }
        return "";
    }

    public static List<CodeBean> getStatusList() {
        List<CodeBean> statusList = new ArrayList<>();
        for (MemberStatus memberStatus : MemberStatus.values()) {
            CodeBean codeBean=new CodeBean();
            codeBean.setNo(StringUtil.toString(memberStatus.getStatus()));
            codeBean.setDesc1(memberStatus.getDesc());
            statusList.add(codeBean);
        }
        return statusList;
    }

    public static String getErrorDesc(Integer status) {
        for (MemberStatus memberStatus : MemberStatus.values()) {
            if (memberStatus.getStatus().equals(status)) {
                return memberStatus.getDesc();
            }
        }
        return "";
    }
}
