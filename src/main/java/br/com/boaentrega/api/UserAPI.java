package br.com.boaentrega.api;


import br.com.boaentrega.domain.dto.UserDTO;
import br.com.boaentrega.service.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserAPI {

    private final UserService userService;

    public UserAPI(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO savedUserDTO = this.userService.createUser(userDTO);
        URI location = getUriToHeader(savedUserDTO);
        return ResponseEntity.created(location).body(savedUserDTO);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers(Pageable pageable) {
        return ResponseEntity.ok(userService.getAllUsers(pageable));
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable(name = "id") Long idUser) {
        return ResponseEntity.ok(userService.getUserById(idUser));
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> updateUser(@RequestBody UserDTO userDTO, @PathVariable(name = "id") Long idUser) {
        userService.updateUser(userDTO, idUser);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable(name = "id") Long idUser) {
        userService.deleteUser(idUser);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
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
