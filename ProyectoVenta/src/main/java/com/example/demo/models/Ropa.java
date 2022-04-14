package com.example.demo.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ropa")
public class Ropa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_ropa;

	private String marca;
	private String estado;
	private String modelo;
	private String descripcion;
	private String talla;
	private double precio;
	private String color;

	// union cliente
	@ManyToMany(mappedBy = "ropa")
	@JsonIgnore
    private List<Cliente> cliente;

	// union vendedor
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "vendedores")
	private Vendedor vendedor;

	//union detalle 
    @OneToMany(mappedBy = "ropa")
    @JsonIgnore
    private List<DetalleFactura> detfac;

	public Long getId_ropa() {
		return id_ropa;
	}

	public void setId_ropa(Long id_ropa) {
		this.id_ropa = id_ropa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
