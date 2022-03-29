package br.com.boaentrega.domain.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WareHouseDTO implements Serializable {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("code")
    private Long code;

    @JsonProperty("name")
    private String name;

    @JsonProperty("capacity")
    private Long capacity;

    @JsonProperty("location")
    private String location;
}
