package br.com.boaentrega.api;


import br.com.boaentrega.domain.dto.IntegrationDataDTO;
import br.com.boaentrega.domain.dto.IntegrationDatasDTO;
import br.com.boaentrega.service.IntegrationDataService;
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
@RequestMapping("/public/thirdparty/integrations")
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Operação realizada com Sucesso!"),
        @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso."),
        @ApiResponse(code = 500, message = "Ocorreu um erro interno."),
})
@RestController
public class ThirdPartyAPI {

    private final IntegrationDataService integrationDataService;

    public ThirdPartyAPI(IntegrationDataService integrationDataService) {
        this.integrationDataService = integrationDataService;
    }

    @ApiOperation(value = "Retorna dados de integração com o BI")
    @GetMapping(value = "/getDataForBI", produces = "application/json")
    public ResponseEntity<List<IntegrationDataDTO>> getDataForBI() {
        log.info("Recebida request para dados de integração para o BI");
        IntegrationDatasDTO dataForBI = integrationDataService.getDataForBI();
        return ResponseEntity.ok(dataForBI.getIntegrationDataDTOS());
    }

}
