package br.com.boaentrega.api;

import br.com.boaentrega.domain.Merchandise;
import br.com.boaentrega.domain.dto.AbstractDTO;
import br.com.boaentrega.domain.dto.MerchandiseDTO;
import br.com.boaentrega.service.AbstractService;
import br.com.boaentrega.service.MerchandiseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Operação realizada com Sucesso!"),
        @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso."),
        @ApiResponse(code = 500, message = "Ocorreu um erro interno."),
})
@RestController
@RequestMapping("/merchandise")
public class MerchandiseAPI extends AbstractAPI<Merchandise, MerchandiseDTO> {
    protected MerchandiseAPI(MerchandiseService merchandiseService) {
        super(merchandiseService);
    }
//
//    private final MerchandiseService<Merchandise, MerchandiseDTO> merchandiseService;
//
//    public MerchandiseAPI(MerchandiseService merchandiseService) {
//        this.merchandiseService = merchandiseService;
//    }
//


@Override
@ApiOperation(value = "Cria uma Mercadoria")
public ResponseEntity<MerchandiseDTO> createAbstractEntity(MerchandiseDTO abstractDTO) {
    return super.createAbstractEntity(abstractDTO);
}
    //    @PostMapping(produces="application/json", consumes="application/json")
//    public ResponseEntity<MerchandiseDTO> createMerchandise(@RequestBody MerchandiseDTO merchandiseDTO) {
//        MerchandiseDTO savedMerchandiseDTO = this.merchandiseService.createMerchandise(merchandiseDTO);
//        URI location = getUriToHeader(savedMerchandiseDTO);
//        return ResponseEntity.created(location).body(savedMerchandiseDTO);
//    }
//
//    @ApiOperation(value = "Retorna todas as Mercadorias")
//    @GetMapping(produces="application/json", consumes="application/json")
//    public ResponseEntity<List<MerchandiseDTO>> getMerchandises(Pageable pageable) {
//        return ResponseEntity.ok(merchandiseService.getAllMerchandises(pageable));
//    }
//
//    @ApiOperation(value = "Retorna o status de entrega da mercadoria")
//    @GetMapping(value = "{id}/delivery-status", produces="application/json", consumes="application/json")
//    public ResponseEntity<MerchandiseDTO> getMerchandisesDeliveryStatus(@PathVariable(name = "id") Long idMerchandise) {
//        return ResponseEntity.ok(merchandiseService.getMerchandiseDeliveryStatus(idMerchandise));
//    }
//
//    @ApiOperation(value = "Retorna uma Mercadoria por Id.")
//    @GetMapping(value = "{id}", produces="application/json", consumes="application/json")
//    public ResponseEntity<MerchandiseDTO> getMerchandise(@PathVariable(name = "id") Long idMerchandise) {
//        return ResponseEntity.ok(merchandiseService.getMerchandiseById(idMerchandise));
//    }
//
//    @ApiOperation(value = "Atualiza uma Mercadoria por Id.")
//    @PutMapping(value = "{id}", produces="application/json", consumes="application/json")
//    public ResponseEntity<Object> updateMerchandise(@RequestBody MerchandiseDTO merchandiseDTO, @PathVariable(name = "id") Long idMerchandise) {
//        merchandiseService.updateMerchandise(merchandiseDTO, idMerchandise);
//        return ResponseEntity.noContent().build();
//    }
//
//    @ApiOperation(value = "Deleta uma Mercadoria por Id.")
//    @DeleteMapping(value = "{id}", produces="application/json", consumes="application/json")
//    public ResponseEntity<Object> deleteMerchandise(@PathVariable(name = "id") Long idMerchandise) {
//        merchandiseService.deleteMerchandise(idMerchandise);
//        return ResponseEntity.ok().build();
//    }
//
//    @ApiOperation(value = "Deleta todas as Mercadorias.")
//    @DeleteMapping(produces="application/json", consumes="application/json")
//    public ResponseEntity<Object> deleteAllMerchandises() {
//        merchandiseService.deleteAllMerchandises();
//        return ResponseEntity.ok().build();
//    }
//
//    private URI getUriToHeader(MerchandiseDTO merchandiseDTO) {
//        return ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(merchandiseDTO.getId())
//                .toUri();
//    }

}
