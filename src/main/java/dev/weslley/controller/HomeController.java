package dev.weslley.controller;

import dev.weslley.feign.EstadosCidadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    EstadosCidadesService estadosCidadesService;

    @GetMapping("estados")
    Record getEstados(){
        return estadosCidadesService.getEstados();
    }
}
