package br.com.boaentrega.translator;

import br.com.boaentrega.domain.Merchandise;
import br.com.boaentrega.domain.dto.MerchandiseDTO;
import br.com.boaentrega.translator.mapper.MerchandiserTranslatorMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingInheritanceStrategy;
import org.springframework.stereotype.Service;


@Mapper(mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_ALL_FROM_CONFIG)
public interface MerchandiseTranslator extends AbstractTranslator<Merchandise, Long, MerchandiseDTO> {

//    private final MerchandiserTranslatorMapper merchandiserTranslatorMapper;
//
//    public MerchandiseTranslator(MerchandiserTranslatorMapper merchandiserTranslatorMapper) {
//        this.merchandiserTranslatorMapper = merchandiserTranslatorMapper;
//    }
//
//    @Override
//    public MerchandiseDTO toDTO(Merchandise merchandise) {
//        return merchandiserTranslatorMapper.toDTO(merchandise);
//    }
//
//    @Override
//    public Merchandise toEntity(MerchandiseDTO merchandiseDTO) {
//        return merchandiserTranslatorMapper.toEntity(merchandiseDTO);
//    }
//
//    @Override
//    public void update(Merchandise merchandise, MerchandiseDTO merchandiseDTO) {
//        merchandiserTranslatorMapper.update(merchandise, merchandiseDTO);
//    }

//    @Override
//    public MerchandiseDTO toDTO(Merchandise merchandise) {
//        return MerchandiseDTO.builder()
//                .code(merchandise.getCode())
//                .id(merchandise.getId())
//                .ean(merchandise.getEan())
//                .name(merchandise.getName())
//                .build();
//    }
//
//    @Override
//    public Merchandise toEntity(MerchandiseDTO merchandiseDTO) {
//        Merchandise merchandise = Merchandise.builder()
//                .code(merchandiseDTO.getCode())
//                .ean(merchandiseDTO.getEan())
//                .name(merchandiseDTO.getName())
//                .build();
//        merchandise.setId(merchandiseDTO.getId());
//        return merchandise;
//    }
//
//    @Override
//    public void update(Merchandise merchandise, MerchandiseDTO merchandiseDTO) {
//        merchandise.setCode(merchandiseDTO.getCode());
//        merchandise.setEan(merchandiseDTO.getEan());
//        merchandise.setName(merchandiseDTO.getName());
//    }
}
