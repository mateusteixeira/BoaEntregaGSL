package br.com.boaentrega.service;

import br.com.boaentrega.domain.User;
import br.com.boaentrega.domain.UserProfile;
import br.com.boaentrega.domain.document.UserToApprove;
import br.com.boaentrega.domain.dto.ApproveUserDTO;
import br.com.boaentrega.domain.dto.UserDTO;
import br.com.boaentrega.domain.enumeration.Profile;
import br.com.boaentrega.repository.UserProfileRepository;
import br.com.boaentrega.repository.UserToApproveRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserProfileService {

    public final UserService userService;

    public final UserProfileRepository userProfileRepository;

    public final UserToApproveRepository userToApproveRepository;

    public UserProfileService(@Lazy UserService userService, UserProfileRepository userProfileRepository, UserToApproveRepository userToApproveRepository) {
        this.userService = userService;
        this.userProfileRepository = userProfileRepository;
        this.userToApproveRepository = userToApproveRepository;
    }

    public void putUserToApproval(User user) {
        UserToApprove userToApprove = UserToApprove.builder().idUser(user.getId()).build();
        userToApproveRepository.save(userToApprove);
    }

    public void approveUser(ApproveUserDTO approveUserDTO) {
        //TODO ver como vai pegar o user logado e validar
        User user = userService.getUserOrThrowNotFoundException(approveUserDTO.getIdUser());

        UserProfile userProfile = UserProfile.builder()
                .profile(Profile.valueOf(approveUserDTO.getProfile().toUpperCase()))
                .user(user)
                .build();
        userProfile = userProfileRepository.save(userProfile);
        userService.activeUser(user, userProfile);
        userToApproveRepository.deleteByIdUser(user.getId());
    }

    public List<UserDTO> getAllUsersToApprove() {
        return userToApproveRepository
                .findAll()
                .stream()
                .map(userToApprove -> userService.getUserById(userToApprove.getIdUser()))
                .collect(Collectors.toList());
    }
}
