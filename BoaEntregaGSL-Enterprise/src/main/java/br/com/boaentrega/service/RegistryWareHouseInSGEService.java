package br.com.boaentrega.service;

import br.com.boaentrega.domain.Route;
import br.com.boaentrega.domain.WareHouse;
import br.com.boaentrega.queues.messages.AsyncOperationMessage;
import br.com.boaentrega.queues.messages.RegistryWareHouseInSGEMessage;
import br.com.boaentrega.queues.senders.RegistryWareHouseInSGESender;
import org.springframework.stereotype.Service;

@Service
public class RegistryWareHouseInSGEService {

    private final RegistryWareHouseInSGESender registryWareHouseInSGESender;

    public RegistryWareHouseInSGEService(RegistryWareHouseInSGESender registryWareHouseInSGESender) {
        this.registryWareHouseInSGESender = registryWareHouseInSGESender;
    }


    public void sendToSGE(RegistryWareHouseInSGEMessage registryWareHouseInSGEMessage) {
        //TODO fazer requestExecutor
    }

    public void putInQueue(WareHouse wareHouse) {
        RegistryWareHouseInSGEMessage registryWareHouseInSGEMessage = RegistryWareHouseInSGEMessage.builder()
                .code(wareHouse.getCode())
                .location(wareHouse.getLocation())
                .name(wareHouse.getName())
                .capacity(wareHouse.getCapacity())
                .build();
        registryWareHouseInSGESender.sendMessage(registryWareHouseInSGEMessage);
    }
}
