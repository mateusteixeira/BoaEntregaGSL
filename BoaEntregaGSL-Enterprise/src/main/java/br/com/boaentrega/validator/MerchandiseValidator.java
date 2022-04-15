package br.com.boaentrega.validator;

import br.com.boaentrega.domain.AbstractEntity;
import br.com.boaentrega.domain.IEntity;
import br.com.boaentrega.domain.Merchandise;
import br.com.boaentrega.exception.MerchandiseAlreadyExistsException;
import br.com.boaentrega.repository.MerchandiseRepository;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class MerchandiseValidator extends AbstractValidator<Merchandise>{

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

    @Override
    public void validateExistent(AbstractEntity abstractEntity) {
        Merchandise merchandise = merchandiseRepository.findByCodeAndName(Long.valueOf(abstractEntity.getMainIdentifier()), abstractEntity.getSecondaryIdentifier());
        super.validate(merchandise);
    }

    @Override
    public String getValidatorName() {
        return Merchandise.class.getSimpleName();
    }
}
