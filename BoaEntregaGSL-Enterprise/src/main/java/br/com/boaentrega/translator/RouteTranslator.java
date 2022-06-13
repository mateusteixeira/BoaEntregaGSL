package br.com.boaentrega.translator;

import br.com.boaentrega.domain.Route;
import br.com.boaentrega.domain.dto.RouteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingInheritanceStrategy;

@Mapper(mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_ALL_FROM_CONFIG)
public interface RouteTranslator extends AbstractTranslator<Route, Long, RouteDTO> {

}
