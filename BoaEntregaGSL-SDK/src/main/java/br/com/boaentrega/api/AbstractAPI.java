package br.com.boaentrega.api;

import br.com.boaentrega.domain.AbstractEntity;
import br.com.boaentrega.domain.dto.AbstractDTO;
import br.com.boaentrega.service.AbstractService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public abstract class AbstractAPI <T extends AbstractEntity, R extends AbstractDTO> {

    private final AbstractService<T, R> abstractService;

    protected AbstractAPI(AbstractService<T, R> abstractService) {
        this.abstractService = abstractService;
    }

    @PostMapping
    public ResponseEntity<R> createAbstractEntity(@RequestBody R abstractDTO) {
        R savedAbstractDTO = this.abstractService.createAbstract(abstractDTO);
        URI location = getUriToHeader(savedAbstractDTO);
        return ResponseEntity.created(location).body(savedAbstractDTO);
    }

    @GetMapping
    public ResponseEntity<List<R>> getAbstractEntities(Pageable pageable) {
        return ResponseEntity.ok(abstractService.getAllAbstracts(pageable));
    }

    @GetMapping("{id}")
    public ResponseEntity<R> getAbstractEntity(@PathVariable(name = "id") Long idAbstractEntity) {
        return ResponseEntity.ok(abstractService.getAbstractById(idAbstractEntity));
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> updateAbstractEntity(@RequestBody R abstractDTO, @PathVariable(name = "id") Long idAbstractEntity) {
        abstractService.updateAbstract(abstractDTO, idAbstractEntity);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteAbstractEntity(@PathVariable(name = "id") Long idAbstractEntity) {
        abstractService.deleteAbstract(idAbstractEntity);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteAllAbstractEntities() {
        abstractService.deleteAllAbstracts();
        return ResponseEntity.ok().build();
    }

    protected URI getUriToHeader(AbstractDTO abstractDTO) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(abstractDTO.getId())
                .toUri();
    }
}
