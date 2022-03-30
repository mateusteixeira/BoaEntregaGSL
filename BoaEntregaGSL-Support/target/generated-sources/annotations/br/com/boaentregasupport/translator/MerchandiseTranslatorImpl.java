package br.com.boaentregasupport.translator;

import br.com.boaentrega.domain.Merchandise;
import br.com.boaentrega.domain.dto.MerchandiseDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-28T23:20:24-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class MerchandiseTranslatorImpl implements MerchandiseTranslator {

    @Override
    public MerchandiseDTO toDTO(Merchandise merchandise) {
        if ( merchandise == null ) {
            return null;
        }

        MerchandiseDTO merchandiseDTO = new MerchandiseDTO();

        return merchandiseDTO;
    }

    @Override
    public Merchandise toEntity(MerchandiseDTO merchandiseDTO) {
        if ( merchandiseDTO == null ) {
            return null;
        }

        Merchandise merchandise = new Merchandise();

        return merchandise;
    }

    @Override
    public void update(Merchandise merchandise, MerchandiseDTO merchandiseDTO) {
        if ( merchandiseDTO == null ) {
            return;
        }
    }
}
