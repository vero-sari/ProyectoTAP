package com.example.demo.services;

import java.util.Optional;

import com.example.demo.models.DetalleFactura;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface IDetalleFacturaService {
    public Iterable<DetalleFactura> findAllDetalle();
	public Page<DetalleFactura> findAllDetalleFactura(Pageable pageable);
	public Optional<DetalleFactura> findByIdDetalle(Long id_detallefactura);
	public DetalleFactura saveDetalle(DetalleFactura detalle);
	public void deleteByIdDetalle(Long id_detallefactura);
}
