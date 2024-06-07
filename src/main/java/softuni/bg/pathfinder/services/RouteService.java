package softuni.bg.pathfinder.services;

import softuni.bg.pathfinder.models.dtos.RouteInfoDto;

import java.util.List;

public interface RouteService {
    List<RouteInfoDto> getAllRoutes();
}
