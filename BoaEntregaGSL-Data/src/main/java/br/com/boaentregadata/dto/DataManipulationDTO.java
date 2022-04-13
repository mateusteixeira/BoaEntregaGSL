package br.com.boaentregadata.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataManipulationDTO implements Serializable {

    @JsonProperty("type")
    @ApiModelProperty(value = "Tipo de Manipulação")
    private String type;

    @JsonProperty("methods")
    @ApiModelProperty(value = "Métodos Disponíveis")
    private List<MethodDTO> methodDTOS;
}
