package com.example.demo.services;

import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDetalleFacturaDao;
import com.example.demo.models.DetalleFactura;

import org.springframework.beans.factory.annotation.Autowired;


@Service
public class IDetalleFacturaImpl implements IDetalleFacturaService {
    
    @Autowired
	private IDetalleFacturaDao detalleDao;

	@Override
	@Transactional(readOnly= true)
	public Iterable<DetalleFactura> findAllDetalle() {
		return detalleDao.findAll();
	}

	@Override
	@Transactional(readOnly= true)
	public Page<DetalleFactura> findAllDetalleFactura(Pageable pageable) {
		return detalleDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly= true)
	public Optional<DetalleFactura> findByIdDetalle(Long id_detallefactura) {
		return detalleDao.findById(id_detallefactura);
	}

	@Override
	public DetalleFactura saveDetalle(DetalleFactura detalle) {
		return detalleDao.save(detalle);
	}

	@Override
	public void deleteByIdDetalle(Long id) {
		detalleDao.deleteById(id);
	}
}
