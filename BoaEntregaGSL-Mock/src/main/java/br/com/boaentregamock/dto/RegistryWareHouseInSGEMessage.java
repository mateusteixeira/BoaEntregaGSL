package br.com.boaentregamock.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistryWareHouseInSGEMessage {

    @JsonProperty("code")
    private Long code;

    @JsonProperty("name")
    private String name;

    @JsonProperty("capacity")
    private Long capacity;

    @JsonProperty("location")
    private String location;
}
