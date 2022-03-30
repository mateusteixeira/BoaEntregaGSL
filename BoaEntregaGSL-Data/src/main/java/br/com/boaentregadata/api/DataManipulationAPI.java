package br.com.boaentregadata.api;

import br.com.boaentregadata.dto.DataManipulationDTO;
import br.com.boaentregadata.service.DataManipulationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/data-manipulation")
public class DataManipulationAPI {

    private final DataManipulationService dataManipulationService;

    public DataManipulationAPI(DataManipulationService dataManipulationService) {
        this.dataManipulationService = dataManipulationService;
    }

    @GetMapping("data-manipulation-methods")
    public ResponseEntity<List<DataManipulationDTO>> getDataManipulationMethods() {
        return ResponseEntity.ok(dataManipulationService.getDataManipulation());
    }
}
