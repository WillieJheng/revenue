package willie.com.revenue.configs;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import willie.com.revenue.beans.shiro.UserRealm;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public UserRealm getUserRealm() {
        return new UserRealm();
    }

    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(getUserRealm());
        return manager;
    }

    @Bean
    ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager());
        bean.setLoginUrl("/login");
        bean.setSuccessUrl("/index");
        bean.setUnauthorizedUrl("/error");
        bean.setFilterChainDefinitionMap(getFilterMap());
        return bean;
    }

    private Map<String, String> getFilterMap() {
        Map<String, String> map = new LinkedHashMap<>();
        //套版
        map.put("/css/**", "anon");
        map.put("/icons/**", "anon");
        map.put("/img/**", "anon");
        map.put("/images/**", "anon");
        map.put("/scss/**", "anon");
        map.put("/js/**", "anon");
        map.put("/plugins/**", "anon");
        map.put("/vendor/**", "anon");


        map.put("/**", "authc");
        return map;
    }
}
