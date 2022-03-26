package br.com.boaentrega.api;

import br.com.boaentrega.domain.dto.RouteDTO;
import br.com.boaentrega.service.RouteService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/route")
public class RouteAPI {

    private final RouteService routeService;

    public RouteAPI(RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping
    public ResponseEntity<RouteDTO> createRoute(@RequestBody RouteDTO routeDTO) {
        RouteDTO savedRouteDTO = this.routeService.createRoute(routeDTO);
        URI location = getUriToHeader(savedRouteDTO);
        return ResponseEntity.created(location).body(savedRouteDTO);
    }

    @GetMapping
    public ResponseEntity<List<RouteDTO>> getRoutes(Pageable pageable) {
        return ResponseEntity.ok(routeService.getAllRoutes(pageable));
    }

    @GetMapping("{id}")
    public ResponseEntity<RouteDTO> getRoute(@PathVariable(name = "id") Long idRoute) {
        return ResponseEntity.ok(routeService.getRouteById(idRoute));
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> updateRoute(@RequestBody RouteDTO routeDTO, @PathVariable(name = "id") Long idRoute) {
        routeService.updateRoute(routeDTO, idRoute);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteRoute(@PathVariable(name = "id") Long idRoute) {
        routeService.deleteRoute(idRoute);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteAllRoutes() {
        routeService.deleteAllRoutes();
        return ResponseEntity.ok().build();
    }

    private URI getUriToHeader(RouteDTO routeDTO) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(routeDTO.getId())
                .toUri();
    }

}
