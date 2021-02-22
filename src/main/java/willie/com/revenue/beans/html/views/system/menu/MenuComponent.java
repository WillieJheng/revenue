package willie.com.revenue.beans.html.views.system.menu;

import java.util.List;

public abstract class MenuComponent {
    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public List<MenuComponent> getSubMenu() {
        throw new UnsupportedOperationException();
    }

    public String getUrl() {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }

    public String getIcon() {
        throw new UnsupportedOperationException();
    }
}
