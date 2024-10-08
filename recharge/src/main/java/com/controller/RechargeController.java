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

import com.model.Recharge;
import com.service.RechargeService;

/**
 * Controlador REST para manejar las operaciones relacionadas con las recargas.
 */
@RestController
@RequestMapping("/api/recargas")
@CrossOrigin(origins = "http://localhost:4200")
public class RechargeController {

    @Autowired
    private RechargeService rechargeService;

    /**
     * Obtiene todas las recargas.
     * 
     * @return ResponseEntity con la lista de todas las recargas.
     */
    @GetMapping
    public ResponseEntity<?> obtenerRecargas() {
        return ResponseEntity.ok(rechargeService.findAll());
    }
    
    /**
     * Obtiene una recarga por su ID.
     * 
     * @param id El ID de la recarga.
     * @return ResponseEntity con la recarga correspondiente al ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerRecargas(@PathVariable("id") Long id) {
        return ResponseEntity.ok(rechargeService.findById(id));
    }

    /**
     * Crea una nueva recarga.
     * 
     * @param recarga La información de la recarga a crear.
     * @return ResponseEntity con la recarga creada.
     */
    @PostMapping
    public ResponseEntity<Recharge> crearRecarga(@RequestBody Recharge recarga) {
        Recharge savedRecharge = rechargeService.save(recarga);
        return ResponseEntity.ok(savedRecharge);
    }
}
