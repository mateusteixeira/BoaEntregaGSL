package br.com.boaentrega.service;

import br.com.boaentrega.BoaEntregaGSLUrls;
import br.com.boaentrega.exception.RequestExecutorException;
import br.com.boaentrega.request.AbstractRequestExecutorService;
import br.com.boaentrega.request.BoaEntregaGSLExternalUrls;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.net.URI;
import java.util.Map;

@Component
public class RequestExecutorService extends AbstractRequestExecutorService<BoaEntregaGSLUrls> {

    public RequestExecutorService(RestTemplate restTemplate, BoaEntregaGSLUrls boaEntregaGSLUrls) {
        super(restTemplate, boaEntregaGSLUrls);
    }
}
