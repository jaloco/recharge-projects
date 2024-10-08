package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Sale;
import com.repository.SaleRepository;

/**
 * Controlador REST para manejar las operaciones relacionadas con las ventas.
 */
@RestController
@RequestMapping("/api/ventas")
@CrossOrigin(origins = "http://localhost:4200")
public class SaleController {

    @Autowired
    private SaleRepository saleRepository;

    /**
     * Crea una nueva venta.
     * 
     * @param venta La información de la venta a crear.
     * @return La venta creada.
     */
    @PostMapping
    public Sale crearVenta(@RequestBody Sale venta) {
        return saleRepository.save(venta);
    }
    
    /**
     * Obtiene todas las ventas.
     * 
     * @return ResponseEntity con la lista de todas las ventas.
     */
    @GetMapping
    public ResponseEntity<?> obtenerSales() {
        return ResponseEntity.ok(saleRepository.findAll());
    }
    
    /**
     * Obtiene una venta por su ID.
     * 
     * @param id El ID de la venta.
     * @return ResponseEntity con la venta correspondiente al ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenervendedor(@PathVariable("id") Long id) {
        return ResponseEntity.ok(saleRepository.findById(id));
    }
}
