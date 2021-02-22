package willie.com.revenue.beans.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

import java.io.Serializable;

public class UserToken extends UsernamePasswordToken implements Serializable {
    private static final long serialVersionUID = -2013574731436985473L;

    private String account;

    private String pwd;
    public UserToken(String account, String pwd) {
        super(account, pwd);
        this.account=account;
        this.pwd = pwd;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
