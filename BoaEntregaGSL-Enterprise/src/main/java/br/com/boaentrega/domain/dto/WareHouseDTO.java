package br.com.boaentrega.domain.dto;


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
public class WareHouseDTO extends AbstractDTO {

    @JsonProperty("id")
    @ApiModelProperty(value = "Identificador do Depósito")
    private Long id;

    @JsonProperty("code")
    @ApiModelProperty(value = "Código do Depósito")
    private Long code;

    @JsonProperty("name")
    @ApiModelProperty(value = "Nome do Depósito")
    private String name;

    @JsonProperty("capacity")
    @ApiModelProperty(value = "Capacidade do Depósito")
    private Long capacity;

    @JsonProperty("location")
    @ApiModelProperty(value = "Localização do Depósito")
    private String location;

    @Override
    public String getMainIdentifier() {
        return null;
    }

    @Override
    public String getSecondaryIdentifier() {
        return null;
    }
}
