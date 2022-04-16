package br.com.boaentrega.translator;

import br.com.boaentrega.domain.Merchandise;
import br.com.boaentrega.domain.dto.MerchandiseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingInheritanceStrategy;

@Mapper(mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_ALL_FROM_CONFIG)
public interface MerchandiseTranslator extends AbstractTranslator<Merchandise, Long, MerchandiseDTO> {

}
