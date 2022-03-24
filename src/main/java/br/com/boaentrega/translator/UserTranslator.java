package br.com.boaentrega.translator;

import br.com.boaentrega.domain.User;
import br.com.boaentrega.domain.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper
public interface UserTranslator {

    UserDTO toDTO(User user);
    User toEntity(UserDTO userDTO);

}
