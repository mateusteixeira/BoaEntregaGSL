package br.com.boaentrega.service;

import br.com.boaentrega.domain.User;
import br.com.boaentrega.domain.UserProfile;
import br.com.boaentrega.domain.dto.UserDTO;
import br.com.boaentrega.repository.IJpaRepository;
import br.com.boaentrega.translator.AbstractTranslator;
import br.com.boaentrega.validator.AbstractValidator;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractService<User, Long, UserDTO> {

    private final UserProfileService userProfileService;

    public UserService(AbstractValidator<User, Long> abstractValidator, IJpaRepository<User, Long> abstractRepository, AbstractTranslator<User, Long, UserDTO> abstractTranslator, UserProfileService userProfileService) {
        super(abstractValidator, abstractRepository, abstractTranslator);
        this.userProfileService = userProfileService;
    }

    @Override
    public UserDTO createAbstract(UserDTO userDTO) {
        UserDTO userDTOSaved = super.createAbstract(userDTO);
        userProfileService.putUserToApproval(userDTOSaved);
        return userDTOSaved;
    }

    public void activeUser(User user, UserProfile userProfile) {
        user.setUserProfile(userProfile);
        user.setActive(true);
        super.abstractRepository.save(user);
    }

    public User getUserOrThrowNotFoundException(Long idUser) {
        return super.getAbstractOrThrowNotFoundException(idUser);
    }

    public UserDTO getUserById(Long idUser) {
        User user = getUserOrThrowNotFoundException(idUser);
        return super.abstractTranslator.toDTO(user);
    }
}
