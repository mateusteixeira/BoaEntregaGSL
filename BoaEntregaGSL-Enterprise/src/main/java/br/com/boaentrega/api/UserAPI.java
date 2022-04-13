package br.com.boaentrega.api;


import br.com.boaentrega.domain.dto.UserDTO;
import br.com.boaentrega.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Operação realizada com Sucesso!"),
        @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso."),
        @ApiResponse(code = 500, message = "Ocorreu um erro interno."),
})
@RestController
@RequestMapping("/user")
public class UserAPI {

    private final UserService userService;

    public UserAPI(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Cria um Usuário")
    @PostMapping(produces="application/json", consumes="application/json")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO savedUserDTO = this.userService.createUser(userDTO);
        URI location = getUriToHeader(savedUserDTO);
        return ResponseEntity.created(location).body(savedUserDTO);
    }

    @ApiOperation(value = "Retorna todos os Usuários")
    @GetMapping(produces="application/json")
    public ResponseEntity<List<UserDTO>> getUsers(Pageable pageable) {
        return ResponseEntity.ok(userService.getAllUsers(pageable));
    }

    @ApiOperation(value = "Retorna um Usuário por Id.")
    @GetMapping(value = "{id}", produces="application/json")
    public ResponseEntity<UserDTO> getUser(@PathVariable(name = "id") Long idUser) {
        return ResponseEntity.ok(userService.getUserById(idUser));
    }

    @ApiOperation(value = "Atualiza um Usuário por Id.")
    @PutMapping(value = "{id}", produces="application/text", consumes="application/json")
    public ResponseEntity<Object> updateUser(@RequestBody UserDTO userDTO, @PathVariable(name = "id") Long idUser) {
        userService.updateUser(userDTO, idUser);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Deleta um Usuário por Id.")
    @DeleteMapping(value = "{id}", produces="application/text")
    public ResponseEntity<Object> deleteUser(@PathVariable(name = "id") Long idUser) {
        userService.deleteUser(idUser);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Deleta todos os Usuários.")
    @DeleteMapping(produces="application/text")
    public ResponseEntity<Object> deleteAllUsers() {
        userService.deleteAllUsers();
        return ResponseEntity.ok().build();
    }

    private URI getUriToHeader(UserDTO userDTO) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userDTO.getId())
                .toUri();
    }

}
