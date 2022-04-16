package br.com.boaentrega.domain.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import springfox.documentation.annotations.ApiIgnore;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO extends AbstractDTO {

    @JsonProperty("code")
    @ApiModelProperty(value = "Identificador do Usuário")
    private Long id;

    @JsonProperty("firstName")
    @ApiModelProperty(value = "Nome do Usuário")
    private String firstName;

    @JsonProperty("lastName")
    @ApiModelProperty(value = "Sobrenome do Usuário")
    private String lastName;

    @JsonProperty("login")
    @ApiModelProperty(value = "Login do Usuário")
    private String login;

    @JsonProperty("email")
    @ApiModelProperty(value = "Email do Usuário")
    private String email;

    @JsonProperty("active")
    @ApiModelProperty(value = "Status do Usuário")
    private boolean active = false;

    @JsonProperty("profile")
    @ApiModelProperty(value = "Perfil atribuído ao Usuário")
    private String profile;

    @Override
    @ApiIgnore
    @ApiModelProperty(hidden = true)
    public String getMainIdentifier() {
        return email;
    }

    @Override
    @ApiIgnore
    @ApiModelProperty(hidden = true)
    public String getSecondaryIdentifier() {
        return firstName;
    }

    @Override
    @ApiIgnore
    @ApiModelProperty(hidden = true)
    public Long getId() {
        return id;
    }
}
