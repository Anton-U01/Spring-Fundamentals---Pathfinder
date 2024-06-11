package softuni.bg.pathfinder.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import softuni.bg.pathfinder.models.Route;
import softuni.bg.pathfinder.services.RouteService;
import softuni.bg.pathfinder.models.dtos.RouteInfoDto;

import java.util.List;

@Controller
public class RouteController {
    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }
    @GetMapping("/routes")
    public String routes(Model model){
        List<RouteInfoDto> allRoutes = routeService.getAllRoutes();
        model.addAttribute("allRoutes",allRoutes);
        return "routes";
    }

    @GetMapping("/routes/details/{id}")
    public String routeDetails(@PathVariable("id") Long id,Model model){
        Route route = routeService.getRouteById(id);
        model.addAttribute("route",route);

        return "route-details";
    }



}
