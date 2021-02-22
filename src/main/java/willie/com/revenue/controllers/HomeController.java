package willie.com.revenue.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import willie.com.revenue.enums.system.PageManager;

@Controller
public class HomeController {
    @GetMapping("/welcome")
    public String index() {
        return PageManager.INDEX.getPath();
    }
}
