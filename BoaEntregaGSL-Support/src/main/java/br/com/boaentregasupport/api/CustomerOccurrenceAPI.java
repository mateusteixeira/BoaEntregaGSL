package br.com.boaentregasupport.api;

import br.com.boaentregasupport.domain.dto.CustomerOccurrenceDTO;
import br.com.boaentregasupport.service.CustomerOccurrenceService;
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
@RequestMapping("/customer-occurrence")
public class CustomerOccurrenceAPI {

    private final CustomerOccurrenceService customerOccurrenceService;

    public CustomerOccurrenceAPI(CustomerOccurrenceService customerOccurrenceService) {
        this.customerOccurrenceService = customerOccurrenceService;
    }

    @ApiOperation(value = "Cria uma Ocorrência de Usuário")
    @PostMapping(produces="application/json", consumes="application/json")
    public ResponseEntity<CustomerOccurrenceDTO> createCustomerOccurrence(@RequestBody CustomerOccurrenceDTO customerOccurrenceDTO) {
        CustomerOccurrenceDTO savedCustomerOccurrenceDTO = this.customerOccurrenceService.createCustomerOccurrence(customerOccurrenceDTO);
        URI location = getUriToHeader(savedCustomerOccurrenceDTO);
        return ResponseEntity.created(location).body(savedCustomerOccurrenceDTO);
    }

    @ApiOperation(value = "Retorna todas as Ocorrência de Usuário")
    @GetMapping(produces="application/json")
    public ResponseEntity<List<CustomerOccurrenceDTO>> getCustomerOccurrences(Pageable pageable) {
        return ResponseEntity.ok(customerOccurrenceService.getAllCustomerOccurrences(pageable));
    }

    @ApiOperation(value = "Retorna uma Ocorrência de Usuário por Id.")
    @GetMapping(value = "{id}", produces="application/text")
    public ResponseEntity<CustomerOccurrenceDTO> getCustomerOccurrence(@PathVariable(name = "id") Long idCustomerOccurrence) {
        return ResponseEntity.ok(customerOccurrenceService.getCustomerOccurrenceById(idCustomerOccurrence));
    }

    @ApiOperation(value = "Atualiza uma Ocorrência de Usuário por Id.")
    @PutMapping(value = "{id}", produces="application/text", consumes="application/json")
    public ResponseEntity<Object> updateCustomerOccurrence(@RequestBody CustomerOccurrenceDTO customerOccurrenceDTO, @PathVariable(name = "id") Long idCustomerOccurrence) {
        customerOccurrenceService.updateCustomerOccurrence(customerOccurrenceDTO, idCustomerOccurrence);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Deleta uma Ocorrência de Usuário por Id.")
    @DeleteMapping(value = "{id}", produces="application/text")
    public ResponseEntity<Object> deleteCustomerOccurrence(@PathVariable(name = "id") Long idCustomerOccurrence) {
        customerOccurrenceService.deleteCustomerOccurrence(idCustomerOccurrence);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Deleta todas as Ocorrências de Usuário")
    @DeleteMapping(produces="application/text")
    public ResponseEntity<Object> deleteAllCustomerOccurrences() {
        customerOccurrenceService.deleteAllCustomerOccurrences();
        return ResponseEntity.ok().build();
    }

    private URI getUriToHeader(CustomerOccurrenceDTO customerOccurrenceDTO) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(customerOccurrenceDTO.getId())
                .toUri();
    }

}
