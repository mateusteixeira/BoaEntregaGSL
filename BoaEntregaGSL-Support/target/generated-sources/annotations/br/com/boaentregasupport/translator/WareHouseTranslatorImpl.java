package br.com.boaentregasupport.translator;

import br.com.boaentrega.domain.WareHouse;
import br.com.boaentrega.domain.dto.WareHouseDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-28T23:20:24-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class WareHouseTranslatorImpl implements WareHouseTranslator {

    @Override
    public WareHouseDTO toDTO(WareHouse wareHouse) {
        if ( wareHouse == null ) {
            return null;
        }

        WareHouseDTO wareHouseDTO = new WareHouseDTO();

        return wareHouseDTO;
    }

    @Override
    public WareHouse toEntity(WareHouseDTO wareHouseDTO) {
        if ( wareHouseDTO == null ) {
            return null;
        }

        WareHouse wareHouse = new WareHouse();

        return wareHouse;
    }

    @Override
    public void update(WareHouse wareHouse, WareHouseDTO wareHouseDTO) {
        if ( wareHouseDTO == null ) {
            return;
        }
    }
}
