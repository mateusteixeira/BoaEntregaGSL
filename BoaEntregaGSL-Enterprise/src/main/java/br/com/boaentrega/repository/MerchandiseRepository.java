package br.com.boaentrega.repository;

import br.com.boaentrega.domain.Merchandise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchandiseRepository extends IJpaRepository<Merchandise, Long> {

    Merchandise findByCodeAndName(Long code, String name);
}
