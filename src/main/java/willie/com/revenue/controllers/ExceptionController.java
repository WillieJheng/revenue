package willie.com.revenue.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import willie.com.revenue.enums.system.PageManager;

@Controller
public class ExceptionController implements ErrorController {
    @Override
    @RequestMapping("/error")
    public String getErrorPath() {
        return PageManager.ERROR_404.getPath();
    }
}
