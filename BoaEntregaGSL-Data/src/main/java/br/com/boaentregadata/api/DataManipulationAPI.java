package br.com.boaentregadata.api;

import br.com.boaentregadata.dto.DataManipulationDTO;
import br.com.boaentregadata.service.DataManipulationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Operação realizada com Sucesso!"),
        @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso."),
        @ApiResponse(code = 500, message = "Ocorreu um erro interno."),
})
@RestController
@RequestMapping("/data-manipulation")
public class DataManipulationAPI {

    private final DataManipulationService dataManipulationService;

    public DataManipulationAPI(DataManipulationService dataManipulationService) {
        this.dataManipulationService = dataManipulationService;
    }

    @ApiOperation(value = "Retorna os métodos de manipulação de dados disponíveis")
    @GetMapping(value = "data-manipulation-methods", produces = "application/json")
    public ResponseEntity<List<DataManipulationDTO>> getDataManipulationMethods() {
        return ResponseEntity.ok(dataManipulationService.getDataManipulation());
    }
}
