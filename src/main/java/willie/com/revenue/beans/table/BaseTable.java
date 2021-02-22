package willie.com.revenue.beans.table;



import willie.com.revenue.utils.StringUtil;

import java.util.Date;

public abstract class BaseTable {
    private Date createTime;

    private String createMember;

    private Date updateTime;

    private String updateMember;

    protected Boolean isNotNull(String object) {
        return StringUtil.isNotEmpty(object);
    }

    protected Boolean isNotNull(Object object) {
        return object != null;
    }

    public void setModifyInfo(String memberId){
        setCreateTime(new Date());
        setUpdateTime(new Date());
        setCreateMember(memberId);
        setUpdateMember(memberId);
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateMember() {
        return createMember;
    }

    public void setCreateMember(String createMember) {
        this.createMember = createMember;
    }

    public String getUpdateMember() {
        return updateMember;
    }

    public void setUpdateMember(String updateMember) {
        this.updateMember = updateMember;
    }
}
