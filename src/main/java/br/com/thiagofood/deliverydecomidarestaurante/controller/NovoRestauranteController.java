package br.com.thiagofood.deliverydecomidarestaurante.controller;

import br.com.thiagofood.deliverydecomidarestaurante.controller.request.NovoRestauranteRequest;
import br.com.thiagofood.deliverydecomidarestaurante.model.Restaurante;
import br.com.thiagofood.deliverydecomidarestaurante.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("api/restaurantes")
public class NovoRestauranteController {

    @Autowired
    private final RestauranteRepository repository;

    public NovoRestauranteController(RestauranteRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<?> cadastra(@Valid @RequestBody NovoRestauranteRequest request, UriComponentsBuilder uriComponentsBuilder){

//        if (repository.existsByEmailOrDocumento(request.getEmail(),request.getDocumento())){
//            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,"Email,CPF ou CNPJ já cadastrado no sistema!");
//        }

        Restaurante novoRestaurante = request.toModel();

        repository.save(novoRestaurante);

        URI location = uriComponentsBuilder.path("/api/restaurantes/{id}").buildAndExpand(novoRestaurante.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
