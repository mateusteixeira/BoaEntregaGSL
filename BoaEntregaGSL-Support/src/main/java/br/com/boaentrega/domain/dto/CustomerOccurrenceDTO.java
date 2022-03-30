package br.com.boaentrega.domain.dto;


import br.com.boaentrega.domain.enumeration.OccurrenceStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerOccurrenceDTO implements Serializable {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("code")
    private Long code;

    @JsonProperty("userComment")
    private String userComment;

    @JsonProperty("supportComment")
    private String supportComment;

    @JsonProperty("status")
    private String occurrenceStatus;
}
