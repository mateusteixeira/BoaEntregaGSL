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
    @ApiModelProperty(value = "Código da Mercadoria")
    private Long code;

    @JsonProperty("name")
    @ApiModelProperty(value = "Nome da Mercadoria")
    private String name;

    @JsonProperty("ean")
    @ApiModelProperty(value = "EAN da Mercadoria")
    private String ean;

    @JsonProperty("delivery_status")
    private String deliverStatus;

}
