package br.com.boaentrega.api;

import br.com.boaentrega.domain.dto.ApproveUserDTO;
import br.com.boaentrega.domain.dto.UserDTO;
import br.com.boaentrega.exception.UnauthorizedOperationException;
import br.com.boaentrega.service.UserProfileService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.isNull;

@Slf4j
@RestController
@RequestMapping("/user/approval")
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Operação realizada com Sucesso!"),
        @ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso."),
        @ApiResponse(code = 500, message = "Ocorreu um erro interno."),
})
public class UserApprovalAPI {

    private final UserProfileService userProfileService;

    public UserApprovalAPI(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @ApiOperation(value = "Retorna todos os Usuários pendentes de aprovação")
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<UserDTO>> getAllUsersToApprove(@RequestHeader("id-approval-user") Long idApprovalUser) {
        log.info("Recebida request para retornar todos os usuários pendentes de aprovação, com o idUserApproval: {}", idApprovalUser);
        validateIdApprovalUserInformed(idApprovalUser);
        return ResponseEntity.ok(userProfileService.getAllUsersToApprove(idApprovalUser));
    }

    private void validateIdApprovalUserInformed(Long idApprovalUser) {
        if (isNull(idApprovalUser)) {
            log.error("Não é possível fazer a operação sem informação o Usuário de Aprovação.");
            throw new UnauthorizedOperationException("É necessário informar o token id-approval-user");
        }
    }

    @ApiOperation(value = "Aprova um Usuário por Id.")
    @PutMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<Object> approvalUser(@RequestBody ApproveUserDTO approveUserDTO, @RequestHeader("id-approval-user") Long idApprovalUser) {
        log.info("Recebida request de aprovação para o usuário {} com o idUserApproval: {}", approveUserDTO, idApprovalUser);
        validateIdApprovalUserInformed(idApprovalUser);
        userProfileService.approveUser(approveUserDTO, idApprovalUser);
        log.info("Usuario {} aprovado com sucesso!", approveUserDTO);
        return ResponseEntity.noContent().build();
    }


}
