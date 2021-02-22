package willie.com.revenue.dao.score;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import willie.com.revenue.beans.html.views.score.ScoreBean;
import willie.com.revenue.beans.html.views.score.ScoreReportBean;
import willie.com.revenue.beans.query.score.ScoreQueryBean;
import willie.com.revenue.beans.table.score.Score;

import java.util.List;

@Repository
@Mapper
public interface ScoreDao {
    void save(Score score);

    void deleteByRecordDateAndPlayerId(String recordDate, Integer playerId);

    List<ScoreBean> findScores();

    ScoreReportBean findPosScores(ScoreQueryBean condition);

    ScoreReportBean findNegScores(ScoreQueryBean condition);

    ScoreReportBean findRoundScores(ScoreQueryBean condition);

    ScoreReportBean findTotalScoresByRecordDate(ScoreQueryBean condition);

    List<ScoreReportBean> findTotalScoresByRecordDateGroupByPlayerId(ScoreQueryBean condition);
}
