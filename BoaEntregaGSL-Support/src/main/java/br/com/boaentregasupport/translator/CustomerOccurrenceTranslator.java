package br.com.boaentregasupport.translator;

import br.com.boaentregasupport.domain.CustomerOccurrence;
import br.com.boaentregasupport.domain.dto.CustomerOccurrenceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface CustomerOccurrenceTranslator {

    CustomerOccurrenceDTO toDTO(CustomerOccurrence customerOccurrence);
    CustomerOccurrence toEntity(CustomerOccurrenceDTO customerOccurrenceDTO);
    void update(@MappingTarget CustomerOccurrence customerOccurrence, CustomerOccurrenceDTO customerOccurrenceDTO);

}
