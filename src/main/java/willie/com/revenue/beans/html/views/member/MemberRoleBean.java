package willie.com.revenue.beans.html.views.member;


import willie.com.revenue.beans.table.member.MemberRoles;

public class MemberRoleBean extends MemberRoles {

    @Override
    public void setRoleId(String roleId) {
        if (isNotNull(roleId))
            super.setRoleId(roleId);
    }

    @Override
    public void setRoleName(String name) {
        if (isNotNull(name))
            super.setRoleName(name);
    }
}
