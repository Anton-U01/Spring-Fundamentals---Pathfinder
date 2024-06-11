package softuni.bg.pathfinder.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import softuni.bg.pathfinder.models.dtos.RouteInfoDto;
import softuni.bg.pathfinder.services.RouteService;

import java.util.List;

@Controller
public class HomeController {
    private final RouteService routeService;

    public HomeController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/")
    private String home(Model model){
        RouteInfoDto routeInfoDto = routeService.getMostCommentedRoute();
        List<String> pictures = routeService.getAllPictures();
        model.addAttribute("routeDto",routeInfoDto);
        model.addAttribute("pictures",pictures);
        return "index";
    }
    @GetMapping("/about")
    private String about(){
        return "about";
    }


}
