package br.com.boaentrega.service;

import br.com.boaentrega.domain.Merchandise;
import br.com.boaentrega.domain.dto.MerchandiseDTO;
import br.com.boaentrega.exception.MerchandiseNotFoundException;
import br.com.boaentrega.repository.MerchandiseRepository;
import br.com.boaentrega.translator.MerchandiseTranslator;
import br.com.boaentrega.validator.MerchandiseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class MerchandiseService {

    private final MerchandiseValidator merchandiseValidator;

    private final MerchandiseRepository merchandiseRepository;

    private final MerchandiseTranslator merchandiseTranslator;

    public MerchandiseService(MerchandiseValidator merchandiseValidator, MerchandiseRepository merchandiseRepository, MerchandiseTranslator merchandiseTranslator) {
        this.merchandiseValidator = merchandiseValidator;
        this.merchandiseRepository = merchandiseRepository;
        this.merchandiseTranslator = merchandiseTranslator;
    }

    public MerchandiseDTO createMerchandise(MerchandiseDTO merchandiseDTO) {
        log.info("Creating merchandise: {} {}", merchandiseDTO.getCode(), merchandiseDTO.getName());
        Merchandise merchandise = merchandiseTranslator.toEntity(merchandiseDTO);
        merchandiseValidator.validateMerchandiseExists(merchandise);
        return merchandiseTranslator.toDTO(merchandiseRepository.save(merchandise));
    }

    public MerchandiseDTO getMerchandiseById(Long idMerchandise) {
        Merchandise merchandise = getMerchandiseOrThrowNotFoundException(idMerchandise);
        return merchandiseTranslator.toDTO(merchandise);
    }

    public Merchandise getMerchandiseOrThrowNotFoundException(Long idMerchandise) {
        Optional<Merchandise> merchandiseOp = merchandiseRepository.findById(idMerchandise);
        return merchandiseOp.orElseThrow(() -> new MerchandiseNotFoundException(String.format("Merchandise for id %s not found", idMerchandise)));
    }

    public List<MerchandiseDTO> getAllMerchandises(Pageable paging) {
        return merchandiseRepository.findAll(paging).stream().map(merchandiseTranslator::toDTO).collect(Collectors.toList());
    }

    public void updateMerchandise(MerchandiseDTO merchandiseDTO, Long idMerchandise) {
        log.info("Updating merchandise: {}", merchandiseDTO.getCode());
        Merchandise merchandise = getMerchandiseOrThrowNotFoundException(idMerchandise);
        merchandise.setCode(merchandiseDTO.getCode());
        merchandise.setName(merchandiseDTO.getName());
        merchandise.setEan(merchandiseDTO.getEan());
        merchandiseRepository.save(merchandise);
    }

    public void deleteMerchandise(Long idMerchandise) {
        merchandiseRepository.deleteById(idMerchandise);
    }

    public void deleteAllMerchandises() {
        merchandiseRepository.deleteAll();
    }
}
