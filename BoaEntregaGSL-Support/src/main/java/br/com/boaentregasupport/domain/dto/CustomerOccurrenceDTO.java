package br.com.boaentregasupport.domain.dto;


import br.com.boaentrega.domain.dto.AbstractDTO;
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
public class CustomerOccurrenceDTO extends AbstractDTO {

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

    @Override
    @ApiIgnore
    @ApiModelProperty(hidden = true)
    public String getMainIdentifier() {
        return String.valueOf(id);
    }

    @Override
    @ApiIgnore
    @ApiModelProperty(hidden = true)
    public String getSecondaryIdentifier() {
        return String.valueOf(code);
    }
}
