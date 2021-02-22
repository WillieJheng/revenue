package willie.com.revenue.controllers.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import willie.com.revenue.beans.html.ajax.AjaxResultBean;
import willie.com.revenue.beans.html.views.member.ChangePasswordBean;
import willie.com.revenue.beans.html.views.member.MemberBean;
import willie.com.revenue.enums.system.AjaxStatus;
import willie.com.revenue.service.member.MemberService;
import willie.com.revenue.service.system.SessionService;
import willie.com.revenue.utils.encrypt.EncryptUtil;

@RestController
public class MemberAjaxController {
    private MemberService memberService;

    private SessionService sessionService;

    @RequestMapping(value = "/member/pwd/check", method = RequestMethod.OPTIONS)
    @ResponseBody
    public String checkMemberPassword(@RequestBody ChangePasswordBean bean) {
        MemberBean memberBean = sessionService.getMemberBean();
        if (EncryptUtil.encryptUserPassword(memberBean.getMemberId(), bean.getOldPwd()).equals(memberBean.getPassword())) {
            return "pass";
        } else {
            return "原密碼輸入不正確";
        }
    }

    @RequestMapping(value = "/{memberId}/update/status/{statusCode}", method = RequestMethod.OPTIONS)
    @ResponseBody
    public AjaxResultBean changeMemberStatus(@PathVariable String memberId, @PathVariable Integer statusCode) {
        MemberBean memberBean = memberService.findMemberByMemberId(memberId);
        memberBean.setStatus(statusCode);
        memberService.save(memberBean);

        AjaxResultBean result = new AjaxResultBean();
        result.setStatus(AjaxStatus.SUCCESS.getStatus());
        result.setMsg("會員狀態修改成功!");
        return result;
    }

    @Autowired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }

    @Autowired
    public void setSessionService(SessionService sessionService) {
        this.sessionService = sessionService;
    }
}
