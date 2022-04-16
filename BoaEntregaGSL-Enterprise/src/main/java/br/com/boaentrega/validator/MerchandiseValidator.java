package br.com.boaentrega.validator;

import br.com.boaentrega.domain.AbstractEntity;
import br.com.boaentrega.domain.IEntity;
import br.com.boaentrega.domain.Merchandise;
import br.com.boaentrega.repository.MerchandiseRepository;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class MerchandiseValidator extends AbstractValidator<Merchandise, Long>{

    private final MerchandiseRepository merchandiseRepository;

    public MerchandiseValidator(MerchandiseRepository merchandiseRepository) {
        this.merchandiseRepository = merchandiseRepository;
    }

    @Override
    public void validateExistent(Merchandise merchandise) {
        Merchandise existentMerchandise = merchandiseRepository.findByCodeAndName(merchandise.getCode(), merchandise.getName());
        super.validate(existentMerchandise);
    }

    @Override
    public String getValidatorName() {
        return "Merchandise";
    }
}
