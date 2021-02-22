package willie.com.revenue.controllers.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import willie.com.revenue.beans.html.views.member.ChangePasswordBean;
import willie.com.revenue.beans.html.views.member.MemberBean;
import willie.com.revenue.enums.system.PageManager;
import willie.com.revenue.service.member.MemberService;
import willie.com.revenue.service.member.RoleService;
import willie.com.revenue.service.system.CodeService;
import willie.com.revenue.service.system.SessionService;

@Controller
public class MemberController {
    private SessionService sessionService;

    private MemberService memberService;

    private RoleService roleService;

    private CodeService codeService;


    @GetMapping("/member/change/pwd")
    public ModelAndView getModifyPasswordPage() {
        ModelAndView mv = new ModelAndView(PageManager.MAIN.getPath());
        mv.addObject("view", PageManager.MEMBER_CHANGE_PASSWORD.getPath());
        return mv;
    }

    @PostMapping("/member/change/pwd")
    public String saveModifyPassword(@ModelAttribute ChangePasswordBean changePasswordBean) {
        MemberBean memberBean = sessionService.getMemberBean();
        memberBean.setPassword(changePasswordBean.getNewPwd());
        memberBean.setModifyInfo(memberBean.getMemberId());
        memberService.save(memberBean);

        return "redirect:/logout";
    }


    @Autowired
    public void setSessionService(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @Autowired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Autowired
    public void setCodeService(CodeService codeService) {
        this.codeService = codeService;
    }
}
