package willie.com.revenue.beans.html.views.score;

public class ScoreReportBean {
    private String playerName;

    private Integer totalScore;

    private Integer totalRound;

    private Integer totalRoundScore;

    private Integer total;

    {
        setTotalScore(0);
        setTotalRound(0);
        setTotalRoundScore(0);
        setTotal(0);
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public Integer getTotalRoundScore() {
        return totalRoundScore;
    }

    public void setTotalRoundScore(Integer totalRoundScore) {
        this.totalRoundScore = totalRoundScore;
    }

    public Integer getTotalRound() {
        return totalRound;
    }

    public void setTotalRound(Integer totalRound) {
        this.totalRound = totalRound;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
