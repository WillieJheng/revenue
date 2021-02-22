package willie.com.revenue.dao.system;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import willie.com.revenue.beans.html.views.system.CodeBean;

import java.util.List;

@Repository
@Mapper
public interface CodeDao {
    List<CodeBean> findCodeByType(String sys, String subSys, String type);

    CodeBean findCodeByNo(String sys, String subSys, String type, String no);
}
