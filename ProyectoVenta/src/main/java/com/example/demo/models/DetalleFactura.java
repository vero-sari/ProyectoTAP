package com.example.demo.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="detallefactura")
public class DetalleFactura implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_detallefactura;
	
	//private Long id_ropa;
	private int cantidad;
	private double total;
//------------------------------
	@OneToOne(mappedBy = "dfactura")
    @JsonIgnore
    private Factura factura;
//-------------------------------
@ManyToOne
@JsonIgnore
@JoinColumn(name = "id_ropa", nullable = false)
private Ropa ropa; 
//---------------------------------
	public Long getId_detallefactura() {
		return id_detallefactura;
	}
	public void setId_detallefactura(Long id_detallefactura) {
		this.id_detallefactura = id_detallefactura;
	}
	/*public Long getId_ropa() {
		return id_ropa;
	}
	public void setId_ropa(Long id_ropa) {
		this.id_ropa = id_ropa;*/
	//}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
	
}
