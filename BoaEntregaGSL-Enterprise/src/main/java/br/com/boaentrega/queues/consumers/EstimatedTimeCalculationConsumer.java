package br.com.boaentrega.queues.consumers;

import br.com.boaentrega.queues.Queues;
import br.com.boaentrega.queues.messages.EstimatedTimeCalculationMessage;
import br.com.boaentrega.service.EstimateTimeDeliveryCalculatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EstimatedTimeCalculationConsumer {

    private final EstimateTimeDeliveryCalculatorService estimateTimeDeliveryCalculatorService;

    public EstimatedTimeCalculationConsumer(EstimateTimeDeliveryCalculatorService estimateTimeDeliveryCalculatorService) {
        this.estimateTimeDeliveryCalculatorService = estimateTimeDeliveryCalculatorService;
    }

    @RabbitListener(queues = Queues.ESTIMATED_TIME_CALCULATION_IN_SGE_QUEUE)
    public void consume(EstimatedTimeCalculationMessage estimatedTimeCalculationMessage) {
        log.info("Consuming message at {}. Message: {}", Queues.ESTIMATED_TIME_CALCULATION_IN_SGE_QUEUE, estimatedTimeCalculationMessage);
        estimateTimeDeliveryCalculatorService.calculate(estimatedTimeCalculationMessage);
    }

}
