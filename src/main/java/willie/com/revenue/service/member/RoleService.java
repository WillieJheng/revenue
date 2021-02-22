package willie.com.revenue.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import willie.com.revenue.beans.html.views.member.MemberRoleBean;
import willie.com.revenue.beans.table.member.MemberRoles;
import willie.com.revenue.dao.member.MemberRolesDao;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {
    private MemberRolesDao memberRolesDao;

    public List<String> getMemberRoleIds(String memberId) {
        List<String> roleIds = new ArrayList<>();
        getMemberRoles(memberId).stream().forEach(
                bean ->
                        roleIds.add(bean.getRoleId())
        );
        if (roleIds.size() < 1) {
            roleIds.add("0");
        }
        return roleIds;
    }

    public List<MemberRoleBean> getMemberRoles(String memberId) {
        return memberRolesDao.findRolesByMemberId(memberId);
    }

    public void save(MemberRoles roles) {
        memberRolesDao.save(roles);
    }

    public void deleteByMemberId(String memberId) {
        memberRolesDao.deleteByMemberId(memberId);
    }

    @Autowired
    public void setMemberRolesDao(MemberRolesDao memberRolesDao) {
        this.memberRolesDao = memberRolesDao;
    }
}
