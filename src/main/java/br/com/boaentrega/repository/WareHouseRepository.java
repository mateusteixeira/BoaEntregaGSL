package br.com.boaentrega.repository;

import br.com.boaentrega.domain.WareHouse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WareHouseRepository extends CrudRepository<WareHouse, Long> {
}