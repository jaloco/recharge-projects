package com.model;

import java.util.Objects;

import com.model.enumeration.Operador;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Recharge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "operador", nullable = false)
    private Operador operador;

    @Column(name = "valor", nullable = false)
    private double valor;
    
    @Column(name = "numero", nullable = false)
    private Long numero;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    public Recharge() {
    }

    public Recharge(Operador operador, double valor, Long numero, int cantidad) {
        this.operador = operador;
        this.valor = valor;
        this.numero = numero;
        this.cantidad = cantidad;
    }
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Operador getOperador() {
		return operador;
	}

	public void setOperador(Operador operador) {
		this.operador = operador;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public Long getNumero() {
		return numero;
	}

	public void setCantidad(Long numero) {
		this.numero = numero;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recharge)) return false;
        Recharge recharge = (Recharge) o;
        return Objects.equals(id, recharge.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
