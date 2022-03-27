package br.com.boaentrega.translator;

import br.com.boaentrega.domain.Route;
import br.com.boaentrega.domain.User;
import br.com.boaentrega.domain.dto.RouteDTO;
import br.com.boaentrega.domain.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface RouteTranslator {

    RouteDTO toDTO(Route route);
    Route toEntity(RouteDTO routeDTO);
    void update(@MappingTarget Route route, RouteDTO routeDTO);


}
