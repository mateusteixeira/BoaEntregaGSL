package br.com.boaentrega.service;

import br.com.boaentrega.BoaEntregaGSLUrls;
import br.com.boaentrega.domain.Route;
import br.com.boaentrega.domain.dto.RouteDTO;
import br.com.boaentrega.queues.messages.EstimatedTimeCalculationMessage;
import br.com.boaentrega.queues.senders.EstimatedTimeCalculationSender;
import br.com.boaentrega.translator.RouteTranslator;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class EstimateTimeDeliveryCalculatorService {

    private final RouteService routeService;

    private final RouteTranslator routeTranslator;

    private final RequestExecutorService requestExecutorService;

    private final EstimatedTimeCalculationSender estimatedTimeCalculationSender;

    public EstimateTimeDeliveryCalculatorService(@Lazy RouteService routeService, RouteTranslator routeTranslator, RequestExecutorService requestExecutorService, EstimatedTimeCalculationSender estimatedTimeCalculationSender) {
        this.routeService = routeService;
        this.routeTranslator = routeTranslator;
        this.requestExecutorService = requestExecutorService;
        this.estimatedTimeCalculationSender = estimatedTimeCalculationSender;
    }


    public void calculate(EstimatedTimeCalculationMessage estimatedTimeCalculationMessage) {
        Long idRoute = estimatedTimeCalculationMessage.getId();
        Route route = routeService.getRouteOrThrowNotFoundException(idRoute);
        RouteDTO routeDTO = routeTranslator.toDTO(route);
        RouteDTO routeSavedInSGE = requestExecutorService.post(BoaEntregaGSLUrls.ROUTE_POST, routeDTO, new HashMap<>(), new HashMap<>(), RouteDTO.class).getBody();
        routeService.saveRoute(routeTranslator.toEntity(routeSavedInSGE));
    }

    public void putInQueue(Route route) {
        EstimatedTimeCalculationMessage estimatedTimeCalculationMessage = EstimatedTimeCalculationMessage.builder()
                .id(route.getId())
                .cityFrom(route.getCityFrom())
                .cityTo(route.getCityTo())
                .build();
        estimatedTimeCalculationSender.sendMessage(estimatedTimeCalculationMessage);
    }
}
