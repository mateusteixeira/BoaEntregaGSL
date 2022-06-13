package br.com.boaentrega.translator;

import br.com.boaentrega.domain.WareHouse;
import br.com.boaentrega.domain.dto.WareHouseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingInheritanceStrategy;

@Mapper(mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_ALL_FROM_CONFIG)
public interface WareHouseTranslator extends AbstractTranslator<WareHouse, Long, WareHouseDTO> {

}
