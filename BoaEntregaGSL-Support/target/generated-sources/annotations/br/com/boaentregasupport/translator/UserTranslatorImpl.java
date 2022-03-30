package br.com.boaentregasupport.translator;

import br.com.boaentrega.domain.User;
import br.com.boaentrega.domain.dto.UserDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-28T23:20:24-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class UserTranslatorImpl implements UserTranslator {

    @Override
    public UserDTO toDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        return userDTO;
    }

    @Override
    public User toEntity(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        return user;
    }

    @Override
    public void update(User user, UserDTO userDTO) {
        if ( userDTO == null ) {
            return;
        }
    }
}
