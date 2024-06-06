package softuni.bg.pathfinder.services;

import softuni.bg.pathfinder.services.dtos.RouteInfoDto;

import java.util.List;

public interface RouteService {
    List<RouteInfoDto> getAllRoutes();
}
