package br.com.boaentrega.queues.messages;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
public class AsyncOperationMessage implements Serializable {

    private Long id;
    private String cityFrom;
    private String cityTo;

}
