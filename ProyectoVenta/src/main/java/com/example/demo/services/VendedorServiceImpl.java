package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.IVendedorDao;
import com.example.demo.models.Vendedor;



@Service
public class VendedorServiceImpl implements IVendedorService{
	
	@Autowired
	private IVendedorDao vendedorDao;

	@Override
	@Transactional(readOnly= true)
	public Iterable<Vendedor> findAll() {
		return vendedorDao.findAll();
	}

	@Override
	@Transactional(readOnly= true)
	public Page<Vendedor> findAll(Pageable pageable) {
		return vendedorDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly= true)
	public Optional<Vendedor> findById(Long id) {
		return vendedorDao.findById(id);
	}

	@Override
	public Vendedor save(Vendedor vend) {
		return vendedorDao.save(vend);
	}

	@Override
	public void deleteById(Long id) {
		vendedorDao.deleteById(id);
	}
}
