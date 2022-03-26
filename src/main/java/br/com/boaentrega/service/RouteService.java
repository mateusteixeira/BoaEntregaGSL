package br.com.boaentrega.service;

import br.com.boaentrega.domain.Route;
import br.com.boaentrega.domain.dto.RouteDTO;
import br.com.boaentrega.exception.RouteNotFoundException;
import br.com.boaentrega.repository.RouteRepository;
import br.com.boaentrega.translator.RouteTranslator;
import br.com.boaentrega.validator.RouteValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class RouteService {

    private final RouteValidator routeValidator;

    private final RouteRepository routeRepository;

    private final RouteTranslator routeTranslator;

    public RouteService(RouteValidator routeValidator, RouteRepository routeRepository, RouteTranslator routeTranslator) {
        this.routeValidator = routeValidator;
        this.routeRepository = routeRepository;
        this.routeTranslator = routeTranslator;
    }

    public RouteDTO createRoute(RouteDTO routeDTO) {
        log.info("Creating route: {} {}", routeDTO.getCode(), routeDTO.getName());
        Route route = routeTranslator.toEntity(routeDTO);
        routeValidator.validateRouteExists(route);
        return routeTranslator.toDTO(routeRepository.save(route));
    }

    public RouteDTO getRouteById(Long idRoute) {
        Route route = getRouteOrThrowNotFoundException(idRoute);
        return routeTranslator.toDTO(route);
    }

    public Route getRouteOrThrowNotFoundException(Long idRoute) {
        Optional<Route> routeOp = routeRepository.findById(idRoute);
        return routeOp.orElseThrow(() -> new RouteNotFoundException(String.format("Route for id %s not found", idRoute)));
    }

    public List<RouteDTO> getAllRoutes(Pageable paging) {
        return routeRepository.findAll(paging).stream().map(routeTranslator::toDTO).collect(Collectors.toList());
    }

    public void updateRoute(RouteDTO routeDTO, Long idRoute) {
        log.info("Updating route: {}", routeDTO.getCode());
        Route route = getRouteOrThrowNotFoundException(idRoute);
        route.setCode(routeDTO.getCode());
        route.setName(routeDTO.getName());
        route.setEan(routeDTO.getEan());
        routeRepository.save(route);
    }

    public void deleteRoute(Long idRoute) {
        routeRepository.deleteById(idRoute);
    }

    public void deleteAllRoutes() {
        routeRepository.deleteAll();
    }
}
