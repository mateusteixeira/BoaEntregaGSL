package br.com.boaentrega.api;


import br.com.boaentrega.domain.dto.IntegrationDataDTO;
import br.com.boaentrega.service.IntegrationDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/public/thirdparty/integrations")
public class ThirdPartyAPI {

    private final IntegrationDataService integrationDataService;

    public ThirdPartyAPI(IntegrationDataService integrationDataService) {
        this.integrationDataService = integrationDataService;
    }

    @GetMapping("/getDataForBI")
    public ResponseEntity<List<IntegrationDataDTO>> getDataForBI() {
        return ResponseEntity.ok(integrationDataService.getDataForBI());
    }

}
