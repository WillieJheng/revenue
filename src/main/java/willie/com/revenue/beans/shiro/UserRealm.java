package willie.com.revenue.beans.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import willie.com.revenue.beans.html.views.member.MemberBean;
import willie.com.revenue.enums.member.MemberStatus;
import willie.com.revenue.service.member.MemberService;
import willie.com.revenue.service.member.RoleService;

public class UserRealm extends AuthorizingRealm {
    private MemberService memberService;

    private RoleService roleService;

    public static Integer LOGIN_ERROR_COUNT = 5;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        UserToken userToken = (UserToken) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        roleService.getMemberRoles(userToken.getAccount()).stream().forEach(
                bean -> {
                    authorizationInfo.addRole(bean.getRoleId());
                }
        );
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UserToken userToken = (UserToken) authenticationToken;
        String account = userToken.getAccount();
        String pwd = userToken.getPwd();

        MemberBean memberBean = memberService.checkMember(account);
        if (!memberBean.getPassword().equals(pwd)) {
            Integer count = memberService.addLoginErrorCount(memberBean.getMemberId());
            if(count >= LOGIN_ERROR_COUNT){
                memberService.setStatus(memberBean, MemberStatus.已鎖定);
                throw new AccountException("帳號" + MemberStatus.已鎖定.getDesc());
            }
            throw new AccountException(String.format("登入密碼錯誤%s次，錯誤%s次將鎖定帳號。", count, LOGIN_ERROR_COUNT));
        }
        return new SimpleAuthenticationInfo(authenticationToken, pwd, account);
    }

    @Autowired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
}
