package br.com.boaentrega.service;

import br.com.boaentrega.BoaEntregaGSLUrls;
import br.com.boaentrega.domain.Merchandise;
import br.com.boaentrega.domain.dto.MerchandiseDTO;
import br.com.boaentrega.repository.IJpaRepository;
import br.com.boaentrega.translator.AbstractTranslator;
import br.com.boaentrega.validator.AbstractValidator;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class MerchandiseService extends AbstractService<Merchandise, Long, MerchandiseDTO> {

    private final RequestExecutorService requestExecutorService;

    public MerchandiseService(AbstractValidator<Merchandise, Long> abstractValidator, IJpaRepository<Merchandise, Long> abstractRepository, AbstractTranslator<Merchandise, Long, MerchandiseDTO> abstractTranslator, RequestExecutorService requestExecutorService) {
        super(abstractValidator, abstractRepository, abstractTranslator);
        this.requestExecutorService = requestExecutorService;
    }

    public String getMerchandiseDeliveryStatus(Long idMerchandise) {
        super.getAbstractOrThrowNotFoundException(idMerchandise);
        return requestExecutorService.get(BoaEntregaGSLUrls.DELIVERY_STATUS, new HashMap<>(), new HashMap<>(), String.class).getBody();
    }
}
