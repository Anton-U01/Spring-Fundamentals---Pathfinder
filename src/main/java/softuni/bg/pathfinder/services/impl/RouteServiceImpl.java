package softuni.bg.pathfinder.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.bg.pathfinder.models.Route;
import softuni.bg.pathfinder.repositories.RouteRepository;
import softuni.bg.pathfinder.services.RouteService;
import softuni.bg.pathfinder.models.dtos.RouteInfoDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {
    private final RouteRepository routeRepository;
    private final ModelMapper modelMapper;

    public RouteServiceImpl(RouteRepository routeRepository, ModelMapper modelMapper) {
        this.routeRepository = routeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public List<RouteInfoDto> getAllRoutes() {
        return routeRepository.findAll()
                .stream()
                .map(this::MapRouteToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Route getRouteById(Long id) {
        Optional<Route> optionalRoute = routeRepository.findById(id);
        return optionalRoute.orElse(null);
    }

    @Override
    public RouteInfoDto getMostCommentedRoute() {
        Optional<Route> mostCommentedRoute = routeRepository.findMostCommentedRoute();
        RouteInfoDto routeInfoDto = null;
        if(mostCommentedRoute.isPresent()){
            routeInfoDto = MapRouteToDto(mostCommentedRoute.get());
        }
        return routeInfoDto;
    }


    private RouteInfoDto MapRouteToDto(Route route) {
        RouteInfoDto dto = modelMapper.map(route, RouteInfoDto.class);
        dto.setPictureUrl(route.getPictures().stream().findFirst().get().getUrl());
        return dto;
    }
}
