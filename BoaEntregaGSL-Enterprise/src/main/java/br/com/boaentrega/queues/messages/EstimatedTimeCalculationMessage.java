package br.com.boaentrega.queues.messages;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class EstimatedTimeCalculationMessage extends AsyncOperationMessage {
    private Long id;
    private String cityFrom;
    private String cityTo;
}
