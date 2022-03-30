package br.com.boaentregadata.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    private String type;

    @JsonProperty("methods")
    private List<MethodDTO> methodDTOS;
}
