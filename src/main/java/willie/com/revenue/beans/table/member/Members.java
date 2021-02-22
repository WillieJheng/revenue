package willie.com.revenue.beans.table.member;



import willie.com.revenue.beans.table.BaseTable;
import willie.com.revenue.utils.encrypt.EncryptUtil;

import java.util.Date;

public class Members extends BaseTable {
    private String memberId;

    private String password;

    private String projectName;

    private String background;

    private String email;

    private Integer status;

    private Date expiryDate;

    private Date loginTime;

    private String loginIp;

    private Integer loginCount;

    {
        setLoginCount(0);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (isNotNull(getMemberId()) && isNotNull(getPassword()) && !getPassword().equals(password)) {
            this.password = getEncryptPassword(password);
        } else {
            this.password = password;
        }
    }

    public String getEncryptPassword(String password) {
        return EncryptUtil.encryptUserPassword(getMemberId(), password);
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }
}
