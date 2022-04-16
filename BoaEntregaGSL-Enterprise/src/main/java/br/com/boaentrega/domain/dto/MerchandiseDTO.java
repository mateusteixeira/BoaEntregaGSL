package br.com.boaentrega.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.*;
import springfox.documentation.annotations.ApiIgnore;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MerchandiseDTO extends AbstractDTO {

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

    @JsonProperty("delivery_status")
    @ApiModelProperty(value = "Status de Entrega")
    private String deliverStatus;

    @Override
    @ApiIgnore
    @ApiModelProperty(hidden = true)
    public String getMainIdentifier() {
        return String.valueOf(getCode());
    }

    @Override
    @ApiIgnore
    @ApiModelProperty(hidden = true)
    public String getSecondaryIdentifier() {
        return getName();
    }

    @Override
    @ApiIgnore
    @ApiModelProperty(hidden = true)
    public Long getId() {
        return id;
    }
}
