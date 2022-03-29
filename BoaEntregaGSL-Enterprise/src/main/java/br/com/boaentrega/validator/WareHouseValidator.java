package br.com.boaentrega.validator;

import br.com.boaentrega.domain.WareHouse;
import br.com.boaentrega.exception.WareHouseAlreadyExistsException;
import br.com.boaentrega.repository.WareHouseRepository;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class WareHouseValidator {

    private final WareHouseRepository wareHouseRepository;

    public WareHouseValidator(WareHouseRepository wareHouseRepository) {
        this.wareHouseRepository = wareHouseRepository;
    }

    public void validateWareHouseExists(WareHouse wareHouse) {
        WareHouse existentWareHouse = wareHouseRepository.findByCode(wareHouse.getCode());
        if (Objects.nonNull(existentWareHouse)) {
            throw new WareHouseAlreadyExistsException(String.format("WareHouse already exists for code %s", wareHouse.getCode()));
        }
    }

}
