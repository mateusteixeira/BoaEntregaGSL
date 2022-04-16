package br.com.boaentrega.service;

import br.com.boaentrega.domain.Route;
import br.com.boaentrega.domain.dto.RouteDTO;
import br.com.boaentrega.repository.IJpaRepository;
import br.com.boaentrega.translator.AbstractTranslator;
import br.com.boaentrega.validator.AbstractValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RouteService extends AbstractService<Route, Long, RouteDTO>{

    private final EstimateTimeDeliveryCalculatorService estimateTimeDeliveryCalculatorService;

    public RouteService(AbstractValidator<Route, Long> abstractValidator, IJpaRepository<Route, Long> abstractRepository, AbstractTranslator<Route, Long, RouteDTO> abstractTranslator, EstimateTimeDeliveryCalculatorService estimateTimeDeliveryCalculatorService) {
        super(abstractValidator, abstractRepository, abstractTranslator);
        this.estimateTimeDeliveryCalculatorService = estimateTimeDeliveryCalculatorService;
    }

    public RouteDTO createRoute(RouteDTO routeDTO) {
        RouteDTO routeDTOSaved = super.createAbstract(routeDTO);
        estimateTimeDeliveryCalculatorService.putInQueue(routeDTOSaved);
        return routeDTOSaved;
    }

    public Route getRouteOrThrowNotFoundException(Long idRoute) {
        return super.getAbstractOrThrowNotFoundException(idRoute);
    }

    public void saveRoute(Route route) {
        super.abstractRepository.save(route);
    }
}
