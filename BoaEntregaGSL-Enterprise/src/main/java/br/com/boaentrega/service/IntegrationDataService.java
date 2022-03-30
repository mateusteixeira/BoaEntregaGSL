package br.com.boaentrega.service;

import br.com.boaentrega.domain.dto.IntegrationDataDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntegrationDataService {

    private final RequestExecutorService requestExecutorService;

    public IntegrationDataService(RequestExecutorService requestExecutorService) {
        this.requestExecutorService = requestExecutorService;
    }

    public List<IntegrationDataDTO> getDataForBI() {
        return null;
    }
}
