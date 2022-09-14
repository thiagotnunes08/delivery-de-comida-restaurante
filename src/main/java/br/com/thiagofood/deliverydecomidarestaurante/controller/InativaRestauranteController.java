package br.com.thiagofood.deliverydecomidarestaurante.controller;

import br.com.thiagofood.deliverydecomidarestaurante.model.Restaurante;
import br.com.thiagofood.deliverydecomidarestaurante.repository.RestauranteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

@RestController
@RequestMapping("api/restaurantes/ativos")
public class InativaRestauranteController {

    private final RestauranteRepository repository;

    public InativaRestauranteController(RestauranteRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @PatchMapping("/{id}")
    public ResponseEntity<?> invativa(@PathVariable Long id){

        Restaurante restaurante = repository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Restaurante não encontrado!"));

        restaurante.inativa();

        return ResponseEntity.noContent().build();
    }
}
