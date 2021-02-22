package willie.com.revenue.beans.html.views.system.menu.impl;



import willie.com.revenue.beans.html.views.system.menu.MenuComponent;

import java.util.ArrayList;
import java.util.List;

public class Menu extends MenuComponent {
    private List<MenuComponent> menu = new ArrayList<>();

    private String name;

    private String icon;

    public Menu(String name) {
        this.name = name;
    }

    public Menu(String name, String icon) {
        this.name = name;
        this.icon = icon;
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menu.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        menu.remove(menuComponent);
    }

    @Override
    public List<MenuComponent> getSubMenu() {
        return menu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
