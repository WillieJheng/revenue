package willie.com.revenue.controllers.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import willie.com.revenue.beans.html.HtmlConst;
import willie.com.revenue.beans.html.views.player.PlayerBean;
import willie.com.revenue.enums.system.PageManager;
import willie.com.revenue.service.player.PlayerService;

@Controller
public class PlayerController {
    private PlayerService playerService;

    @Autowired
    public void setPlayerService(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/players")
    public ModelAndView getPlayersPage() {
        return getPlayer();
    }

    @PostMapping("/players")
    public ModelAndView addNewPlayer(PlayerBean playerBean) {
        playerService.save(playerBean);

        return getPlayer();
    }

    private ModelAndView getPlayer() {
        ModelAndView mv = new ModelAndView(PageManager.MAIN.getPath());
        mv.addObject(HtmlConst.FORM_VIEW, PageManager.PLAYERS.getPath());
        mv.addObject(HtmlConst.FORM_ACTION, "/players");
        mv.addObject(HtmlConst.FORM_DATA, playerService.findPlayers());
        return mv;
    }
}
