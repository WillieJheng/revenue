package willie.com.revenue.service.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import willie.com.revenue.beans.html.views.player.PlayerBean;
import willie.com.revenue.beans.table.player.Players;
import willie.com.revenue.dao.player.PlayerDao;
import willie.com.revenue.service.system.SessionService;

import java.util.List;

@Service
public class PlayerService {
    private PlayerDao playerDao;

    private SessionService sessionService;

    @Autowired
    public void setPlayerDao(PlayerDao playerDao) {
        this.playerDao = playerDao;
    }

    @Autowired
    public void setSessionService(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    public void save(Players players) {
        players.setModifyInfo(sessionService.getMemberBean().getMemberId());
        duplicate(players);
    }

    public void duplicate(Players players) {
        playerDao.save(players);
    }

    public void deleteByPlayerId(Integer playerId) {
        playerDao.deleteByPlayerId(playerId);
    }

    public List<PlayerBean> findPlayers() {
        return playerDao.findPlayers();
    }
}

