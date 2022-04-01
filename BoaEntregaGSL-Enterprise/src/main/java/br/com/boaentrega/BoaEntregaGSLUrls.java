package br.com.boaentrega;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class BoaEntregaGSLUrls {

    public static final String ROUTE_POST = "/route";
    public static final String WARE_HOUSE_POST = "/warehouse";
    public static final String INTEGRATION = "/integration";

    private final Environment environment;

    public BoaEntregaGSLUrls(Environment environment) {
        this.environment = environment;
    }


    public String getMockUrl() {
        return environment.getProperty("sge.mock.location.host");
    }

    public String getMockPort() {
        return environment.getProperty("sge.mock.location.port");
    }
}
