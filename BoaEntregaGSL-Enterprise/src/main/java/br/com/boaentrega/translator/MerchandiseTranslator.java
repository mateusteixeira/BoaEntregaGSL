package br.com.boaentrega.translator;

import br.com.boaentrega.domain.AbstractEntity;
import br.com.boaentrega.domain.Merchandise;
import br.com.boaentrega.domain.dto.AbstractDTO;
import br.com.boaentrega.domain.dto.MerchandiseDTO;
import org.springframework.stereotype.Service;


@Service
public class MerchandiseTranslator extends AbstractTranslator<Merchandise, MerchandiseDTO> {


    @Override
    public MerchandiseDTO toDTO(Merchandise merchandise) {
        return MerchandiseDTO.builder()
                .code(merchandise.getCode())
                .id(merchandise.getId())
                .ean(merchandise.getEan())
                .name(merchandise.getName())
                .build();
    }

    @Override
    public Merchandise toEntity(MerchandiseDTO merchandiseDTO) {
        Merchandise merchandise = Merchandise.builder()
                .code(merchandiseDTO.getCode())
                .ean(merchandiseDTO.getEan())
                .name(merchandiseDTO.getName())
                .build();
        merchandise.setId(merchandiseDTO.getId());
        return merchandise;
    }

    @Override
    public void update(Merchandise merchandise, MerchandiseDTO merchandiseDTO) {
        merchandise.setCode(merchandiseDTO.getCode());
        merchandise.setEan(merchandiseDTO.getEan());
        merchandise.setName(merchandiseDTO.getName());
    }
}
