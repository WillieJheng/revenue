package willie.com.revenue.beans.table.player;

import willie.com.revenue.beans.table.BaseTable;

public class Players extends BaseTable {
    private Integer playerId;

    private String playerName;

    private Integer playerScale;

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Integer getPlayerScale() {
        return playerScale;
    }

    public void setPlayerScale(Integer playerScale) {
        this.playerScale = playerScale;
    }
}
