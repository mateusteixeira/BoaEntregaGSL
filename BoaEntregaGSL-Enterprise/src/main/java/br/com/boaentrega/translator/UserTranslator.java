package br.com.boaentrega.translator;

import br.com.boaentrega.domain.Merchandise;
import br.com.boaentrega.domain.User;
import br.com.boaentrega.domain.dto.MerchandiseDTO;
import br.com.boaentrega.domain.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingInheritanceStrategy;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Mapper(mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_ALL_FROM_CONFIG)
public interface UserTranslator extends AbstractTranslator<User, Long, UserDTO>{


//    @Override
//    public UserDTO toDTO(User iEntity) {
//        return null;
//    }
//
//    @Override
//    public User toEntity(UserDTO abstractDTO) {
//        return null;
//    }
//
//    @Override
//    public void update(User iEntity, UserDTO abstractDTO) {
//
//    }
}
