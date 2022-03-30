package br.com.boaentregasupport.repository;

import br.com.boaentregasupport.domain.CustomerOccurrence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerOccurrenceRepository extends JpaRepository<CustomerOccurrence, Long> {

    CustomerOccurrence findByCode(Long code);
}
