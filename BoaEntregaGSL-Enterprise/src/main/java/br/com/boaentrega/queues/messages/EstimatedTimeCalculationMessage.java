package br.com.boaentrega.queues.messages;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EstimatedTimeCalculationMessage extends AsyncOperationMessage {
    private Long id;
    private String cityFrom;
    private String cityTo;
}
