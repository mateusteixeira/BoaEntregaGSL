package br.com.boaentrega.validator;

import br.com.boaentrega.domain.User;
import br.com.boaentrega.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserValidator extends AbstractValidator<User, Long> {

    private final UserRepository userRepository;

    public UserValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void validateExistent(User user) {
        User existentUser = userRepository.findByEmail(user.getEmail());
        super.validate(existentUser);
    }

    @Override
    public String getValidatorName() {
        return "User";
    }
}
