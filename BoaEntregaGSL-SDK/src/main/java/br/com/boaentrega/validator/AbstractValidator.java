package br.com.boaentrega.validator;

import br.com.boaentrega.domain.AbstractEntity;
import br.com.boaentrega.domain.IEntity;
import br.com.boaentrega.exception.IEntityAlreadyExistsException;
import br.com.boaentrega.repository.IJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public abstract class AbstractValidator<T extends AbstractEntity> implements IValidator{

    protected void validate(AbstractEntity abstractEntity){
        if (Objects.nonNull(abstractEntity)) {
            throw new IEntityAlreadyExistsException(String.format("%s already exists for %s - %s", getValidatorName(), abstractEntity.getMainIdentifier(), abstractEntity.getSecondaryIdentifier()));
        }
    }
}
