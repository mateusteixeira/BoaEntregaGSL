package br.com.boaentrega.service;

import br.com.boaentrega.exception.RequestExecutorException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static java.lang.String.format;

@Component
public class RequestExecutorService {

    private final RestTemplate restTemplate;

    public RequestExecutorService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void get() {}

    public void post() {}

    private void execute(String url) {
        try {

        } catch (Exception e) {
            throw new RequestExecutorException(format("Aconteceu algum erro na request para {}. Erro: {}", url, e.getMessage()));
        }
    }

}
