package br.com.boaentrega.validator;

import br.com.boaentrega.domain.User;
import br.com.boaentrega.exception.UserAlreadyExistsException;
import br.com.boaentrega.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UserValidator {

    private final UserRepository userRepository;

    public UserValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void validateUserExists(User user) {
        User existentUser = userRepository.findByEmail(user.getEmail());
        if (Objects.nonNull(existentUser)) {
            throw new UserAlreadyExistsException(String.format("User already exists for email %s", user.getEmail()));
        }
    }

}
