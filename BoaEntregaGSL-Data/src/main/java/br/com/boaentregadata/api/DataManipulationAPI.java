package br.com.boaentregadata.api;

import br.com.boaentregadata.dto.DataManipulationDTO;
import br.com.boaentregadata.service.DataManipulationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/data-manipulation")
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Operação realizada com Sucesso!"),
        @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso."),
        @ApiResponse(code = 500, message = "Ocorreu um erro interno."),
})
public class DataManipulationAPI {

    private final DataManipulationService dataManipulationService;

    public DataManipulationAPI(DataManipulationService dataManipulationService) {
        this.dataManipulationService = dataManipulationService;
    }

    @ApiOperation(value = "Retorna os métodos de manipulação de dados disponíveis")
    @GetMapping(value = "data-manipulation-methods", produces = "application/json")
    public ResponseEntity<List<DataManipulationDTO>> getDataManipulationMethods() {
        log.info("Recuperando métodos de Manipulação de Dados");
        return ResponseEntity.ok(dataManipulationService.getDataManipulation());
    }
}

