package br.com.boaentrega.translator;


import br.com.boaentrega.api.AbstractAPI;
import br.com.boaentrega.domain.AbstractEntity;
import br.com.boaentrega.domain.IEntity;
import br.com.boaentrega.domain.dto.AbstractDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public abstract class AbstractTranslator<T extends AbstractEntity, R extends AbstractDTO> implements ITranslator{

    public abstract R toDTO(T iEntity);
    public abstract T toEntity(R abstractDTO);
    public abstract void update(T iEntity, R abstractDTO);
}
