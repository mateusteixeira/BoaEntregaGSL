package br.com.boaentrega.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApproveUserDTO {

    @NonNull
    @JsonProperty("idUser")
    private Long idUser;

    @NonNull
    @JsonProperty("profile")
    private String profile;

}
