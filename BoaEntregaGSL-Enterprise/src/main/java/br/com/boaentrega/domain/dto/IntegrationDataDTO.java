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
public class IntegrationDataDTO implements Serializable {

    @JsonProperty("data")
    @ApiModelProperty(value = "Dado proveniente do SGE")
    private String someData;
}
