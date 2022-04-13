package br.com.boaentrega.translator;

import br.com.boaentrega.domain.Merchandise;
import br.com.boaentrega.domain.dto.MerchandiseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface MerchandiseTranslator {

    MerchandiseDTO toDTO(Merchandise merchandise);

    Merchandise toEntity(MerchandiseDTO merchandiseDTO);

    void update(@MappingTarget Merchandise merchandise, MerchandiseDTO merchandiseDTO);

}
