package willie.com.revenue.beans.table.system;


import willie.com.revenue.beans.table.BaseTable;

public class Permission extends BaseTable {
    private Integer node;

    private Integer upnode;

    private Integer position;

    private Integer sequence;

    private String icon;

    private String url;

    private String name;

    private Integer useMemberId;

    public Integer getNode() {
        return node;
    }

    public void setNode(Integer node) {
        this.node = node;
    }

    public Integer getUpnode() {
        return upnode;
    }

    public void setUpnode(Integer upnode) {
        this.upnode = upnode;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUseMemberId() {
        return useMemberId;
    }

    public void setUseMemberId(Integer useMemberId) {
        this.useMemberId = useMemberId;
    }
}
