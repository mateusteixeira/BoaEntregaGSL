package br.com.boaentrega.service;

import br.com.boaentrega.BoaEntregaGSLUrls;
import br.com.boaentrega.domain.dto.IntegrationDatasDTO;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class IntegrationDataService {

    private final RequestExecutorService requestExecutorService;

    public IntegrationDataService(RequestExecutorService requestExecutorService) {
        this.requestExecutorService = requestExecutorService;
    }

    public IntegrationDatasDTO getDataForBI() {
        return requestExecutorService.get(BoaEntregaGSLUrls.INTEGRATION, new HashMap<>(), new HashMap<>(), IntegrationDatasDTO.class).getBody();
    }
}
