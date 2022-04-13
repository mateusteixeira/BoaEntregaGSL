package br.com.boaentregasupport.domain.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerOccurrenceDTO implements Serializable {

    @JsonProperty("id")
    @ApiModelProperty(value = "Identificador de Ocorrência do Usuário")
    private Long id;

    @JsonProperty("code")
    @ApiModelProperty(value = "Código da Ocorrência do Usuário", required = true)
    private Long code;

    @JsonProperty("userComment")
    @ApiModelProperty(value = "Comentário do Usuário", required = true)
    private String userComment;

    @JsonProperty("supportComment")
    @ApiModelProperty(value = "Comentário do Suporte")
    private String supportComment;

    @JsonProperty("status")
    @ApiModelProperty(value = "Status da Ocorrência")
    private String occurrenceStatus;
}
