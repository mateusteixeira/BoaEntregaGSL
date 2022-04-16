package br.com.boaentrega.service;

import br.com.boaentrega.BoaEntregaGSLUrls;
import br.com.boaentrega.request.AbstractRequestExecutorService;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RequestExecutorService extends AbstractRequestExecutorService<BoaEntregaGSLUrls> {

    public RequestExecutorService(RestTemplate restTemplate, BoaEntregaGSLUrls boaEntregaGSLUrls) {
        super(restTemplate, boaEntregaGSLUrls);
    }
}
