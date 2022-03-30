package br.com.boaentrega.api;


import br.com.boaentrega.domain.dto.WareHouseDTO;
import br.com.boaentrega.service.WareHouseService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WareHouseAPI {

    private final WareHouseService wareHouseService;

    public WareHouseAPI(WareHouseService wareHouseService) {
        this.wareHouseService = wareHouseService;
    }

    @PostMapping
    public ResponseEntity<WareHouseDTO> createWareHouse(@RequestBody WareHouseDTO wareHouseDTO) {
        WareHouseDTO savedWareHouseDTO = this.wareHouseService.createWareHouse(wareHouseDTO);
        URI location = getUriToHeader(savedWareHouseDTO);
        return ResponseEntity.created(location).body(savedWareHouseDTO);
    }

    @GetMapping
    public ResponseEntity<List<WareHouseDTO>> getWareHouses(Pageable pageable) {
        return ResponseEntity.ok(wareHouseService.getAllWareHouses(pageable));
    }

    @GetMapping("{id}")
    public ResponseEntity<WareHouseDTO> getWareHouse(@PathVariable(name = "id") Long idWareHouse) {
        return ResponseEntity.ok(wareHouseService.getWareHouseById(idWareHouse));
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> updateWareHouse(@RequestBody WareHouseDTO wareHouseDTO, @PathVariable(name = "id") Long idWareHouse) {
        wareHouseService.updateWareHouse(wareHouseDTO, idWareHouse);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteWareHouse(@PathVariable(name = "id") Long idWareHouse) {
        wareHouseService.deleteWareHouse(idWareHouse);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
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
