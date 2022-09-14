package br.com.thiagofood.deliverydecomidarestaurante.controller;

import br.com.thiagofood.deliverydecomidarestaurante.controller.request.AtualizaRestauranteRequest;
import br.com.thiagofood.deliverydecomidarestaurante.model.Restaurante;
import br.com.thiagofood.deliverydecomidarestaurante.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/restaurantes")
public class AtualizaRestauranteController {

    @Autowired
    private final RestauranteRepository repository;

    public AtualizaRestauranteController(RestauranteRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @PatchMapping("/{id}")
    public ResponseEntity<?> atualiza(@PathVariable Long id,@RequestBody @Valid AtualizaRestauranteRequest request){

        request.getEmail().ifPresent(possivelEmail-> {
            if (repository.existsByEmail(request.getEmail())){
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,"Email já existente na base de dados!");
            }
        });

        Restaurante restaurante = repository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Restaurante não encontrado!"));

        restaurante.atualiza(request);

        return ResponseEntity.noContent().build();
    }
}
