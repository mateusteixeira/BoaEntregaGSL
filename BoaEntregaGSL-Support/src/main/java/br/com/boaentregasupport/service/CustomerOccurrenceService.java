package br.com.boaentregasupport.service;

import br.com.boaentregasupport.domain.CustomerOccurrence;
import br.com.boaentregasupport.domain.dto.CustomerOccurrenceDTO;
import br.com.boaentregasupport.exception.CustomerOccurrenceNotFoundException;
import br.com.boaentregasupport.repository.CustomerOccurrenceRepository;
import br.com.boaentregasupport.translator.CustomerOccurrenceTranslator;
import br.com.boaentregasupport.validator.CustomerOccurrenceValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CustomerOccurrenceService {

    private final CustomerOccurrenceValidator customerOccurrenceValidator;

    private final CustomerOccurrenceRepository customerOccurrenceRepository;

    private final CustomerOccurrenceTranslator customerOccurrenceTranslator;

    public CustomerOccurrenceService(CustomerOccurrenceValidator customerOccurrenceValidator, CustomerOccurrenceRepository customerOccurrenceRepository, CustomerOccurrenceTranslator customerOccurrenceTranslator) {
        this.customerOccurrenceValidator = customerOccurrenceValidator;
        this.customerOccurrenceRepository = customerOccurrenceRepository;
        this.customerOccurrenceTranslator = customerOccurrenceTranslator;
    }

    public CustomerOccurrenceDTO createCustomerOccurrence(CustomerOccurrenceDTO customerOccurrenceDTO) {
        log.info("Creating customerOccurrence: {} {}", customerOccurrenceDTO.getCode(), customerOccurrenceDTO.getCode());
        CustomerOccurrence customerOccurrence = customerOccurrenceTranslator.toEntity(customerOccurrenceDTO);
        customerOccurrenceValidator.validateCustomerOccurrenceExists(customerOccurrence);
        customerOccurrence = customerOccurrenceRepository.save(customerOccurrence);
        return customerOccurrenceTranslator.toDTO(customerOccurrence);
    }

    public CustomerOccurrenceDTO getCustomerOccurrenceById(Long idCustomerOccurrence) {
        CustomerOccurrence customerOccurrence = getCustomerOccurrenceOrThrowNotFoundException(idCustomerOccurrence);
        return customerOccurrenceTranslator.toDTO(customerOccurrence);
    }

    public CustomerOccurrence getCustomerOccurrenceOrThrowNotFoundException(Long idCustomerOccurrence) {
        Optional<CustomerOccurrence> customerOccurrenceOp = customerOccurrenceRepository.findById(idCustomerOccurrence);
        return customerOccurrenceOp.orElseThrow(() -> new CustomerOccurrenceNotFoundException(String.format("CustomerOccurrence for id %s not found", idCustomerOccurrence)));
    }

    public List<CustomerOccurrenceDTO> getAllCustomerOccurrences(Pageable paging) {
        return customerOccurrenceRepository.findAll(paging).stream().map(customerOccurrenceTranslator::toDTO).collect(Collectors.toList());
    }

    public void updateCustomerOccurrence(CustomerOccurrenceDTO customerOccurrenceDTO, Long idCustomerOccurrence) {
        log.info("Updating customerOccurrence: {}", customerOccurrenceDTO.getCode());
        CustomerOccurrence customerOccurrence = getCustomerOccurrenceOrThrowNotFoundException(idCustomerOccurrence);
        customerOccurrenceTranslator.update(customerOccurrence, customerOccurrenceDTO);
        customerOccurrenceRepository.save(customerOccurrence);
    }

    public void deleteCustomerOccurrence(Long idCustomerOccurrence) {
        customerOccurrenceRepository.deleteById(idCustomerOccurrence);
    }

    public void deleteAllCustomerOccurrences() {
        customerOccurrenceRepository.deleteAll();
    }

}
