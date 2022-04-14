package com.example.demo.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.models.Vendedor;


public interface IVendedorService {
	public Iterable<Vendedor> findAll();
	public Page<Vendedor> findAll(Pageable pageable);
	public Optional<Vendedor> findById(Long id);
	public Vendedor save(Vendedor vend);
	public void deleteById(Long id);
}
