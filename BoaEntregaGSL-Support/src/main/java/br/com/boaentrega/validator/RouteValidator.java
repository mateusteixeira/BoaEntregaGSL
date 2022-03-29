package br.com.boaentrega.validator;

import br.com.boaentrega.domain.Route;
import br.com.boaentrega.exception.RouteAlreadyExistsException;
import br.com.boaentrega.repository.RouteRepository;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class RouteValidator {

    private final RouteRepository routeRepository;

    public RouteValidator(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public void validateRouteExists(Route route) {
        Route existentRoute = routeRepository.findByCityFromAndCityTo(route.getCityFrom(), route.getCityTo());
        if (Objects.nonNull(existentRoute)) {
            throw new RouteAlreadyExistsException(String.format("Route already exists for city {} to {} %s", route.getCityFrom(), route.getCityTo()));
        }
    }

}
