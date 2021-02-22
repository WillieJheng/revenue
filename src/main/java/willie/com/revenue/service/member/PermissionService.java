package willie.com.revenue.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import willie.com.revenue.beans.html.views.system.PermissionBean;
import willie.com.revenue.beans.html.views.system.menu.impl.Menu;
import willie.com.revenue.beans.html.views.system.menu.impl.MenuItem;
import willie.com.revenue.dao.system.PermissionDao;

import java.util.List;

@Service
public class PermissionService {
    public static final Integer MAIN_TITLE_ID = -1;

    public static final Integer MAIN_MENU_POSITION_ID = 1;

    public static final Integer RIGHT_MENU_POSITION_ID = 2;

    private PermissionDao permissionDao;

    public Menu getMainMenu(String memberId, List<String> roleIds) {
        Menu mainMenu = new Menu("mainMenu");
        getMainMenuTitle(roleIds).stream().forEach(
                bean -> {
                    Menu menu = new Menu(bean.getName(), bean.getIcon());
                    getSubMenu(roleIds, bean.getNode()).stream().forEach(
                            subBean -> {
                                subBean.setUrl(subBean.getUrl().replace("{memberId}", memberId));
                                menu.add(new MenuItem(subBean.getUrl(), subBean.getName(), subBean.getIcon()));
                            });
                    mainMenu.add(menu);
                }
        );
        return mainMenu;
    }

    private List<PermissionBean> getMainMenuTitle(List<String> roleIds) {
        return findPermissionByRolesAndPositionAndUpnode(roleIds, MAIN_MENU_POSITION_ID, MAIN_TITLE_ID);
    }

    private List<PermissionBean> getSubMenu(List<String> roleIds, Integer upnode) {
        return findPermissionByRolesAndPositionAndUpnode(roleIds, MAIN_MENU_POSITION_ID, upnode);
    }

    public Menu getRightMenu(String memberId,List<String> roleIds) {
        Menu rightMenu = new Menu("rightMenu");
        findPermissionByRolesAndPositionAndUpnode(roleIds, RIGHT_MENU_POSITION_ID, MAIN_TITLE_ID).stream().forEach(
                bean -> {
                    bean.setUrl(bean.getUrl().replace("{memberId}", memberId));
                    rightMenu.add(new MenuItem(bean.getUrl(), bean.getName(), bean.getIcon()));
                }
        );
        return rightMenu;
    }

    private List<PermissionBean> findPermissionByRolesAndPositionAndUpnode(List<String> roleIds, Integer position, Integer upnode) {
        return permissionDao.findPermissionByRolesAndPositionAndUpnode(roleIds, position, upnode);
    }

    @Autowired
    public void setPermissionDao(PermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }
}
