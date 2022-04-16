package br.com.boaentregamock.api;

import br.com.boaentregamock.dto.IntegrationDataDTO;
import br.com.boaentregamock.dto.IntegrationDatasDTO;
import br.com.boaentregamock.dto.RegistryWareHouseInSGEMessage;
import br.com.boaentregamock.dto.RouteDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@Slf4j
@RestController
public class MockAPI {


    @PostMapping("/route")
    public ResponseEntity<RouteDTO> createRoute(@RequestBody RouteDTO routeDTO) {
        log.info("Recebida request de Rota no mock");
        routeDTO.setDurationInDays(10L);
        return ResponseEntity.ok(routeDTO);
    }

    @PostMapping("/warehouse")
    public ResponseEntity createWareHouse(@RequestBody RegistryWareHouseInSGEMessage registryWareHouseInSGEMessage) {
        log.info("Recebida request de Deposito no mock");
        return ResponseEntity.ok().build();
    }

    @GetMapping("/integration")
    public ResponseEntity<IntegrationDatasDTO> getDataIntegration() {
        log.info("Recebida request de DataIntegration no mock");
        IntegrationDataDTO integrationDataDTO = IntegrationDataDTO.builder().someData("someData 1").build();
        IntegrationDataDTO integrationDataDTO2 = IntegrationDataDTO.builder().someData("someData 2").build();
        IntegrationDatasDTO integrationDatasDTO = IntegrationDatasDTO.builder().integrationDataDTOS(Arrays.asList(integrationDataDTO, integrationDataDTO2)).build();
        return ResponseEntity.ok(integrationDatasDTO);
    }

    @GetMapping("/delivery-status")
    public ResponseEntity<String> getDeliveryStatus() {
        log.info("Recebida request de DeliveryStatus no mock");
        return ResponseEntity.ok("EM TRÂNSITO");
    }
}
