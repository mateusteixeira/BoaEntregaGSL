package br.com.boaentrega.translator;

import br.com.boaentrega.domain.User;
import br.com.boaentrega.domain.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingInheritanceStrategy;

@Mapper(mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_ALL_FROM_CONFIG)
public interface UserTranslator extends AbstractTranslator<User, Long, UserDTO> {


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
