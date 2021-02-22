package willie.com.revenue.service.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import willie.com.revenue.beans.html.views.system.CodeBean;
import willie.com.revenue.dao.system.CodeDao;
import willie.com.revenue.enums.system.CodeEnum;
import willie.com.revenue.utils.StringUtil;

import java.util.List;

@Service
public class CodeService {
    private CodeDao codeDao;

    private static String DOMAIN_KEY = "DOMAIN";

    public String getSysDomain() {
        CodeBean codeBean = getCode(CodeEnum.SYS_SYS_URL, DOMAIN_KEY);
        return StringUtil.nullToSpace(codeBean.getDesc1());
    }

    public CodeBean getCode(CodeEnum codeEnum, String no) {
        return codeDao.findCodeByNo(codeEnum.getSys(), codeEnum.getSubSys(), codeEnum.getType(), no);
    }

    public List<CodeBean> getCode(CodeEnum codeEnum) {
        return codeDao.findCodeByType(codeEnum.getSys(), codeEnum.getSubSys(), codeEnum.getType());
    }

    @Autowired
    public void setCodeDao(CodeDao codeDao) {
        this.codeDao = codeDao;
    }
}
