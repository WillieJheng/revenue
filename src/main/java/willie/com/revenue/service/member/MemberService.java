package willie.com.revenue.service.member;

import org.apache.shiro.authc.AccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import willie.com.revenue.beans.html.views.member.MemberBean;
import willie.com.revenue.beans.html.views.system.menu.impl.Menu;
import willie.com.revenue.dao.member.MembersDao;
import willie.com.revenue.enums.member.MemberStatus;
import willie.com.revenue.enums.member.RoleEnum;
import willie.com.revenue.service.system.SessionService;
import willie.com.revenue.utils.date.DateTimeUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Service
public class MemberService {
    private MembersDao membersDao;

    private RoleService roleService;

    private PermissionService permissionService;

    private SessionService sessionService;

    private final static String SYSTEM_ID = "SYS";

    public MemberBean updateLoginInfo(String memberId, String ip) {
        MemberBean memberBean = findMemberByMemberId(memberId);
        memberBean.setLoginIp(ip);
        memberBean.setLoginTime(new Date());
        memberBean.setLoginCount(0);
        save(memberBean, SYSTEM_ID);
        return memberBean;
    }

    public MemberBean checkMember(String memberId) {
        Calendar calendar = DateTimeUtil.getCalendar(TimeZone.getTimeZone("GMT+8"));
        MemberBean member = findMemberByMemberId(memberId);
        if (member == null) {
            throw new AccountException(String.format("[%s]-帳號不存在", memberId));
        } else if (!member.getStatus().equals(MemberStatus.正常.getStatus())) {
            throw new AccountException(String.format("帳號[%s]-%s", memberId, MemberStatus.getErrorDesc(member.getStatus())));
        } else if (member.getExpiryDate() != null && calendar.compareTo(member.getExpiryDateCalendar()) > 0) {
            setStatus(member, MemberStatus.已過期);
            throw new AccountException(String.format("帳號[%s]-%s", memberId, MemberStatus.已過期.getDesc()));
        }
        return member;
    }

    public Boolean isMemberManager(String memberId) {
        List<String> rolesIds = roleService.getMemberRoleIds(memberId);
        for (String roleId : rolesIds) {
            if (RoleEnum.MEMBER_MANAGER.getId().equals(roleId)) {
                return true;
            }
        }
        return false;
    }

    public Menu getMainMenu(String memberId) {
        return permissionService.getMainMenu(memberId, getRoleIds(memberId));
    }

    public Menu getRightMenu(String memberId) {
        return permissionService.getRightMenu(memberId, getRoleIds(memberId));
    }

    public List<String> getRoleIds(String memberId) {
        return roleService.getMemberRoleIds(memberId);
    }

    public MemberBean findMemberByMemberId(String memberId) {
        return membersDao.findMemberByMemberId(memberId);
    }

    public List<MemberBean> findMembersByCreateMemberId(String agentId) {
        return membersDao.findMembersByCreateMemberId(agentId);
    }

    public Integer addLoginErrorCount(String memberId) {
        MemberBean memberBean = findMemberByMemberId(memberId);
        memberBean.setLoginCount(memberBean.getLoginCount() + 1);
        save(memberBean, SYSTEM_ID);
        return memberBean.getLoginCount();
    }

    public void setStatus(MemberBean memberBean, MemberStatus status) {
        memberBean.setStatus(status.getStatus());
        save(memberBean, SYSTEM_ID);
    }

    public void save(MemberBean memberBean, String operatorId) {
        memberBean.setModifyInfo(operatorId);
        duplicate(memberBean);
    }

    public void save(MemberBean memberBean) {
        memberBean.setModifyInfo(sessionService.getMemberBean().getMemberId());
        duplicate(memberBean);
    }

    private void duplicate(MemberBean memberBean) {
        membersDao.save(memberBean);
    }

    public void deleteByMemberId(String memberId) {
        membersDao.deleteByMemberId(memberId);
        roleService.deleteByMemberId(memberId);
    }

    @Autowired
    public void setMembersDao(MembersDao membersDao) {
        this.membersDao = membersDao;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Autowired
    public void setPermissionService(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @Autowired
    public void setSessionService(SessionService sessionService) {
        this.sessionService = sessionService;
    }
}
