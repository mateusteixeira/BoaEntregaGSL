package br.com.boaentregasupport.validator;

import br.com.boaentregasupport.domain.CustomerOccurrence;
import br.com.boaentregasupport.exception.CustomerOccurrenceAlreadyExistsException;
import br.com.boaentregasupport.repository.CustomerOccurrenceRepository;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CustomerOccurrenceValidator {

    private final CustomerOccurrenceRepository customerOccurrenceRepository;

    public CustomerOccurrenceValidator(CustomerOccurrenceRepository customerOccurrenceRepository) {
        this.customerOccurrenceRepository = customerOccurrenceRepository;
    }

    public void validateCustomerOccurrenceExists(CustomerOccurrence customerOccurrence) {
        CustomerOccurrence existentCustomerOccurrence = customerOccurrenceRepository.findByCode(customerOccurrence.getCode());
        if (Objects.nonNull(existentCustomerOccurrence)) {
            throw new CustomerOccurrenceAlreadyExistsException(String.format("CustomerOccurrence already exists for code %s", customerOccurrence.getCode()));
        }
    }

}
