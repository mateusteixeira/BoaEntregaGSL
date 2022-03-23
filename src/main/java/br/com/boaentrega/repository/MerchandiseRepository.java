package br.com.boaentrega.repository;

import br.com.boaentrega.domain.Merchandise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchandiseRepository extends CrudRepository<Merchandise, Long> {
}
