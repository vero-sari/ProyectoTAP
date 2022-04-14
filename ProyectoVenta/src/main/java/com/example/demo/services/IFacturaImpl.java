package com.example.demo.services;

import java.util.Optional;

import com.example.demo.dao.IFacturaDao;
import com.example.demo.models.Factura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IFacturaImpl implements IFacturaService {
    
    @Autowired
	private IFacturaDao facturaDao;

	@Override
	@Transactional(readOnly= true)
	public Iterable<Factura> findAllFacturas() {
		return facturaDao.findAll();
	}

	@Override
	@Transactional(readOnly= true)
	public Page<Factura> findAllFactura(Pageable pageable) {
		return facturaDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly= true)
	public Optional<Factura> findByIdFactura(Long num_factura) {
		return facturaDao.findById(num_factura);
	}

	@Override
	public Factura saveFactura(Factura factura) {
		return facturaDao.save(factura);
	}

	@Override
	public void deleteByIdFactura(Long num_factura) {
		facturaDao.deleteById(num_factura);
	}
}
