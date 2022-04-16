package br.com.boaentrega.translator;

import br.com.boaentrega.domain.Merchandise;
import br.com.boaentrega.domain.Route;
import br.com.boaentrega.domain.dto.MerchandiseDTO;
import br.com.boaentrega.domain.dto.RouteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingInheritanceStrategy;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Service;

@Mapper(mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_ALL_FROM_CONFIG)
public interface RouteTranslator extends AbstractTranslator<Route, Long, RouteDTO>{

//
//    @Override
//    public RouteDTO toDTO(Route route) {
//        return RouteDTO.builder()
//                .id(route.getId())
//                .cityFrom(route.getCityFrom())
//                .cityTo(route.getCityTo())
//                .name(route.getName())
//                .code(route.getCode())
//                .durationInDays(route.getDurationInDays())
//                .build();
//    }
//
//    @Override
//    public Route toEntity(RouteDTO routeDTO) {
//        Route route = Route.builder()
//                .cityFrom(routeDTO.getCityFrom())
//                .cityTo(routeDTO.getCityTo())
//                .name(routeDTO.getName())
//                .code(routeDTO.getCode())
//                .durationInDays(routeDTO.getDurationInDays())
//                .build();
//        route.setId(routeDTO.getId());
//        return route;
//    }
//
//    @Override
//    public void update(Route route, RouteDTO routeDTO) {
//        route.setCityFrom(routeDTO.getCityFrom());
//        route.setCityTo(routeDTO.getCityTo());
//        route.setCode(routeDTO.getCode());
//        route.setName(routeDTO.getName());
//        route.setDurationInDays(routeDTO.getDurationInDays());
//    }
}
