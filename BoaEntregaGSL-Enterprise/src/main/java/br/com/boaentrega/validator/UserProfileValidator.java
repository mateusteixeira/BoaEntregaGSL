package br.com.boaentrega.validator;

import br.com.boaentrega.domain.User;
import br.com.boaentrega.domain.UserProfile;
import br.com.boaentrega.domain.enumeration.Profile;
import br.com.boaentrega.exception.UnauthorizedOperationException;
import br.com.boaentrega.service.UserService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static java.lang.String.format;

@Component
public class UserProfileValidator {

    private final UserService userService;

    public UserProfileValidator(@Lazy UserService userService) {
        this.userService = userService;
    }

    public void validateUserIsAuthorized(Long idApprovalUser) {
        User user = userService.getUserOrThrowNotFoundException(idApprovalUser);
        UserProfile userProfile = user.getUserProfile();
        if (Objects.isNull(userProfile) || !Profile.ADMINISTRATOR.equals(userProfile.getProfile())) {
            throw new UnauthorizedOperationException(format("O usuário %s não tem autorização para este recurso", idApprovalUser));
        }
    }
}
