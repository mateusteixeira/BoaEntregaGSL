package br.com.boaentrega.repository;

import br.com.boaentrega.domain.AbstractEntity;
import br.com.boaentrega.domain.IEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJpaRepository <T extends AbstractEntity> extends JpaRepository<T, Long> {
}
