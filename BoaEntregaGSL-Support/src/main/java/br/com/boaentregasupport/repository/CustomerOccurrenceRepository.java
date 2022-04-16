package br.com.boaentregasupport.repository;

import br.com.boaentrega.repository.IJpaRepository;
import br.com.boaentregasupport.domain.CustomerOccurrence;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerOccurrenceRepository extends IJpaRepository<CustomerOccurrence, Long> {

    CustomerOccurrence findByCode(Long code);
}
