package willie.com.revenue.beans.html.views.player;

import willie.com.revenue.beans.table.player.Players;
import willie.com.revenue.utils.StringUtil;

public class PlayerBean extends Players {
    public Integer getViewPlayerId() {
        return getPlayerId();
    }

    public String getViewPlayerName() {
        return getPlayerName();
    }

    public Integer getViewPlayerScale() {
        return getPlayerScale();
    }

    public void setAddPlayerId(Integer playerId) {
        setPlayerId(playerId);
    }

    public void setAddPlayerName(String playerName) {
        setPlayerName(playerName);
    }

    public void setAddPlayerScale(Integer playerScale) {
        setPlayerScale(playerScale);
    }

    public Integer getEditPlayerId() {
        return getPlayerId();
    }

    public String getEditPlayerName() {
        return getPlayerName();
    }

    public Integer getEditPlayerScale() {
        return getPlayerScale();
    }

    public void setEditPlayerId(Integer playerId) {
        setPlayerId(playerId);
    }

    public void setEditPlayerName(String playerName) {
        setPlayerName(playerName);
    }

    public void setEditPlayerScale(Integer playerScale) {
        setPlayerScale(playerScale);
    }
}
