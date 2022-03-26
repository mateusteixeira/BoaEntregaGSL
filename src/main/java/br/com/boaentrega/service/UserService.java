package br.com.boaentrega.service;

import br.com.boaentrega.domain.User;
import br.com.boaentrega.domain.UserProfile;
import br.com.boaentrega.domain.dto.UserDTO;
import br.com.boaentrega.exception.UserNotFoundException;
import br.com.boaentrega.repository.UserRepository;
import br.com.boaentrega.translator.UserTranslator;
import br.com.boaentrega.validator.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserService {

    private final UserValidator userValidator;

    private final UserRepository userRepository;

    private final UserTranslator userTranslator;

    private final UserProfileService userProfileService;

    public UserService(UserValidator userValidator, UserRepository userRepository, UserTranslator userTranslator, UserProfileService userProfileService) {
        this.userValidator = userValidator;
        this.userRepository = userRepository;
        this.userTranslator = userTranslator;
        this.userProfileService = userProfileService;
    }

    public UserDTO createUser(UserDTO userDTO) {
        log.info("Creating user: {} {}", userDTO.getFirstName(), userDTO.getLastName());
        User user = userTranslator.toEntity(userDTO);
        userValidator.validateUserExists(user);
        userProfileService.putUserToApproval(user);
        return userTranslator.toDTO(userRepository.save(user));
    }

    public UserDTO getUserById(Long idUser) {
        User user = getUserOrThrowNotFoundException(idUser);
        return userTranslator.toDTO(user);
    }

    public User getUserOrThrowNotFoundException(Long idUser) {
        Optional<User> userOp = userRepository.findById(idUser);
        return userOp.orElseThrow(() -> new UserNotFoundException(String.format("User for id %s not found", idUser)));
    }

    public List<UserDTO> getAllUsers(Pageable paging) {
        return userRepository.findAll(paging).stream().map(userTranslator::toDTO).collect(Collectors.toList());
    }

    public void updateUser(UserDTO userDTO, Long idUser) {
        log.info("Updating user: {}", userDTO.getLogin());
        User user = getUserOrThrowNotFoundException(idUser);
        user.setLogin(userDTO.getLogin());
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        userRepository.save(user);
    }

    public void deleteUser(Long idUser) {
        userRepository.deleteById(idUser);
    }

    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    public void activeUser(User user, UserProfile userProfile) {
        user.setUserProfile(userProfile);
        user.setActive(true);
        userRepository.save(user);
    }
}
