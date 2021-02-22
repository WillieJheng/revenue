package willie.com.revenue.beans.html.views.member;


import willie.com.revenue.utils.encrypt.EncryptUtil;

public class LoginBean {
    private String account;

    private String pwd;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return EncryptUtil.encryptUserPassword(account, pwd);
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
