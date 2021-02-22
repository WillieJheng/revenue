package willie.com.revenue.controllers.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import willie.com.revenue.beans.html.ajax.AjaxResultBean;
import willie.com.revenue.enums.system.AjaxStatus;
import willie.com.revenue.service.player.PlayerService;

@RestController
public class PlayerAjaxController {
    private PlayerService playerService;

    @Autowired
    public void setPlayerService(PlayerService playerService) {
        this.playerService = playerService;
    }

    @DeleteMapping("/player/{playerId}")
    public AjaxResultBean deletePlayer(@PathVariable Integer playerId){
        playerService.deleteByPlayerId(playerId);

        AjaxResultBean result = new AjaxResultBean();
        result.setStatus(AjaxStatus.SUCCESS.getStatus());
        result.setMsg("刪除成功!");
        return result;
    }
}
