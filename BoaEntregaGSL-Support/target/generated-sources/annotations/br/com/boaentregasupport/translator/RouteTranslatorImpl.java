package br.com.boaentregasupport.translator;

import br.com.boaentrega.domain.Route;
import br.com.boaentrega.domain.dto.RouteDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-28T23:20:24-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class RouteTranslatorImpl implements RouteTranslator {

    @Override
    public RouteDTO toDTO(Route route) {
        if ( route == null ) {
            return null;
        }

        RouteDTO routeDTO = new RouteDTO();

        return routeDTO;
    }

    @Override
    public Route toEntity(RouteDTO routeDTO) {
        if ( routeDTO == null ) {
            return null;
        }

        Route route = new Route();

        return route;
    }

    @Override
    public void update(Route route, RouteDTO routeDTO) {
        if ( routeDTO == null ) {
            return;
        }
    }
}
