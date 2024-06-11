package softuni.bg.pathfinder.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.service.annotation.GetExchange;
import softuni.bg.pathfinder.models.dtos.RouteInfoDto;
import softuni.bg.pathfinder.services.RouteService;

@Controller
public class HomeController {
    private final RouteService routeService;

    public HomeController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/")
    private String home(Model model){
        RouteInfoDto routeInfoDto = routeService.getMostCommentedRoute();
        model.addAttribute("routeDto",routeInfoDto);
        return "index";
    }
    @GetMapping("/about")
    private String about(){
        return "about";
    }


}
