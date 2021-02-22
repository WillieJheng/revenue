package willie.com.revenue.controllers.member;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import willie.com.revenue.beans.html.HtmlConst;
import willie.com.revenue.beans.html.views.member.LoginBean;
import willie.com.revenue.beans.html.views.member.MemberBean;
import willie.com.revenue.beans.shiro.UserToken;
import willie.com.revenue.enums.system.PageManager;
import willie.com.revenue.service.member.MemberService;
import willie.com.revenue.service.system.SessionService;
import willie.com.revenue.utils.http.IpUtil;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    private MemberService memberService;

    private SessionService sessionService;

    @GetMapping("/login")
    public String getLogin() {
        return PageManager.LOGIN.getPath();
    }

    @PostMapping(value = "/login")
    public ModelAndView postLogin(@ModelAttribute LoginBean loginBean, HttpServletRequest httpRequest) {
        ModelAndView mv = new ModelAndView(PageManager.LOGIN.getPath());
        try {
            UserToken token = new UserToken(loginBean.getAccount(), loginBean.getPwd());
            token.setRememberMe(false);
            SecurityUtils.getSubject().login(token);

            MemberBean memberBean = memberService.updateLoginInfo(loginBean.getAccount(), IpUtil.getIpAddr(httpRequest));
            sessionService.setMemberBean(memberBean);
            sessionService.setRoles(memberService.getRoleIds(loginBean.getAccount()));
            sessionService.setMainMenu(memberService.getMainMenu(loginBean.getAccount()));
            sessionService.setRightMenu(memberService.getRightMenu(loginBean.getAccount()));

            mv.setViewName("redirect:/index");
            return mv;
        } catch (AccountException e) {
            mv.addObject("errorMsg", e.getMessage());
        } catch (Exception e) {
            mv.addObject("errorMsg", "登入異常，請洽管理人員");
        }
        return mv;
    }

    @RequestMapping({"/", "/index"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView(PageManager.MAIN.getPath());
        mv.addObject(HtmlConst.MEMBER_BEANS, memberService.findMembersByCreateMemberId(sessionService.getMemberBean().getMemberId()));
        mv.addObject(HtmlConst.FORM_VIEW, PageManager.INDEX.getPath());
        return mv;
    }

    @RequestMapping("/logout")
    public String logout() {
        SecurityUtils.getSubject().logout();
        return PageManager.LOGIN.getPath();
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
