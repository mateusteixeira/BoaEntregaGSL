package br.com.boaentrega.queues.senders;

import br.com.boaentrega.queues.Queues;
import org.springframework.stereotype.Component;

@Component("registryWareHouseInSGESender")
public class RegistryWareHouseInSGESender extends AbstractOperationQueueSender implements OperationQueueSender {

    @Override
    public String getQueue() {
        return Queues.REGISTRY_WARE_HOUSE_IN_SGE_QUEUE;
    }
}
