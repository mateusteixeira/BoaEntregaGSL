package br.com.boaentrega.service;

import br.com.boaentrega.domain.WareHouse;
import br.com.boaentrega.domain.dto.WareHouseDTO;
import br.com.boaentrega.exception.WareHouseNotFoundException;
import br.com.boaentrega.repository.WareHouseRepository;
import br.com.boaentrega.translator.WareHouseTranslator;
import br.com.boaentrega.validator.WareHouseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class WareHouseService {

    private final WareHouseValidator wareHouseValidator;

    private final WareHouseRepository wareHouseRepository;

    private final WareHouseTranslator wareHouseTranslator;

    private final RegistryWareHouseInSGEService registryWareHouseInSGEService;

    public WareHouseService(WareHouseValidator wareHouseValidator, WareHouseRepository wareHouseRepository, WareHouseTranslator wareHouseTranslator, RegistryWareHouseInSGEService registryWareHouseInSGEService) {
        this.wareHouseValidator = wareHouseValidator;
        this.wareHouseRepository = wareHouseRepository;
        this.wareHouseTranslator = wareHouseTranslator;
        this.registryWareHouseInSGEService = registryWareHouseInSGEService;
    }

    public WareHouseDTO createWareHouse(WareHouseDTO wareHouseDTO) {
        log.info("Creating wareHouse: {} {}", wareHouseDTO.getCode(), wareHouseDTO.getName());
        WareHouse wareHouse = wareHouseTranslator.toEntity(wareHouseDTO);
        wareHouseValidator.validateWareHouseExists(wareHouse);
        wareHouse = wareHouseRepository.save(wareHouse);
        registryWareHouseInSGEService.putInQueue(wareHouse);
        return wareHouseTranslator.toDTO(wareHouse);
    }

    public WareHouseDTO getWareHouseById(Long idWareHouse) {
        WareHouse wareHouse = getWareHouseOrThrowNotFoundException(idWareHouse);
        return wareHouseTranslator.toDTO(wareHouse);
    }

    public WareHouse getWareHouseOrThrowNotFoundException(Long idWareHouse) {
        Optional<WareHouse> wareHouseOp = wareHouseRepository.findById(idWareHouse);
        return wareHouseOp.orElseThrow(() -> new WareHouseNotFoundException(String.format("WareHouse for id %s not found", idWareHouse)));
    }

    public List<WareHouseDTO> getAllWareHouses(Pageable paging) {
        return wareHouseRepository.findAll(paging).stream().map(wareHouseTranslator::toDTO).collect(Collectors.toList());
    }

    public void updateWareHouse(WareHouseDTO wareHouseDTO, Long idWareHouse) {
        log.info("Updating wareHouse: {}", wareHouseDTO.getCode());
        WareHouse wareHouse = getWareHouseOrThrowNotFoundException(idWareHouse);
        wareHouseTranslator.update(wareHouse, wareHouseDTO);
        wareHouseRepository.save(wareHouse);
        registryWareHouseInSGEService.putInQueue(wareHouse);
    }

    public void deleteWareHouse(Long idWareHouse) {
        wareHouseRepository.deleteById(idWareHouse);
    }

    public void deleteAllWareHouses() {
        wareHouseRepository.deleteAll();
    }

}
