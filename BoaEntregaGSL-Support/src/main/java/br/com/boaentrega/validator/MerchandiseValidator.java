package br.com.boaentrega.validator;

import br.com.boaentrega.domain.Merchandise;
import br.com.boaentrega.exception.MerchandiseAlreadyExistsException;
import br.com.boaentrega.repository.MerchandiseRepository;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class MerchandiseValidator {

    private final MerchandiseRepository merchandiseRepository;

    public MerchandiseValidator(MerchandiseRepository merchandiseRepository) {
        this.merchandiseRepository = merchandiseRepository;
    }

    public void validateMerchandiseExists(Merchandise merchandise) {
        Merchandise existentMerchandise = merchandiseRepository.findByCodeAndName(merchandise.getCode(), merchandise.getName());
        if (Objects.nonNull(existentMerchandise)) {
            throw new MerchandiseAlreadyExistsException(String.format("Merchandise already exists for email %s", merchandise.getCode()));
        }
    }

}
