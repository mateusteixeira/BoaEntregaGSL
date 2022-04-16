package br.com.boaentregasupport.service;

import br.com.boaentrega.repository.IJpaRepository;
import br.com.boaentrega.service.AbstractService;
import br.com.boaentrega.translator.AbstractTranslator;
import br.com.boaentrega.validator.AbstractValidator;
import br.com.boaentregasupport.domain.CustomerOccurrence;
import br.com.boaentregasupport.domain.dto.CustomerOccurrenceDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerOccurrenceService extends AbstractService<CustomerOccurrence, Long, CustomerOccurrenceDTO> {


    public CustomerOccurrenceService(AbstractValidator<CustomerOccurrence, Long> abstractValidator, IJpaRepository<CustomerOccurrence, Long> abstractRepository, AbstractTranslator<CustomerOccurrence, Long, CustomerOccurrenceDTO> abstractTranslator) {
        super(abstractValidator, abstractRepository, abstractTranslator);
    }
}
