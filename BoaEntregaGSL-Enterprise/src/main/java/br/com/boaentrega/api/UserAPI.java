package br.com.boaentrega.api;


import br.com.boaentrega.domain.User;
import br.com.boaentrega.domain.dto.UserDTO;
import br.com.boaentrega.service.AbstractService;
import br.com.boaentrega.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserAPI extends AbstractAPI<User, Long, UserDTO>{

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
