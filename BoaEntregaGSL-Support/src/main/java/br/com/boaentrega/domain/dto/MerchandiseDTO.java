package br.com.boaentrega.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    private Long id;

    @JsonProperty("code")
    private Long code;

    @JsonProperty("name")
    private String name;

    @JsonProperty("ean")
    private String ean;

}
