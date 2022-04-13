package br.com.boaentregadata.dto;

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
public class MethodDTO implements Serializable {

    @JsonProperty("name")
    @ApiModelProperty(value = "Método")
    private String name;

}
