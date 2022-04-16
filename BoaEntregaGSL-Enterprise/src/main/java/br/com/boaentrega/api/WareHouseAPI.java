package br.com.boaentrega.api;


import br.com.boaentrega.domain.WareHouse;
import br.com.boaentrega.domain.dto.WareHouseDTO;
import br.com.boaentrega.service.AbstractService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WareHouseAPI extends AbstractAPI<WareHouse, Long, WareHouseDTO> {


    protected WareHouseAPI(AbstractService<WareHouse, Long, WareHouseDTO> abstractService) {
        super(abstractService);
    }

    @Override
    public ResponseEntity<WareHouseDTO> createAbstractEntity(@RequestBody WareHouseDTO wareHouseDTO) {
        return super.createAbstractEntity(wareHouseDTO);
    }

    @Override
    public ResponseEntity<List<WareHouseDTO>> getAbstractEntities(Pageable pageable) {
        return super.getAbstractEntities(pageable);
    }

    @Override
    public ResponseEntity<WareHouseDTO> getAbstractEntity(Long idAbstractEntity) {
        return super.getAbstractEntity(idAbstractEntity);
    }

    @Override
    public ResponseEntity<Object> updateAbstractEntity(@RequestBody WareHouseDTO wareHouseDTO, Long idAbstractEntity) {
        return super.updateAbstractEntity(wareHouseDTO, idAbstractEntity);
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
