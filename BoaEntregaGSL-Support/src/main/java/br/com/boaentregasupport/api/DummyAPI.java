package br.com.boaentregasupport.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dummy")
public class DummyAPI {

    @GetMapping
    public String get() {
        return "VAMO VELHO SUPPORT";
    }
}
