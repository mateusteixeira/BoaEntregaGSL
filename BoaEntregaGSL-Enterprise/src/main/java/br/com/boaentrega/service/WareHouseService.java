package br.com.boaentrega.service;

import br.com.boaentrega.domain.WareHouse;
import br.com.boaentrega.domain.dto.WareHouseDTO;
import br.com.boaentrega.repository.IJpaRepository;
import br.com.boaentrega.translator.AbstractTranslator;
import br.com.boaentrega.validator.AbstractValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class WareHouseService extends AbstractService<WareHouse, Long, WareHouseDTO> {

    private final RegistryWareHouseInSGEService registryWareHouseInSGEService;

    public WareHouseService(AbstractValidator<WareHouse, Long> abstractValidator, IJpaRepository<WareHouse, Long> abstractRepository, AbstractTranslator<WareHouse, Long, WareHouseDTO> abstractTranslator, RegistryWareHouseInSGEService registryWareHouseInSGEService) {
        super(abstractValidator, abstractRepository, abstractTranslator);
        this.registryWareHouseInSGEService = registryWareHouseInSGEService;
    }

    @Override
    public WareHouseDTO createAbstract(WareHouseDTO wareHouseDTO) {
        WareHouseDTO wareHouseDTOSaved = super.createAbstract(wareHouseDTO);
        registryWareHouseInSGEService.putInQueue(wareHouseDTOSaved);
        return wareHouseDTOSaved;
    }

}
