package br.com.boaentrega.validator;

import br.com.boaentrega.domain.WareHouse;
import br.com.boaentrega.repository.WareHouseRepository;
import org.springframework.stereotype.Component;

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
