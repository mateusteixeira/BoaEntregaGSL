package br.com.boaentrega.api;

import br.com.boaentrega.domain.Route;
import br.com.boaentrega.domain.dto.RouteDTO;
import br.com.boaentrega.service.AbstractService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/route")
public class RouteAPI extends AbstractAPI<Route, Long, RouteDTO>{


    protected RouteAPI(AbstractService<Route, Long, RouteDTO> abstractService) {
        super(abstractService);
    }

    @Override
    public ResponseEntity<RouteDTO> createAbstractEntity(@RequestBody RouteDTO routeDTO) {
        return super.createAbstractEntity(routeDTO);
    }

    @Override
    public ResponseEntity<List<RouteDTO>> getAbstractEntities(Pageable pageable) {
        return super.getAbstractEntities(pageable);
    }

    @Override
    public ResponseEntity<RouteDTO> getAbstractEntity(Long idAbstractEntity) {
        return super.getAbstractEntity(idAbstractEntity);
    }

    @Override
    public ResponseEntity<Object> updateAbstractEntity(@RequestBody RouteDTO routeDTO, Long idAbstractEntity) {
        return super.updateAbstractEntity(routeDTO, idAbstractEntity);
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
