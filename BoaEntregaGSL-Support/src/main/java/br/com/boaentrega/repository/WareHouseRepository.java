package br.com.boaentrega.repository;

import br.com.boaentrega.domain.WareHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WareHouseRepository extends JpaRepository<WareHouse, Long> {
    WareHouse findByCode(Long code);
}
