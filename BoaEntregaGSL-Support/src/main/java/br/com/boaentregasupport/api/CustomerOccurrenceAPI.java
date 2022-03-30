package br.com.boaentregasupport.api;

import br.com.boaentregasupport.domain.dto.CustomerOccurrenceDTO;
import br.com.boaentregasupport.service.CustomerOccurrenceService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class CustomerOccurrenceAPI {

    private final CustomerOccurrenceService customerOccurrenceService;

    public CustomerOccurrenceAPI(CustomerOccurrenceService customerOccurrenceService) {
        this.customerOccurrenceService = customerOccurrenceService;
    }

    @PostMapping
    public ResponseEntity<CustomerOccurrenceDTO> createCustomerOccurrence(@RequestBody CustomerOccurrenceDTO customerOccurrenceDTO) {
        CustomerOccurrenceDTO savedCustomerOccurrenceDTO = this.customerOccurrenceService.createCustomerOccurrence(customerOccurrenceDTO);
        URI location = getUriToHeader(savedCustomerOccurrenceDTO);
        return ResponseEntity.created(location).body(savedCustomerOccurrenceDTO);
    }

    @GetMapping
    public ResponseEntity<List<CustomerOccurrenceDTO>> getCustomerOccurrences(Pageable pageable) {
        return ResponseEntity.ok(customerOccurrenceService.getAllCustomerOccurrences(pageable));
    }

    @GetMapping("{id}")
    public ResponseEntity<CustomerOccurrenceDTO> getCustomerOccurrence(@PathVariable(name = "id") Long idCustomerOccurrence) {
        return ResponseEntity.ok(customerOccurrenceService.getCustomerOccurrenceById(idCustomerOccurrence));
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> updateCustomerOccurrence(@RequestBody CustomerOccurrenceDTO customerOccurrenceDTO, @PathVariable(name = "id") Long idCustomerOccurrence) {
        customerOccurrenceService.updateCustomerOccurrence(customerOccurrenceDTO, idCustomerOccurrence);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteCustomerOccurrence(@PathVariable(name = "id") Long idCustomerOccurrence) {
        customerOccurrenceService.deleteCustomerOccurrence(idCustomerOccurrence);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
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
