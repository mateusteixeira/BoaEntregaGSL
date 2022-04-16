package br.com.boaentrega.translator;


import br.com.boaentrega.api.AbstractAPI;
import br.com.boaentrega.domain.AbstractEntity;
import br.com.boaentrega.domain.IEntity;
import br.com.boaentrega.domain.dto.AbstractDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.Serializable;

public interface AbstractTranslator<T extends AbstractEntity<ID>, ID extends Serializable, R extends AbstractDTO> extends ITranslator{

    R toDTO(T iEntity);
    T toEntity(R abstractDTO);
    void update(@MappingTarget T iEntity, R abstractDTO);
}
