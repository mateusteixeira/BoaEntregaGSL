package br.com.boaentrega.queues.messages;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class RegistryWareHouseInSGEMessage extends AsyncOperationMessage {

    @JsonProperty("code")
    private Long code;

    @JsonProperty("name")
    private String name;

    @JsonProperty("capacity")
    private Long capacity;

    @JsonProperty("location")
    private String location;
}
