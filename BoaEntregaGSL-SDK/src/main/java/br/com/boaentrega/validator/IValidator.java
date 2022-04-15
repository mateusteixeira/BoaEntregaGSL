package br.com.boaentrega.validator;

import br.com.boaentrega.domain.AbstractEntity;

public interface IValidator {

    void validateExistent(AbstractEntity abstractEntity);

    String getValidatorName();

}
