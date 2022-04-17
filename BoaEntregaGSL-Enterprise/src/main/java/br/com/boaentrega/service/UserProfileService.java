package br.com.boaentrega.service;

import br.com.boaentrega.domain.User;
import br.com.boaentrega.domain.UserProfile;
import br.com.boaentrega.domain.UserToApprove;
import br.com.boaentrega.domain.dto.ApproveUserDTO;
import br.com.boaentrega.domain.dto.UserDTO;
import br.com.boaentrega.domain.enumeration.Profile;
import br.com.boaentrega.repository.UserProfileRepository;
import br.com.boaentrega.repository.UserToApproveRepository;
import br.com.boaentrega.validator.UserProfileValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserProfileService {

    private final UserService userService;

    private final UserProfileValidator userProfileValidator;

    private final UserProfileRepository userProfileRepository;

    private final UserToApproveRepository userToApproveRepository;

    public UserProfileService(@Lazy UserService userService, UserProfileValidator userProfileValidator, UserProfileRepository userProfileRepository, UserToApproveRepository userToApproveRepository) {
        this.userService = userService;
        this.userProfileValidator = userProfileValidator;
        this.userProfileRepository = userProfileRepository;
        this.userToApproveRepository = userToApproveRepository;
    }

    public void putUserToApproval(UserDTO userDTO) {
        UserToApprove userToApprove = UserToApprove.builder().idUser(userDTO.getId()).build();
        userToApproveRepository.save(userToApprove);
        log.info("Usuário {} salvo no mongo para posterior aprovação", userDTO);
    }

    public void approveUser(ApproveUserDTO approveUserDTO, Long idApprovalUser) {
        userProfileValidator.validateUserIsAuthorized(idApprovalUser);
        User user = userService.getUserOrThrowNotFoundException(approveUserDTO.getIdUser());

        UserProfile userProfile = UserProfile.builder()
                .profile(Profile.valueOf(approveUserDTO.getProfile().toUpperCase()))
                .user(user)
                .build();
        userProfile = userProfileRepository.save(userProfile);
        userService.activeUser(user, userProfile);
        userToApproveRepository.deleteByIdUser(user.getId());
        log.info("Usuário {} aprovado com sucesso", user);
    }

    public List<UserDTO> getAllUsersToApprove(Long idApprovalUser) {
        userProfileValidator.validateUserIsAuthorized(idApprovalUser);
        return userToApproveRepository
                .findAll()
                .stream()
                .filter(userToApprove -> !userToApprove.getIdUser().equals(idApprovalUser))
                .map(userToApprove -> userService.getUserById(userToApprove.getIdUser()))
                .filter(userDTO -> !userDTO.getProfile().equals(Profile.ADMINISTRATOR.name()))
                .collect(Collectors.toList());
    }
}
