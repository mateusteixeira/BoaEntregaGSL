package br.com.boaentrega.api;

import br.com.boaentrega.domain.Merchandise;
import br.com.boaentrega.domain.dto.AbstractDTO;
import br.com.boaentrega.domain.dto.MerchandiseDTO;
import br.com.boaentrega.service.AbstractService;
import br.com.boaentrega.service.MerchandiseService;
import io.swagger.annotations.*;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/merchandise")
public class MerchandiseAPI extends AbstractAPI<Merchandise, Long, MerchandiseDTO> {

    protected MerchandiseAPI(AbstractService<Merchandise, Long, MerchandiseDTO> abstractService) {
        super(abstractService);
    }

    @Override
    public ResponseEntity<MerchandiseDTO> createAbstractEntity(@RequestBody MerchandiseDTO merchandiseDTO) {
        return super.createAbstractEntity(merchandiseDTO);
    }

    @Override
    public ResponseEntity<List<MerchandiseDTO>> getAbstractEntities(Pageable pageable) {
        return super.getAbstractEntities(pageable);
    }

    @Override
    public ResponseEntity<MerchandiseDTO> getAbstractEntity(Long idAbstractEntity) {
        return super.getAbstractEntity(idAbstractEntity);
    }

    @Override
    public ResponseEntity<Object> updateAbstractEntity(@RequestBody MerchandiseDTO merchandiseDTO, Long idAbstractEntity) {
        return super.updateAbstractEntity(merchandiseDTO, idAbstractEntity);
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
