package softuni.bg.pathfinder.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.service.annotation.GetExchange;

@Controller
public class HomeController {
    @GetMapping("/")
    private String home(){
        return "index";
    }
}
