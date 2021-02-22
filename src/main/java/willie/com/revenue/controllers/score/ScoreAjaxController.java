package willie.com.revenue.controllers.score;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import willie.com.revenue.beans.html.ajax.AjaxResultBean;
import willie.com.revenue.enums.system.AjaxStatus;
import willie.com.revenue.service.score.ScoreService;

@RestController
public class ScoreAjaxController {
    private ScoreService scoreService;

    @Autowired
    public void setScoreService(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @DeleteMapping("/score/{recordDate}/{playerId}")
    public AjaxResultBean deleteReocrd(@PathVariable String recordDate, @PathVariable Integer playerId) {
        scoreService.deleteByRecordDateAndPlayerId(recordDate, playerId);

        AjaxResultBean result = new AjaxResultBean();
        result.setStatus(AjaxStatus.SUCCESS.getStatus());
        result.setMsg("刪除成功!");
        return result;
    }
}
