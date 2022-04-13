package br.com.boaentrega.service;

import br.com.boaentrega.BoaEntregaGSLUrls;
import br.com.boaentrega.domain.WareHouse;
import br.com.boaentrega.queues.messages.RegistryWareHouseInSGEMessage;
import br.com.boaentrega.queues.senders.RegistryWareHouseInSGESender;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Service;

@Service
public class RegistryWareHouseInSGEService {

    private final RequestExecutorService requestExecutorService;

    private final RegistryWareHouseInSGESender registryWareHouseInSGESender;

    public RegistryWareHouseInSGEService(RequestExecutorService requestExecutorService, RegistryWareHouseInSGESender registryWareHouseInSGESender) {
        this.requestExecutorService = requestExecutorService;
        this.registryWareHouseInSGESender = registryWareHouseInSGESender;
    }


    public void sendToSGE(RegistryWareHouseInSGEMessage registryWareHouseInSGEMessage) {
        requestExecutorService.post(BoaEntregaGSLUrls.WARE_HOUSE_POST, registryWareHouseInSGEMessage, Maps.newHashMap(), Maps.newHashMap(), Object.class);
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
