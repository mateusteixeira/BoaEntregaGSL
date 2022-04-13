package br.com.boaentrega.api;


import br.com.boaentrega.domain.dto.WareHouseDTO;
import br.com.boaentrega.service.WareHouseService;
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
@RequestMapping("/warehouse")
public class WareHouseAPI {

    private final WareHouseService wareHouseService;

    public WareHouseAPI(WareHouseService wareHouseService) {
        this.wareHouseService = wareHouseService;
    }

    @ApiOperation(value = "Cria um Depósito")
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<WareHouseDTO> createWareHouse(@RequestBody WareHouseDTO wareHouseDTO) {
        WareHouseDTO savedWareHouseDTO = this.wareHouseService.createWareHouse(wareHouseDTO);
        URI location = getUriToHeader(savedWareHouseDTO);
        return ResponseEntity.created(location).body(savedWareHouseDTO);
    }

    @ApiOperation(value = "Retorna todos os Depósitos")
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<WareHouseDTO>> getWareHouses(Pageable pageable) {
        return ResponseEntity.ok(wareHouseService.getAllWareHouses(pageable));
    }

    @ApiOperation(value = "Retorna um Depósito por Id.")
    @GetMapping(value = "{id}", produces = "application/json")
    public ResponseEntity<WareHouseDTO> getWareHouse(@PathVariable(name = "id") Long idWareHouse) {
        return ResponseEntity.ok(wareHouseService.getWareHouseById(idWareHouse));
    }

    @ApiOperation(value = "Atualiza um Depóstio por Id.")
    @PutMapping(value = "{id}", produces = "application/text", consumes = "application/json")
    public ResponseEntity<Object> updateWareHouse(@RequestBody WareHouseDTO wareHouseDTO, @PathVariable(name = "id") Long idWareHouse) {
        wareHouseService.updateWareHouse(wareHouseDTO, idWareHouse);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Deleta um Depóstio por Id.")
    @DeleteMapping(value = "{id}", produces = "application/text")
    public ResponseEntity<Object> deleteWareHouse(@PathVariable(name = "id") Long idWareHouse) {
        wareHouseService.deleteWareHouse(idWareHouse);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Deleta todos os Depósitos.")
    @DeleteMapping(produces = "application/text")
    public ResponseEntity<Object> deleteAllWareHouses() {
        wareHouseService.deleteAllWareHouses();
        return ResponseEntity.ok().build();
    }

    private URI getUriToHeader(WareHouseDTO wareHouseDTO) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(wareHouseDTO.getId())
                .toUri();
    }

}
