package br.com.boaentrega.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface IJpaRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
}
