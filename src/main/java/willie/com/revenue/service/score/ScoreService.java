package willie.com.revenue.service.score;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import willie.com.revenue.beans.html.views.score.ScoreBean;
import willie.com.revenue.beans.html.views.score.ScoreReportBean;
import willie.com.revenue.beans.query.score.ScoreQueryBean;
import willie.com.revenue.beans.table.score.Score;
import willie.com.revenue.dao.score.ScoreDao;
import willie.com.revenue.service.system.SessionService;

import java.util.List;

@Service
public class ScoreService {
    private ScoreDao scoreDao;

    private SessionService sessionService;

    @Autowired
    public void setScoreDao(ScoreDao scoreDao) {
        this.scoreDao = scoreDao;
    }

    @Autowired
    public void setSessionService(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    public ScoreReportBean findPosScores(ScoreQueryBean condition){
        ScoreReportBean result =scoreDao.findPosScores(condition);
        if (result == null) {
            return new ScoreReportBean();
        }
        return result;
    }

    public ScoreReportBean findNegScores(ScoreQueryBean condition){
        ScoreReportBean result =scoreDao.findNegScores(condition);
        if (result == null) {
            return new ScoreReportBean();
        }
        return result;
    }


    public ScoreReportBean findRoundScores(ScoreQueryBean condition){
        ScoreReportBean result =scoreDao.findRoundScores(condition);
        if (result == null) {
            return new ScoreReportBean();
        }
        return result;
    }

    public ScoreReportBean findTotalScoresByRecordDate(ScoreQueryBean condition){
        ScoreReportBean result =scoreDao.findTotalScoresByRecordDate(condition);
        if (result == null) {
            return new ScoreReportBean();
        }
        return result;
    }

    public List<ScoreReportBean> findTotalScoresByRecordDateGroupByPlayerId(ScoreQueryBean condition){
        return scoreDao.findTotalScoresByRecordDateGroupByPlayerId(condition);
    }

    public void save(Score score) {
        score.setModifyInfo(sessionService.getMemberBean().getMemberId());
        duplicate(score);
    }

    private void duplicate(Score score) {
        scoreDao.save(score);
    }

    public void deleteByRecordDateAndPlayerId(String recordDate, Integer playerId) {
        scoreDao.deleteByRecordDateAndPlayerId(recordDate, playerId);
    }

    public List<ScoreBean> findScores() {
        return scoreDao.findScores();
    }
}
