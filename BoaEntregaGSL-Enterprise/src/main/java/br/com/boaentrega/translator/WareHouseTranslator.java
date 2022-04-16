package br.com.boaentrega.translator;

import br.com.boaentrega.domain.User;
import br.com.boaentrega.domain.WareHouse;
import br.com.boaentrega.domain.dto.UserDTO;
import br.com.boaentrega.domain.dto.WareHouseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingInheritanceStrategy;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Service;

@Mapper(mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_ALL_FROM_CONFIG)
public interface WareHouseTranslator extends AbstractTranslator<WareHouse, Long, WareHouseDTO>{


//    @Override
//    public WareHouseDTO toDTO(WareHouse iEntity) {
//        return null;
//    }
//
//    @Override
//    public WareHouse toEntity(WareHouseDTO abstractDTO) {
//        return null;
//    }
//
//    @Override
//    public void update(WareHouse iEntity, WareHouseDTO abstractDTO) {
//
//    }
}
