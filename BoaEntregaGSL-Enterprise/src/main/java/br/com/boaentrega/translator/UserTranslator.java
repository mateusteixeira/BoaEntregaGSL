package br.com.boaentrega.translator;

import br.com.boaentrega.domain.User;
import br.com.boaentrega.domain.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingInheritanceStrategy;

@Mapper(mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_ALL_FROM_CONFIG)
public interface UserTranslator extends AbstractTranslator<User, Long, UserDTO> {

    @Override
    @Mapping(source = "user.userProfile.profile", target = "profile")
    UserDTO toDTO(User user);
}
