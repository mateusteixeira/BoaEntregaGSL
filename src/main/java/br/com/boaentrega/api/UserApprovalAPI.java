package br.com.boaentrega.api;

import br.com.boaentrega.domain.dto.ApproveUserDTO;
import br.com.boaentrega.domain.dto.UserDTO;
import br.com.boaentrega.service.UserProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/approval")
public class UserApprovalAPI {

    private final UserProfileService userProfileService;

    public UserApprovalAPI(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsersToApprove() {
        return ResponseEntity.ok(userProfileService.getAllUsersToApprove());
    }

    @PutMapping
    public ResponseEntity<Object> approvalUser(@RequestBody ApproveUserDTO approveUserDTO) {
        userProfileService.approveUser(approveUserDTO);
        return ResponseEntity.noContent().build();
    }


}
