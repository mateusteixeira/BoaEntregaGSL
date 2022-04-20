package br.com.boaentrega.modeltest;

import br.com.boaentrega.domain.dto.AbstractDTO;
import lombok.Builder;

@Builder
public class AbstractDTOTest extends AbstractDTO {

    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getMainIdentifier() {
        return String.valueOf(id);
    }

    @Override
    public String getSecondaryIdentifier() {
        return String.valueOf(id);
    }
}