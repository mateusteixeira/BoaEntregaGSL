package br.com.boaentrega.repository;

import br.com.boaentrega.domain.CustomerOccurrence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerOccurrenceRepository extends JpaRepository<CustomerOccurrence, Long> {

    CustomerOccurrence findByCode(Long code);
}
