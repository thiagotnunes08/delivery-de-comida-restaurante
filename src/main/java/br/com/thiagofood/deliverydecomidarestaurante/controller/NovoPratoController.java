package br.com.thiagofood.deliverydecomidarestaurante.controller;

import br.com.thiagofood.deliverydecomidarestaurante.controller.request.NovoPratoRequest;
import br.com.thiagofood.deliverydecomidarestaurante.model.Restaurante;
import br.com.thiagofood.deliverydecomidarestaurante.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

@RestController
@RequestMapping("api/restaurantes/")
public class NovoPratoController {

    @Autowired
    private final RestauranteRepository repository;

    public NovoPratoController(RestauranteRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @PostMapping("{restauranteId}/pratos")
    public ResponseEntity<?> cadastra(@PathVariable Long restauranteId, @RequestBody NovoPratoRequest request){

        Restaurante restaurante = repository.findById(restauranteId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurante não encontrado!"));

        restaurante.adiciona(request);

        return ResponseEntity.status(201).build();


    }
}
