package willie.com.revenue.beans.html.views.score;

import willie.com.revenue.beans.table.score.Score;

public class ScoreBean extends Score {
    private String playerName;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setAddRecordDate(String recordDate) {
        setRecordDate(recordDate);
    }

    public String getAddRecordDate() {
        return getRecordDate();
    }

    public void setAddPlayerId(Integer playerId) {
        setPlayerId(playerId);
    }

    public Integer getAddPlayerId() {
        return getPlayerId();
    }

    public void setAddScore(Integer score) {
        setScore(score);
    }

    public void setAddRoundCount(Integer roundCount) {
        setRoundCount(roundCount);
    }

    public String getViewRecordDate() {
        return getRecordDate();
    }

    public Integer getViewPlayerId() {
        return getPlayerId();
    }

    public String getViewPlayerName() {
        return getPlayerName();
    }

    public Integer getViewScore() {
        return getScore();
    }

    public Integer getViewRoundCount() {
        return getRoundCount();
    }


    public void setEditRecordDate(String recordDate) {
        setRecordDate(recordDate);
    }

    public void setEditPlayerId(Integer playerId) {
        setPlayerId(playerId);
    }

    public void setEditPlayerName(String playerName) {
        setPlayerName(playerName);
    }

    public void setEditScore(Integer score) {
        setScore(score);
    }

    public void setEditRoundCount(Integer roundCount) {
        setRoundCount(roundCount);
    }

    public String getEditRecordDate() {
        return getRecordDate();
    }

    public Integer getEditPlayerId() {
        return getPlayerId();
    }

    public String getEditPlayerName() {
        return getPlayerName();
    }

    public Integer getEditScore() {
        return getScore();
    }

    public Integer getEditRoundCount() {
        return getRoundCount();
    }


}
