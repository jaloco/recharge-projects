package com.service;

import java.util.List;

import com.model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.repository.SaleRepository;

/**
 * Servicio para la gestión de ventas.
 * Proporciona métodos para realizar operaciones CRUD sobre la entidad {@link Sale}.
 */
@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    /**
     * Obtiene todas las ventas.
     *
     * @return una lista de todas las ventas.
     */
    public List<Sale> findAll() {
        return saleRepository.findAll();
    }

    /**
     * Guarda una nueva venta.
     *
     * @param sale la venta a guardar.
     * @return la venta guardada.
     */
    public Sale save(Sale sale) {
        return saleRepository.save(sale);
    }
}
