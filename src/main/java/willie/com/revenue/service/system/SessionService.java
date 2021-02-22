package willie.com.revenue.service.system;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.springframework.stereotype.Service;
import willie.com.revenue.beans.html.views.member.MemberBean;
import willie.com.revenue.beans.html.views.system.menu.impl.Menu;
import willie.com.revenue.enums.system.SessionKeyEnum;

import java.util.List;

@Service
public class SessionService {
    public void setMemberBean(MemberBean memberBean) {
        SecurityUtils.getSubject().getSession().setAttribute(SessionKeyEnum.MEMBER.getKey(), memberBean);
    }

    public MemberBean getMemberBean() {
        return (MemberBean) SecurityUtils.getSubject().getSession().getAttribute(SessionKeyEnum.MEMBER.getKey());
    }

    public void checkLoginMember(String memberId) {
        MemberBean loginMember = getMemberBean();
        if (!memberId.equals(loginMember.getMemberId())) {
            throw new AccountException("無此頁面");
        }
    }

    public void setRoles(List<String> roleIds) {
        StringBuilder rolesStr = new StringBuilder();
        roleIds.stream().forEach(id -> rolesStr.append(id).append(","));
        SecurityUtils.getSubject().getSession().setAttribute(SessionKeyEnum.ROLES.getKey(), rolesStr.toString());
    }

    public String getRoles() {
        return (String) SecurityUtils.getSubject().getSession().getAttribute(SessionKeyEnum.ROLES.getKey());
    }

    public void setMainMenu(Menu menu) {
        SecurityUtils.getSubject().getSession().setAttribute(SessionKeyEnum.MAIN_MENU.getKey(), menu);
    }

    public Menu getMainMenu() {
        return (Menu) SecurityUtils.getSubject().getSession().getAttribute(SessionKeyEnum.MAIN_MENU.getKey());
    }

    public void setRightMenu(Menu menu) {
        SecurityUtils.getSubject().getSession().setAttribute(SessionKeyEnum.RIGHT_MENU.getKey(), menu);
    }

    public Menu getRightMenu() {
        return (Menu) SecurityUtils.getSubject().getSession().getAttribute(SessionKeyEnum.RIGHT_MENU.getKey());
    }

}
