package br.com.boaentrega.repository;

import br.com.boaentrega.domain.document.UserToApprove;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserToApproveRepository extends MongoRepository<UserToApprove, String> {

    void deleteByIdUser(Long idUser);
}
