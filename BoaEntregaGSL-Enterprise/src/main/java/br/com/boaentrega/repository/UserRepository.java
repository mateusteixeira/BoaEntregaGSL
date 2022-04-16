package br.com.boaentrega.repository;

import br.com.boaentrega.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends IJpaRepository<User, Long> {

    User findByEmail(String email);
}
