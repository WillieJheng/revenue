package willie.com.revenue.beans.html.views.system.menu.impl;


import willie.com.revenue.beans.html.views.system.menu.MenuComponent;

public class MenuItem extends MenuComponent {
    private String url;

    private String name;

    private String icon;

    public MenuItem(String url, String name, String icon) {
        this.url = url;
        this.name = name;
        this.icon = icon;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getIcon() {
        return icon;
    }
}
