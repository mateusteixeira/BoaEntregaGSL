package br.com.boaentrega.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public abstract class AbstractDTO implements IDTO {
    public abstract Long getId();
}
