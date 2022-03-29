package br.com.boaentrega;

import org.springframework.core.env.Environment;

public class BoaEntregaGSLUrls {

    private static Environment environment;

    public BoaEntregaGSLUrls(Environment environment) {
        this.environment = environment;
    }


    public static String getMockUrl() {
        return environment.getProperty("sge.mock.location.host").concat("/").concat(environment.getProperty("sge.mock.location.port"));
    }
}
