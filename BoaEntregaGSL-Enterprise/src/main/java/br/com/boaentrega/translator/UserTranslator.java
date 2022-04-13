package br.com.boaentrega.translator;

import br.com.boaentrega.domain.User;
import br.com.boaentrega.domain.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface UserTranslator {

    UserDTO toDTO(User user);

    User toEntity(UserDTO userDTO);

    void update(@MappingTarget User user, UserDTO userDTO);

}
