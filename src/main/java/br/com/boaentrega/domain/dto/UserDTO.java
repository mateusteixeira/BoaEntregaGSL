package br.com.boaentrega.domain.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {

    @JsonProperty("code")
    private Long id;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("login")
    private String login;

    @JsonProperty("email")
    private String email;

    @JsonProperty("active")
    private boolean active = false;

    @JsonProperty("profile")
    private String profile;
}
