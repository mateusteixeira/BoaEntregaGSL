package br.com.boaentrega.repository;

import br.com.boaentrega.domain.UserProfile;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends IJpaRepository<UserProfile, Long> {
}
