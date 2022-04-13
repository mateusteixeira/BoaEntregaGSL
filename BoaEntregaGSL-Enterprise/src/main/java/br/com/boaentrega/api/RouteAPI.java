package br.com.boaentrega.api;

import br.com.boaentrega.domain.dto.RouteDTO;
import br.com.boaentrega.service.RouteService;
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
@RequestMapping("/route")
public class RouteAPI {

    private final RouteService routeService;

    public RouteAPI(RouteService routeService) {
        this.routeService = routeService;
    }

    @ApiOperation(value = "Cria uma Rota")
    @PostMapping(produces="application/json", consumes="application/json")
    public ResponseEntity<RouteDTO> createRoute(@RequestBody RouteDTO routeDTO) {
        RouteDTO savedRouteDTO = this.routeService.createRoute(routeDTO);
        URI location = getUriToHeader(savedRouteDTO);
        return ResponseEntity.created(location).body(savedRouteDTO);
    }

    @ApiOperation(value = "Retorna todas as Rotas")
    @GetMapping(produces="application/json")
    public ResponseEntity<List<RouteDTO>> getRoutes(Pageable pageable) {
        return ResponseEntity.ok(routeService.getAllRoutes(pageable));
    }

    @ApiOperation(value = "Retorna uma Rota por Id.")
    @GetMapping(value = "{id}", produces="application/json")
    public ResponseEntity<RouteDTO> getRoute(@PathVariable(name = "id") Long idRoute) {
        return ResponseEntity.ok(routeService.getRouteById(idRoute));
    }

    @ApiOperation(value = "Atualiza uma Rota por Id.")
    @PutMapping(value = "{id}", produces="application/text", consumes="application/json")
    public ResponseEntity<Object> updateRoute(@RequestBody RouteDTO routeDTO, @PathVariable(name = "id") Long idRoute) {
        routeService.updateRoute(routeDTO, idRoute);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Deleta uma Rora por Id.")
    @DeleteMapping(value = "{id}", produces="application/text")
    public ResponseEntity<Object> deleteRoute(@PathVariable(name = "id") Long idRoute) {
        routeService.deleteRoute(idRoute);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Deleta todas as Rotas.")
    @DeleteMapping(produces="application/text")
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
