package br.com.boaentrega.service;

import br.com.boaentrega.BoaEntregaGSLUrls;
import br.com.boaentrega.domain.dto.WareHouseDTO;
import br.com.boaentrega.queues.messages.RegistryWareHouseInSGEMessage;
import br.com.boaentrega.queues.senders.RegistryWareHouseInSGESender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Slf4j
@Service
public class RegistryWareHouseInSGEService {

    private final RequestExecutorService requestExecutorService;

    private final RegistryWareHouseInSGESender registryWareHouseInSGESender;

    public RegistryWareHouseInSGEService(RequestExecutorService requestExecutorService, RegistryWareHouseInSGESender registryWareHouseInSGESender) {
        this.requestExecutorService = requestExecutorService;
        this.registryWareHouseInSGESender = registryWareHouseInSGESender;
    }


    public void sendToSGE(RegistryWareHouseInSGEMessage registryWareHouseInSGEMessage) {
        requestExecutorService.post(BoaEntregaGSLUrls.WARE_HOUSE_POST, registryWareHouseInSGEMessage, new HashMap<>(), new HashMap<>(), Object.class);
        log.info("Depóstio {} registrado na SGE", registryWareHouseInSGEMessage);
    }

    public void putInQueue(WareHouseDTO wareHouseDTO) {
        RegistryWareHouseInSGEMessage registryWareHouseInSGEMessage = RegistryWareHouseInSGEMessage.builder()
                .code(wareHouseDTO.getCode())
                .location(wareHouseDTO.getLocation())
                .name(wareHouseDTO.getName())
                .capacity(wareHouseDTO.getCapacity())
                .build();
        registryWareHouseInSGESender.sendMessage(registryWareHouseInSGEMessage);
        log.info("Deposito {} adicionado na fila para registro", wareHouseDTO);
    }
}
