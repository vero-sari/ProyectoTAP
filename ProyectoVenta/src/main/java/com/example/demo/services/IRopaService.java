package com.example.demo.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.models.Ropa;

public interface IRopaService {
	public Iterable<Ropa> findAllRopa();
	public Page<Ropa> findAllRopa(Pageable pageable);
	public Optional<Ropa> findByIdRopa(Long id);
	public Ropa saveRopa(Ropa rop);
	public void deleteByIdRopa(Long id);
}
