package br.com.boaentrega.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RouteDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("code")
    private Long code;

    @JsonProperty("cityFrom")
    private String cityFrom;

    @JsonProperty("cityTo")
    private String cityTo;

    @JsonProperty("durationInDays")
    private Long durationInDays;

}
