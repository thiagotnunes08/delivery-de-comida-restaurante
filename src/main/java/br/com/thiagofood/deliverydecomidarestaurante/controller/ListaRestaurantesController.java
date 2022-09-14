package br.com.thiagofood.deliverydecomidarestaurante.controller;

import br.com.thiagofood.deliverydecomidarestaurante.controller.response.DetalheRestauranteResponse;
import br.com.thiagofood.deliverydecomidarestaurante.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/restaurantes")



public class ListaRestaurantesController {

    @Autowired
    private final RestauranteRepository repository;

    public ListaRestaurantesController(RestauranteRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<?> lista(){

        List<DetalheRestauranteResponse> restaurante = repository.findAll().stream().map(DetalheRestauranteResponse::new).toList();

        return ResponseEntity.ok(restaurante);

    }
}
