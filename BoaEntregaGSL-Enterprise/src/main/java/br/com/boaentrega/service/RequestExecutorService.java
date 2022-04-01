package br.com.boaentrega.service;

import br.com.boaentrega.BoaEntregaGSLUrls;
import br.com.boaentrega.exception.RequestExecutorException;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.net.URI;
import java.util.Map;

import static java.lang.String.format;

@Component
public class RequestExecutorService {


    private final RestTemplate restTemplate;

    private final BoaEntregaGSLUrls boaEntregaGSLUrls;

    public RequestExecutorService(RestTemplate restTemplate, BoaEntregaGSLUrls boaEntregaGSLUrls) {
        this.restTemplate = restTemplate;
        this.boaEntregaGSLUrls = boaEntregaGSLUrls;
    }

    public <T> ResponseEntity<T> get(final String url, final Map<String, String> pathParams, final Map<String, String> queryParams, final Class<T> responseType) {
        return execute(url, HttpMethod.GET, null, pathParams, queryParams, responseType);
    }

    public <T> ResponseEntity<T> post(final String url, final Object value, final Map<String, String> pathParams, final Map<String, String> queryParams, final Class<T> responseType) {
        return execute(url, HttpMethod.POST, value, pathParams, queryParams, responseType);
    }

    private <T> ResponseEntity<T> execute(final String url, final HttpMethod method, final Object value, final Map<String, String> pathParams, final Map<String, String> queryParams, final Class<T> responseType) {
        String finalUrl = buildUrl(url);
        final URI uri = new UriTemplate(finalUrl).expand(pathParams);

        final RequestEntity<Object> request = new RequestEntity<>(value, new HttpHeaders(), method, uri);
        try {
            return restTemplate.exchange(request, responseType);
        } catch (Exception e) {
            throw new RequestExecutorException(e.getMessage());
        }
    }

    private String buildUrl(String url) {
        String mockUrl = boaEntregaGSLUrls.getMockUrl();
        String mockPort = boaEntregaGSLUrls.getMockPort();
        return mockUrl.concat(":").concat(mockPort).concat(url);
    }

}
