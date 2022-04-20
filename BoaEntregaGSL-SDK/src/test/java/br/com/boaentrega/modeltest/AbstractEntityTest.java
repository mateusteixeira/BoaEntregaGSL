package br.com.boaentrega.modeltest;

import br.com.boaentrega.domain.AbstractEntity;
import lombok.Builder;

@Builder
public class AbstractEntityTest extends AbstractEntity<Long> {

    private Long id;

    @Override
    public String getMainIdentifier() {
        return String.valueOf(id);
    }

    @Override
    public String getSecondaryIdentifier() {
        return String.valueOf(id);
    }
}
