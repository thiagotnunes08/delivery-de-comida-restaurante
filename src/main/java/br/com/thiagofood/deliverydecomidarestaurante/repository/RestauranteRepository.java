package br.com.thiagofood.deliverydecomidarestaurante.repository;

import br.com.thiagofood.deliverydecomidarestaurante.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RestauranteRepository extends JpaRepository<Restaurante,Long> {
    boolean existsByEmail(Optional<String> email);

    boolean existsByEmailOrDocumento(String email, String documento);
}
