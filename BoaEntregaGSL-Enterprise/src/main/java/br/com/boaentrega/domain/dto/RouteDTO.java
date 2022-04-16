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
public class RouteDTO extends AbstractDTO {

    @JsonProperty("id")
    @ApiModelProperty(value = "Identificador da Rota")
    private Long id;

    @JsonProperty("name")
    @ApiModelProperty(value = "Nome da Rota")
    private String name;

    @JsonProperty("code")
    @ApiModelProperty(value = "Código da Rota")
    private Long code;

    @JsonProperty("cityFrom")
    @ApiModelProperty(value = "Cidade Origem da Rota")
    private String cityFrom;

    @JsonProperty("cityTo")
    @ApiModelProperty(value = "Cidage Destido da Rota")
    private String cityTo;

    @JsonProperty("durationInDays")
    @ApiModelProperty(value = "Duração de entrega da Rota")
    private Long durationInDays;

    @Override
    @ApiIgnore
    @ApiModelProperty(hidden = true)
    public String getMainIdentifier() {
        return cityFrom;
    }

    @Override
    @ApiIgnore
    @ApiModelProperty(hidden = true)
    public String getSecondaryIdentifier() {
        return cityTo;
    }

    @Override
    @ApiIgnore
    @ApiModelProperty(hidden = true)
    public Long getId() {
        return id;
    }
}
