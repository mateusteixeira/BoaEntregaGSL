package br.com.boaentrega.validator;

import br.com.boaentrega.domain.AbstractEntity;
import br.com.boaentrega.domain.Merchandise;
import br.com.boaentrega.domain.Route;
import br.com.boaentrega.exception.RouteAlreadyExistsException;
import br.com.boaentrega.repository.RouteRepository;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class RouteValidator extends AbstractValidator<Route, Long>{

    private final RouteRepository routeRepository;

    public RouteValidator(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public void validateExistent(Route route) {
        Route existentRoute = routeRepository.findByCityFromAndCityTo(route.getCityFrom(), route.getCityTo());
        super.validate(existentRoute);
    }

    @Override
    public String getValidatorName() {
        return "Route";
    }
}
