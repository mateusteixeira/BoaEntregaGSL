package br.com.boaentrega.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApproveUserDTO {

    @NonNull
    @JsonProperty("idUser")
    @ApiModelProperty(value = "Identificador do Usuário")
    private Long idUser;

    @NonNull
    @JsonProperty("profile")
    @ApiModelProperty(value = "Perfil atribuído ao Usuário")
    private String profile;

}
