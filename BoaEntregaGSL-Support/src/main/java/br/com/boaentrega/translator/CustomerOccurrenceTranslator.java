package br.com.boaentrega.translator;

import br.com.boaentrega.domain.CustomerOccurrence;
import br.com.boaentrega.domain.dto.CustomerOccurrenceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface CustomerOccurrenceTranslator {

    CustomerOccurrenceDTO toDTO(CustomerOccurrence customerOccurrence);
    CustomerOccurrence toEntity(CustomerOccurrenceDTO customerOccurrenceDTO);
    void update(@MappingTarget CustomerOccurrence customerOccurrence, CustomerOccurrenceDTO customerOccurrenceDTO);

}
