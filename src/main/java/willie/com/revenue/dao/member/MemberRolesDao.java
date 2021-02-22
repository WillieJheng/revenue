package willie.com.revenue.dao.member;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import willie.com.revenue.beans.html.views.member.MemberRoleBean;
import willie.com.revenue.beans.table.member.MemberRoles;

import java.util.List;

@Repository
@Mapper
public interface MemberRolesDao {
    List<MemberRoleBean> findRolesByMemberId(String memberId);

    int deleteByMemberId(String memberId);

    int save(MemberRoles memberRoles);
}
