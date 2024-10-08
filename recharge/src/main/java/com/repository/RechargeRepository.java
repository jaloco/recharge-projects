package com.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.model.Recharge;

/**
 * Repositorio para la entidad {@link Recharge}.
 * Extiende {@link JpaRepository} para proporcionar métodos CRUD estándar.
 */
public interface RechargeRepository extends JpaRepository<Recharge, Long> {

    /**
     * Encuentra todas las recargas por el operador dado.
     *
     * @param operador el nombre del operador.
     * @return una lista de recargas que corresponden al operador especificado.
     */
    List<Recharge> findByOperador(String operador);
}
