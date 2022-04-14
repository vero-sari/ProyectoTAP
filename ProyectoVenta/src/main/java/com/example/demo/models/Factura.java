package com.example.demo.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="factura")
public class Factura implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long num_factura;
	
	private String apodo;
//	private Long id_detallefactura;
	//private Long id_cliente;
	
	//-------------------------
	@OneToOne
	@JsonIgnore
    @JoinColumn(name="id_detallefactura",nullable = false)  
    private DetalleFactura dfactura;
	//-------------------------------
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "id_cliente", nullable = false)
	private Cliente cli;
	//--------------------------------
	public Long getNum_factura() {
		return num_factura;
	}
	public void setNum_factura(Long num_factura) {
		this.num_factura = num_factura;
	}
	public String getApodo() {
		return apodo;
	}
	public void setApodo(String apodo) {
		this.apodo = apodo;
	}
/*	public Long getId_detallefactura() {
		return id_detallefactura;
	}
	public void setId_detallefactura(Long id_detallefactura) {
		this.id_detallefactura = id_detallefactura;
	}*/
/*	public Long getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}*/
	
	
}
