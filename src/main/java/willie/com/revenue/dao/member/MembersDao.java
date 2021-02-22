package willie.com.revenue.dao.member;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import willie.com.revenue.beans.html.views.member.MemberBean;
import willie.com.revenue.beans.table.member.Members;

import java.util.List;


@Repository
@Mapper
public interface MembersDao {
    MemberBean findMemberByMemberId(String memberId);

    List<MemberBean> findMembersByCreateMemberId(String memberId);

    int save(Members member);

    int deleteByMemberId(String memberId);
}
