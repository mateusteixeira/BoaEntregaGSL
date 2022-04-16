package br.com.boaentregasupport.translator;

import br.com.boaentrega.translator.AbstractTranslator;
import br.com.boaentregasupport.domain.CustomerOccurrence;
import br.com.boaentregasupport.domain.dto.CustomerOccurrenceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingInheritanceStrategy;

@Mapper(mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_ALL_FROM_CONFIG)
public interface CustomerOccurrenceTranslator extends AbstractTranslator<CustomerOccurrence, Long, CustomerOccurrenceDTO> {

}
