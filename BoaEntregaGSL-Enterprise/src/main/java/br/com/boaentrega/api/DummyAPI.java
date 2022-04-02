package br.com.boaentrega.api;

import br.com.boaentrega.domain.dto.MerchandiseDTO;
import br.com.boaentrega.service.MerchandiseService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/dummy")
public class DummyAPI {

    @GetMapping
    public String get() {
        return "VAMO VELHO";
    }
}
