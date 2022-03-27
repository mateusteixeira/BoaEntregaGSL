package br.com.boaentrega.queues.senders;

import br.com.boaentrega.queues.Queues;
import org.springframework.stereotype.Component;

@Component("estimatedTimeCalculationSender")
public class EstimatedTimeCalculationSender extends AbstractOperationQueueSender implements OperationQueueSender {

    @Override
    public String getQueue() {
        return Queues.ESTIMATED_TIME_CALCULATION_QUEUE;
    }
}
