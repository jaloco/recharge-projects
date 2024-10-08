package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.model.Sale;

/**
 * Repositorio para la entidad {@link Sale}.
 * Extiende {@link JpaRepository} para proporcionar métodos CRUD estándar.
 */
public interface SaleRepository extends JpaRepository<Sale, Long> {
    // No se necesitan métodos adicionales en este momento.
}
