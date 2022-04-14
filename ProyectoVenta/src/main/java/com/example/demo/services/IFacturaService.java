package com.example.demo.services;

import com.example.demo.models.Factura;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface IFacturaService {
    public Iterable<Factura> findAllFacturas();
	public Page<Factura> findAllFactura(Pageable pageable);
	public Optional<Factura> findByIdFactura(Long num_factura);
	public Factura saveFactura(Factura factura);
	public void deleteByIdFactura(Long num_factura);
}
