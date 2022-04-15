package br.com.boaentrega.service;

import br.com.boaentrega.domain.Merchandise;
import br.com.boaentrega.domain.dto.MerchandiseDTO;
import br.com.boaentrega.repository.IJpaRepository;
import br.com.boaentrega.translator.AbstractTranslator;
import br.com.boaentrega.translator.MerchandiseTranslator;
import br.com.boaentrega.validator.MerchandiseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MerchandiseService extends AbstractService<Merchandise, MerchandiseDTO>{
    public MerchandiseService(MerchandiseValidator abstractValidator, IJpaRepository<Merchandise> abstractRepository, MerchandiseTranslator abstractTranslator) {
        super(abstractValidator, abstractRepository, abstractTranslator);
    }

//    private final MerchandiseValidator merchandiseValidator;
//
//    private final MerchandiseRepository merchandiseRepository;
//
//    private final MerchandiseTranslator merchandiseTranslator;
//
//    private final RequestExecutorService requestExecutorService;
//
//    public MerchandiseService(MerchandiseValidator merchandiseValidator, MerchandiseRepository merchandiseRepository, MerchandiseTranslator merchandiseTranslator, RequestExecutorService requestExecutorService) {
//        this.merchandiseValidator = merchandiseValidator;
//        this.merchandiseRepository = merchandiseRepository;
//        this.merchandiseTranslator = merchandiseTranslator;
//        this.requestExecutorService = requestExecutorService;
//    }
//
//    public MerchandiseDTO createMerchandise(MerchandiseDTO merchandiseDTO) {
//        log.info("Creating merchandise: {} {}", merchandiseDTO.getCode(), merchandiseDTO.getName());
//        Merchandise merchandise = merchandiseTranslator.toEntity(merchandiseDTO);
//        merchandiseValidator.validateMerchandiseExists(merchandise);
//        return merchandiseTranslator.toDTO(merchandiseRepository.save(merchandise));
//    }
//
//    public MerchandiseDTO getMerchandiseById(Long idMerchandise) {
//        Merchandise merchandise = getMerchandiseOrThrowNotFoundException(idMerchandise);
//        return merchandiseTranslator.toDTO(merchandise);
//    }
//
//    public Merchandise getMerchandiseOrThrowNotFoundException(Long idMerchandise) {
//        Optional<Merchandise> merchandiseOp = merchandiseRepository.findById(idMerchandise);
//        return merchandiseOp.orElseThrow(() -> new MerchandiseNotFoundException(String.format("Merchandise for id %s not found", idMerchandise)));
//    }
//
//    public List<MerchandiseDTO> getAllMerchandises(Pageable paging) {
//        return merchandiseRepository.findAll(paging).stream().map(merchandiseTranslator::toDTO).collect(Collectors.toList());
//    }
//
//    public void updateMerchandise(MerchandiseDTO merchandiseDTO, Long idMerchandise) {
//        log.info("Updating merchandise: {}", merchandiseDTO.getCode());
//        Merchandise merchandise = getMerchandiseOrThrowNotFoundException(idMerchandise);
//        merchandiseTranslator.update(merchandise, merchandiseDTO);
//        merchandiseRepository.save(merchandise);
//    }
//
//    public void deleteMerchandise(Long idMerchandise) {
//        merchandiseRepository.deleteById(idMerchandise);
//    }
//
//    public void deleteAllMerchandises() {
//        merchandiseRepository.deleteAll();
//    }
//
//    public MerchandiseDTO getMerchandiseDeliveryStatus(Long idMerchandise) {
//        Merchandise merchandise = this.getMerchandiseOrThrowNotFoundException(idMerchandise);
//        String deliveryStatus = requestExecutorService.get(BoaEntregaGSLUrls.DELIVERY_STATUS, new HashMap<>(), new HashMap<>(), String.class).getBody();
//        MerchandiseDTO merchandiseDTO = merchandiseTranslator.toDTO(merchandise);
//        merchandiseDTO.setDeliverStatus(deliveryStatus);
//        return merchandiseDTO;
//    }
    public void deleteAllMerchandises() {
        merchandiseRepository.deleteAll();
    }

    public String getMerchandiseDeliveryStatus(Long idMerchandise) {
        this.getMerchandiseOrThrowNotFoundException(idMerchandise);
        return requestExecutorService.get(BoaEntregaGSLUrls.DELIVERY_STATUS, new HashMap<>(), new HashMap<>(), String.class).getBody();
    }
}
