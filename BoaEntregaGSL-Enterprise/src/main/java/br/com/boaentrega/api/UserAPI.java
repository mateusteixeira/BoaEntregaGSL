package br.com.boaentrega.api;


import br.com.boaentrega.domain.User;
import br.com.boaentrega.domain.dto.UserDTO;
import br.com.boaentrega.service.AbstractService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserAPI extends AbstractAPI<User, Long, UserDTO> {

    protected UserAPI(AbstractService<User, Long, UserDTO> abstractService) {
        super(abstractService);
    }

    @Override
    public ResponseEntity<UserDTO> createAbstractEntity(@RequestBody UserDTO userDTO) {
        return super.createAbstractEntity(userDTO);
    }

    @Override
    public ResponseEntity<List<UserDTO>> getAbstractEntities(Pageable pageable) {
        return super.getAbstractEntities(pageable);
    }

    @Override
    public ResponseEntity<UserDTO> getAbstractEntity(Long idAbstractEntity) {
        return super.getAbstractEntity(idAbstractEntity);
    }

    @Override
    public ResponseEntity<Object> updateAbstractEntity(@RequestBody UserDTO userDTO, Long idAbstractEntity) {
        return super.updateAbstractEntity(userDTO, idAbstractEntity);
    }

    @Override
    public ResponseEntity<Object> deleteAbstractEntity(Long idAbstractEntity) {
        return super.deleteAbstractEntity(idAbstractEntity);
    }

    @Override
    public ResponseEntity<Object> deleteAllAbstractEntities() {
        return super.deleteAllAbstractEntities();
    }
}
