package br.com.boaentrega.api;

import br.com.boaentrega.domain.Merchandise;
import br.com.boaentrega.domain.dto.MerchandiseDTO;
import br.com.boaentrega.service.AbstractService;
import br.com.boaentrega.service.MerchandiseService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/merchandise")
public class MerchandiseAPI extends AbstractAPI<Merchandise, Long, MerchandiseDTO> {

    private final MerchandiseService merchandiseService;

    protected MerchandiseAPI(AbstractService<Merchandise, Long, MerchandiseDTO> abstractService, MerchandiseService merchandiseService) {
        super(abstractService);
        this.merchandiseService = merchandiseService;
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

    @ApiOperation(value = "Retorna o status de entrega da mercadoria")
    @GetMapping(value = "{id}/delivery-status", produces = "application/text")
    public ResponseEntity<String> getMerchandisesDeliveryStatus(@PathVariable(name = "id") Long idMerchandise) {
        log.info("Recebida request para retorno de status de mercadoria com id {}", idMerchandise);
        return ResponseEntity.ok(merchandiseService.getMerchandiseDeliveryStatus(idMerchandise));
    }
}
