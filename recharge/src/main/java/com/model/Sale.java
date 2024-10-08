package com.model;

import java.util.Objects;

import org.antlr.v4.runtime.misc.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vendedor", nullable = false)
    private String vendedor;

    @ManyToOne
    @JoinColumn(name = "recharge_id", referencedColumnName = "id",nullable = false)
    private Recharge recarga;

    public Sale() {
    }

    public Sale(String vendedor, Recharge recarga) {
        this.vendedor = vendedor;
        this.recarga = recarga;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public Recharge getRecarga() {
        return recarga;
    }

    public void setRecarga(Recharge recarga) {
        this.recarga = recarga;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sale)) return false;
        Sale venta = (Sale) o;
        return Objects.equals(id, venta.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
