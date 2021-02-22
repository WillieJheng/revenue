package willie.com.revenue.beans.html.views.member;



import willie.com.revenue.beans.table.member.Members;
import willie.com.revenue.enums.member.MemberStatus;
import willie.com.revenue.utils.date.DateTimeUtil;

import java.util.Calendar;
import java.util.Date;

public class MemberBean extends Members {
    public Calendar getExpiryDateCalendar() {
        if (isNotNull(getExpiryDate())) {
            return DateTimeUtil.getCalendar(getExpiryDate(), DateTimeUtil.TIME_ZONE_CN);
        }
        return null;
    }

    public String getExpiryDateStr() {
        if (isNotNull(getExpiryDate()))
            return DateTimeUtil.format(getExpiryDate(), DateTimeUtil.SYS_FORMAT_DATE);
        return "";
    }

    public String getStatusDesc() {
        return MemberStatus.getDesc(getStatus());
    }

    public String getStatusCssClass() {
        return MemberStatus.getCssClass(getStatus());
    }

    public void updateData(Members members) {
        setMemberId(members.getMemberId());
        setPassword(members.getPassword());
        setProjectName(members.getProjectName());
        setExpiryDate(members.getExpiryDate());
        setLoginTime(members.getLoginTime());
        setLoginIp(members.getLoginIp());
        setBackground(members.getBackground());
        setStatus(members.getStatus());
        setLoginCount(members.getLoginCount());
        setEmail(members.getEmail());
    }

    @Override
    public void setMemberId(String memberId) {
        if (isNotNull(memberId))
            super.setMemberId(memberId);
    }

    @Override
    public void setPassword(String password) {
        if (isNotNull(password))
            super.setPassword(password);
    }

    @Override
    public void setProjectName(String projectName) {
        if (isNotNull(projectName))
            super.setProjectName(projectName);
    }

    @Override
    public void setExpiryDate(Date expiryDate) {
        if (isNotNull(expiryDate))
            super.setExpiryDate(expiryDate);
    }

    @Override
    public void setLoginTime(Date loginTime) {
        if (isNotNull(loginTime))
            super.setLoginTime(loginTime);
    }

    @Override
    public void setLoginIp(String loginIp) {
        if (isNotNull(loginIp))
            super.setLoginIp(loginIp);
    }

    @Override
    public void setBackground(String background) {
        if (isNotNull(background))
            super.setBackground(background);
    }

    @Override
    public void setStatus(Integer status) {
        if (isNotNull(status))
            super.setStatus(status);
    }

    @Override
    public void setLoginCount(Integer loginCount) {
        if (isNotNull(loginCount))
            super.setLoginCount(loginCount);
    }
}
