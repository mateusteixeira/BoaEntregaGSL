package br.com.boaentrega.translator;

import br.com.boaentrega.domain.WareHouse;
import br.com.boaentrega.domain.dto.WareHouseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface WareHouseTranslator {

    WareHouseDTO toDTO(WareHouse wareHouse);
    WareHouse toEntity(WareHouseDTO wareHouseDTO);
    void update(@MappingTarget WareHouse wareHouse, WareHouseDTO wareHouseDTO);

}
