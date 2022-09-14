package br.com.thiagofood.deliverydecomidarestaurante.controller;

import br.com.thiagofood.deliverydecomidarestaurante.controller.response.RestauranteResponse;
import br.com.thiagofood.deliverydecomidarestaurante.model.Restaurante;
import br.com.thiagofood.deliverydecomidarestaurante.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/api/restaurantes")
public class ConsultaRestauranteController {

    @Autowired
    private final RestauranteRepository repository;

    public ConsultaRestauranteController(RestauranteRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> consulta(@PathVariable Long id, @RequestParam(required = false) boolean listaPratos){

        Restaurante restaurante = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurante não encontrado!"));

        return ResponseEntity.ok(new RestauranteResponse(restaurante,listaPratos));


    }
}
