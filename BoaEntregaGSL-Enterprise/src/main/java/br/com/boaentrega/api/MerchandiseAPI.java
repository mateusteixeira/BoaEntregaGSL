package br.com.boaentrega.api;

import br.com.boaentrega.domain.dto.MerchandiseDTO;
import br.com.boaentrega.service.MerchandiseService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/merchandise")
public class MerchandiseAPI {

    private final MerchandiseService merchandiseService;

    public MerchandiseAPI(MerchandiseService merchandiseService) {
        this.merchandiseService = merchandiseService;
    }

    @PostMapping
    public ResponseEntity<MerchandiseDTO> createMerchandise(@RequestBody MerchandiseDTO merchandiseDTO) {
        MerchandiseDTO savedMerchandiseDTO = this.merchandiseService.createMerchandise(merchandiseDTO);
        URI location = getUriToHeader(savedMerchandiseDTO);
        return ResponseEntity.created(location).body(savedMerchandiseDTO);
    }

    @GetMapping
    public ResponseEntity<List<MerchandiseDTO>> getMerchandises(Pageable pageable) {
        return ResponseEntity.ok(merchandiseService.getAllMerchandises(pageable));
    }

    @GetMapping("{id}")
    public ResponseEntity<MerchandiseDTO> getMerchandise(@PathVariable(name = "id") Long idMerchandise) {
        return ResponseEntity.ok(merchandiseService.getMerchandiseById(idMerchandise));
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> updateMerchandise(@RequestBody MerchandiseDTO merchandiseDTO, @PathVariable(name = "id") Long idMerchandise) {
        merchandiseService.updateMerchandise(merchandiseDTO, idMerchandise);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteMerchandise(@PathVariable(name = "id") Long idMerchandise) {
        merchandiseService.deleteMerchandise(idMerchandise);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteAllMerchandises() {
        merchandiseService.deleteAllMerchandises();
        return ResponseEntity.ok().build();
    }

    private URI getUriToHeader(MerchandiseDTO merchandiseDTO) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(merchandiseDTO.getId())
                .toUri();
    }

}
