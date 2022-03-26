package br.com.boaentrega.service;

import br.com.boaentrega.domain.User;
import br.com.boaentrega.domain.document.UserToApprove;
import br.com.boaentrega.repository.UserToApproveRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserProfileService {

    public final UserToApproveRepository userToApproveRepository;

    public UserProfileService(UserToApproveRepository userToApproveRepository) {
        this.userToApproveRepository = userToApproveRepository;
    }

    public void putUserToApproval(User user) {
        UserToApprove.builder().idUser(user.getId()).build();
    }
}
