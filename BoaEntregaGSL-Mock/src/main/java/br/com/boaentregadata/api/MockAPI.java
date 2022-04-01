package br.com.boaentregadata.api;

import br.com.boaentregadata.dto.IntegrationDataDTO;
import br.com.boaentregadata.dto.IntegrationDatasDTO;
import br.com.boaentregadata.dto.RegistryWareHouseInSGEMessage;
import br.com.boaentregadata.dto.RouteDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class MockAPI {


    @PostMapping("/route")
    public ResponseEntity<RouteDTO> createRoute(@RequestBody RouteDTO routeDTO) {
        routeDTO.setDurationInDays(10L);
        return ResponseEntity.ok(routeDTO);
    }

    @PostMapping("/warehouse")
    public ResponseEntity createWareHouse(@RequestBody RegistryWareHouseInSGEMessage registryWareHouseInSGEMessage) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/integration")
    public ResponseEntity<IntegrationDatasDTO> getDataIntegration() {
        IntegrationDataDTO integrationDataDTO = IntegrationDataDTO.builder().someData("someData 1").build();
        IntegrationDataDTO integrationDataDTO2 = IntegrationDataDTO.builder().someData("someData 2").build();
        IntegrationDatasDTO integrationDatasDTO = IntegrationDatasDTO.builder().integrationDataDTOS(Arrays.asList(integrationDataDTO, integrationDataDTO2)).build();
        return ResponseEntity.ok(integrationDatasDTO);
    }
}
