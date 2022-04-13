package br.com.boaentrega.api;

import br.com.boaentrega.domain.dto.ApproveUserDTO;
import br.com.boaentrega.domain.dto.UserDTO;
import br.com.boaentrega.exception.UnauthorizedOperationException;
import br.com.boaentrega.service.UserProfileService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.isNull;

@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Operação realizada com Sucesso!"),
        @ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso."),
        @ApiResponse(code = 500, message = "Ocorreu um erro interno."),
})
@RestController
@RequestMapping("/user/approval")
public class UserApprovalAPI {

    private final UserProfileService userProfileService;

    public UserApprovalAPI(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @ApiOperation(value = "Retorna todos os Usuários pendentes de aprovação")
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<UserDTO>> getAllUsersToApprove(@RequestHeader("id-approval-user") Long idApprovalUser) {
        validateIdApprovalUserInformed(idApprovalUser);
        return ResponseEntity.ok(userProfileService.getAllUsersToApprove(idApprovalUser));
    }

    private void validateIdApprovalUserInformed(Long idApprovalUser) {
        if (isNull(idApprovalUser)) {
            throw new UnauthorizedOperationException("É necessário informar o token id-approval-user");
        }
    }

    @ApiOperation(value = "Aprova um Usuário por Id.")
    @PutMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<Object> approvalUser(@RequestBody ApproveUserDTO approveUserDTO, @RequestHeader("id-approval-user") Long idApprovalUser) {
        validateIdApprovalUserInformed(idApprovalUser);
        userProfileService.approveUser(approveUserDTO, idApprovalUser);
        return ResponseEntity.noContent().build();
    }


}
