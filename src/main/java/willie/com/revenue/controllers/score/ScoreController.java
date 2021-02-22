package willie.com.revenue.controllers.score;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import willie.com.revenue.beans.html.HtmlConst;
import willie.com.revenue.beans.html.views.score.ScoreBean;
import willie.com.revenue.beans.query.score.ScoreQueryBean;
import willie.com.revenue.enums.system.PageManager;
import willie.com.revenue.service.player.PlayerService;
import willie.com.revenue.service.score.ScoreService;
import willie.com.revenue.utils.date.DateTimeUtil;

import java.util.Date;

@Controller
public class ScoreController {
    private PlayerService playerService;

    private ScoreService scoreService;

    @Autowired
    public void setPlayerService(PlayerService playerService) {
        this.playerService = playerService;
    }

    @Autowired
    public void setScoreService(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @GetMapping("/scores")
    public ModelAndView getScoreManagerPage() {
        ScoreBean scoreBean = new ScoreBean();
        scoreBean.setRecordDate(DateTimeUtil.format(new Date(), DateTimeUtil.SYS_FORMAT_DATE));

        return getScorePage(scoreBean);
    }

    @PostMapping("/scores")
    public ModelAndView saveScoreManagerPage(ScoreBean scoreBean) {
        scoreService.save(scoreBean);
        return getScorePage(scoreBean);
    }

    private ModelAndView getScorePage(ScoreBean scoreBean) {
        ModelAndView mv = new ModelAndView(PageManager.MAIN.getPath());
        mv.addObject(HtmlConst.FORM_ACTION, "/scores");
        mv.addObject(HtmlConst.FORM_VIEW, PageManager.SCORE_MANAGER.getPath());
        mv.addObject(HtmlConst.SCORE_ADD_BEAN, scoreBean);
        mv.addObject(HtmlConst.FORM_DATA, scoreService.findScores());
        mv.addObject(HtmlConst.PLAYERS, playerService.findPlayers());
        return mv;
    }

    @GetMapping("/score/report")
    public ModelAndView getScoreReportPage() {
        return getReportPage(new ScoreQueryBean());
    }

    @PostMapping("/score/report")
    public ModelAndView findScoreReportPage(ScoreQueryBean condition) {
        return getReportPage(condition);
    }

    private ModelAndView getReportPage(ScoreQueryBean condition){
        ModelAndView mv = new ModelAndView(PageManager.MAIN.getPath());
        mv.addObject(HtmlConst.FORM_VIEW, PageManager.SCORE_REPORT.getPath());
        mv.addObject(HtmlConst.FORM_ACTION, "/score/report");
        mv.addObject(HtmlConst.FORM_CONDITION, condition);
        mv.addObject(HtmlConst.SCORE_POS_BEAN, scoreService.findPosScores(condition));
        mv.addObject(HtmlConst.SCORE_NEG_BEAN, scoreService.findNegScores(condition));
        mv.addObject(HtmlConst.SCORE_ROUND_BEAN, scoreService.findRoundScores(condition));
        mv.addObject(HtmlConst.SCORE_TOTAL_BEAN, scoreService.findTotalScoresByRecordDate(condition));
        mv.addObject(HtmlConst.FORM_DATA, scoreService.findTotalScoresByRecordDateGroupByPlayerId(condition));
        return mv;
    }
}
