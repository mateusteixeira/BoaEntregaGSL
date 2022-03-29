package br.com.boaentrega.queues.consumers;

import br.com.boaentrega.queues.Queues;
import br.com.boaentrega.queues.messages.RegistryWareHouseInSGEMessage;
import br.com.boaentrega.service.RegistryWareHouseInSGEService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RegistryWareHouseInSGEConsumer {

    private final RegistryWareHouseInSGEService registryWareHouseInSGEService;

    public RegistryWareHouseInSGEConsumer(RegistryWareHouseInSGEService registryWareHouseInSGEService) {
        this.registryWareHouseInSGEService = registryWareHouseInSGEService;
    }


    @RabbitListener(queues = Queues.REGISTRY_WARE_HOUSE_IN_SGE_QUEUE)
    public void consume(RegistryWareHouseInSGEMessage registryWareHouseInSGEMessage) {
        log.info("Consuming message at {}. Message: {}", Queues.REGISTRY_WARE_HOUSE_IN_SGE_QUEUE, registryWareHouseInSGEMessage);
        registryWareHouseInSGEService.sendToSGE(registryWareHouseInSGEMessage);
    }

}
