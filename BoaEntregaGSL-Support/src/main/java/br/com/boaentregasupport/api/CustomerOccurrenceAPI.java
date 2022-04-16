package br.com.boaentregasupport.api;

import br.com.boaentrega.api.AbstractAPI;
import br.com.boaentrega.service.AbstractService;
import br.com.boaentregasupport.domain.CustomerOccurrence;
import br.com.boaentregasupport.domain.dto.CustomerOccurrenceDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer-occurrence")
public class CustomerOccurrenceAPI extends AbstractAPI<CustomerOccurrence, Long, CustomerOccurrenceDTO> {


    protected CustomerOccurrenceAPI(AbstractService<CustomerOccurrence, Long, CustomerOccurrenceDTO> abstractService) {
        super(abstractService);
    }

    @Override
    public ResponseEntity<CustomerOccurrenceDTO> createAbstractEntity(@RequestBody CustomerOccurrenceDTO customerOccurrenceDTO) {
        return super.createAbstractEntity(customerOccurrenceDTO);
    }

    @Override
    public ResponseEntity<List<CustomerOccurrenceDTO>> getAbstractEntities(Pageable pageable) {
        return super.getAbstractEntities(pageable);
    }

    @Override
    public ResponseEntity<CustomerOccurrenceDTO> getAbstractEntity(Long idAbstractEntity) {
        return super.getAbstractEntity(idAbstractEntity);
    }

    @Override
    public ResponseEntity<Object> updateAbstractEntity(@RequestBody CustomerOccurrenceDTO customerOccurrenceDTO, Long idAbstractEntity) {
        return super.updateAbstractEntity(customerOccurrenceDTO, idAbstractEntity);
    }

    @Override
    public ResponseEntity<Object> deleteAbstractEntity(Long idAbstractEntity) {
        return super.deleteAbstractEntity(idAbstractEntity);
    }

    @Override
    public ResponseEntity<Object> deleteAllAbstractEntities() {
        return super.deleteAllAbstractEntities();
    }

}
