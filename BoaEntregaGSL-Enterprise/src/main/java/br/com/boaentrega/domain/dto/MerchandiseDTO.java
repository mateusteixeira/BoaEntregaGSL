package br.com.boaentrega.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MerchandiseDTO {

    @JsonProperty("id")
    @ApiModelProperty(value = "Identificador da Mercadoria")
    private Long id;

    @JsonProperty("code")
    @ApiModelProperty(value = "Código da Mercadoria", required = true)
    private Long code;

    @JsonProperty("name")
    @ApiModelProperty(value = "Nome da Mercadoria", required = true)
    private String name;

    @JsonProperty("ean")
    @ApiModelProperty(value = "EAN da Mercadoria", required = true)
    private String ean;
}
