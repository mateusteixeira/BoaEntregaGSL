package br.com.boaentrega;

import br.com.boaentrega.request.BoaEntregaGSLExternalUrls;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class BoaEntregaGSLUrls extends BoaEntregaGSLExternalUrls {

    public static final String ROUTE_POST = "/route";
    public static final String WARE_HOUSE_POST = "/warehouse";
    public static final String INTEGRATION = "/integration";
    public static final String DELIVERY_STATUS = "/delivery-status";

    public BoaEntregaGSLUrls(Environment environment) {
        super(environment);
    }


    public String getUrl() {
        return "sge.mock.location.host";
    }

    public String getPort() {
        return "sge.mock.location.port";
    }
}
