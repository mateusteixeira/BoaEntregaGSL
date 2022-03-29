package br.com.boaentrega.service;

import br.com.boaentrega.domain.Route;
import br.com.boaentrega.queues.messages.AsyncOperationMessage;
import br.com.boaentrega.queues.messages.EstimatedTimeCalculationMessage;
import br.com.boaentrega.queues.senders.EstimatedTimeCalculationSender;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class EstimateTimeDeliveryCalculatorService {

    private final RouteService routeService;

    private final EstimatedTimeCalculationSender estimatedTimeCalculationSender;

    public EstimateTimeDeliveryCalculatorService(@Lazy RouteService routeService, EstimatedTimeCalculationSender estimatedTimeCalculationSender) {
        this.routeService = routeService;
        this.estimatedTimeCalculationSender = estimatedTimeCalculationSender;
    }


    public void calculate(EstimatedTimeCalculationMessage estimatedTimeCalculationMessage) {
        Long idRoute = estimatedTimeCalculationMessage.getId();
        Route route = routeService.getRouteOrThrowNotFoundException(idRoute);
        //TODO fazer requestExecutor
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
