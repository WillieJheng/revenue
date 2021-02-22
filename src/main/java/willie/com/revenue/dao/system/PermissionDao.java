package willie.com.revenue.dao.system;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import willie.com.revenue.beans.html.views.system.PermissionBean;

import java.util.List;

@Repository
@Mapper
public interface PermissionDao {
    List<PermissionBean> findPermissionByRolesAndPositionAndUpnode(List<String> roleIds, Integer position, Integer upnode);
}
