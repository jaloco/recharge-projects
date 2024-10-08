package com.service;

import java.util.List;

import com.model.Recharge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.repository.RechargeRepository;

/**
 * Servicio para la gestión de recargas.
 * Proporciona métodos para realizar operaciones CRUD sobre la entidad {@link Recharge}.
 */
@Service
public class RechargeService {

    @Autowired
    private RechargeRepository rechargeRepository;

    /**
     * Obtiene todas las recargas.
     *
     * @return una lista de todas las recargas.
     */
    public List<?> findAll() {
        return rechargeRepository.findAll();
    }

    /**
     * Busca una recarga por su ID.
     *
     * @param id el ID de la recarga a buscar.
     * @return la recarga correspondiente al ID dado.
     * @throws IllegalArgumentException si no se encuentra la recarga.
     */
    public Recharge findById(Long id) {
        return rechargeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Recarga no encontrada"));
    }

    /**
     * Guarda una nueva recarga.
     *
     * @param recharge la recarga a guardar.
     * @return la recarga guardada.
     */
    public Recharge save(Recharge recharge) {
        return rechargeRepository.save(recharge);
    }
}
