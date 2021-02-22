package willie.com.revenue.dao.player;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import willie.com.revenue.beans.html.views.player.PlayerBean;
import willie.com.revenue.beans.table.player.Players;

import java.util.List;

@Repository
@Mapper
public interface PlayerDao {
    void save(Players players);

    void deleteByPlayerId(Integer playerId);

    List<PlayerBean> findPlayers();
}
