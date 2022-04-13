package br.com.boaentrega.service;

import br.com.boaentrega.BoaEntregaGSLUrls;
import br.com.boaentrega.domain.dto.IntegrationDatasDTO;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Service;

@Service
public class IntegrationDataService {

    private final RequestExecutorService requestExecutorService;

    public IntegrationDataService(RequestExecutorService requestExecutorService) {
        this.requestExecutorService = requestExecutorService;
    }

    public IntegrationDatasDTO getDataForBI() {
        return requestExecutorService.get(BoaEntregaGSLUrls.INTEGRATION, Maps.newHashMap(), Maps.newHashMap(), IntegrationDatasDTO.class).getBody();
    }
}
