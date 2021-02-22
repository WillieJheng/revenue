package willie.com.revenue.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import willie.com.revenue.utils.encrypt.EncryptUtil;

@SpringBootTest
public class EncryptUtilTest {
    @Test
    public void getMemberPassword(){
        String account = "admin";
        String pwd = "1";
        System.out.println(EncryptUtil.encryptUserPassword(account, pwd));
    }
}
