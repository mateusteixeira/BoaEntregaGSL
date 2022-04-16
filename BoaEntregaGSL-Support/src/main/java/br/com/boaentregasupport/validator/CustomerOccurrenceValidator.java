package br.com.boaentregasupport.validator;

import br.com.boaentrega.validator.AbstractValidator;
import br.com.boaentregasupport.domain.CustomerOccurrence;
import br.com.boaentregasupport.repository.CustomerOccurrenceRepository;
import org.springframework.stereotype.Component;

@Component
public class CustomerOccurrenceValidator extends AbstractValidator<CustomerOccurrence, Long> {

    private final CustomerOccurrenceRepository customerOccurrenceRepository;

    public CustomerOccurrenceValidator(CustomerOccurrenceRepository customerOccurrenceRepository) {
        this.customerOccurrenceRepository = customerOccurrenceRepository;
    }

    @Override
    public void validateExistent(CustomerOccurrence customerOccurrence) {
        CustomerOccurrence byCode = customerOccurrenceRepository.findByCode(customerOccurrence.getCode());
        super.validate(byCode);
    }

    @Override
    public String getValidatorName() {
        return "CustomerOccurrence";
    }
}
