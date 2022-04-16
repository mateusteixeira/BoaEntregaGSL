package br.com.boaentrega.validator;

import br.com.boaentrega.domain.Merchandise;
import br.com.boaentrega.domain.WareHouse;
import br.com.boaentrega.exception.WareHouseAlreadyExistsException;
import br.com.boaentrega.repository.WareHouseRepository;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class WareHouseValidator extends AbstractValidator<WareHouse, Long> {

    private final WareHouseRepository wareHouseRepository;

    public WareHouseValidator(WareHouseRepository wareHouseRepository) {
        this.wareHouseRepository = wareHouseRepository;
    }

    @Override
    public void validateExistent(WareHouse wareHouse) {
        WareHouse existentWareHouse = wareHouseRepository.findByCode(wareHouse.getCode());
        super.validate(existentWareHouse);
    }

    @Override
    public String getValidatorName() {
        return "WareHouse";
    }
}
