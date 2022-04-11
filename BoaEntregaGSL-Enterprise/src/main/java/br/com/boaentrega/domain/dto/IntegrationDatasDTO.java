package br.com.boaentrega.domain.dto;

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
public class IntegrationDatasDTO implements Serializable {

    @JsonProperty("data")
    @ApiModelProperty(value = "Dados provenientes do SGE")
    private List<IntegrationDataDTO> integrationDataDTOS;
}
