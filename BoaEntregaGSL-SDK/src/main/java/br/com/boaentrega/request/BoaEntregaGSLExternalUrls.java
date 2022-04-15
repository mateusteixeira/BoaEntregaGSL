package br.com.boaentrega.request;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public abstract class BoaEntregaGSLExternalUrls implements ExternalUrls {

    protected final Environment environment;

    public BoaEntregaGSLExternalUrls(Environment environment) {
        this.environment = environment;
    }

    public String getMockUrl() {
        return environment.getProperty(getUrl());
    }

    public String getMockPort() {
        return environment.getProperty(getPort());
    }
}
