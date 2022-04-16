package br.com.boaentrega.service;

import br.com.boaentrega.domain.Merchandise;
import br.com.boaentrega.domain.dto.MerchandiseDTO;
import br.com.boaentrega.repository.IJpaRepository;
import br.com.boaentrega.translator.AbstractTranslator;
import br.com.boaentrega.translator.MerchandiseTranslator;
import br.com.boaentrega.validator.AbstractValidator;
import br.com.boaentrega.validator.MerchandiseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
public class MerchandiseService extends AbstractService<Merchandise, Long, MerchandiseDTO>{

    public MerchandiseService(AbstractValidator<Merchandise, Long> abstractValidator, IJpaRepository<Merchandise, Long> abstractRepository, AbstractTranslator<Merchandise, Long, MerchandiseDTO> abstractTranslator) {
        super(abstractValidator, abstractRepository, abstractTranslator);
    }

}
