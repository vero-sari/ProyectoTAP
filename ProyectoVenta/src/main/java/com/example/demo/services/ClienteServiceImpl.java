package com.example.demo.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.IClienteDao;
import com.example.demo.models.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService {
	
	@Autowired
	private IClienteDao clienteDao;

	@Override
	@Transactional(readOnly= true)
	public Iterable<Cliente> findAllCliente() {
		return clienteDao.findAll();
	}

	@Override
	@Transactional(readOnly= true)
	public Page<Cliente> findAllCliente(Pageable pageable) {
		return clienteDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly= true)
	public Optional<Cliente> findByIdCliente(Long id) {
		return clienteDao.findById(id);
	}

	@Override
	public Cliente saveCliente(Cliente clie) {
		return clienteDao.save(clie);
	}

	@Override
	public void deleteByIdCliente(Long id) {
		clienteDao.deleteById(id);
	}

}
