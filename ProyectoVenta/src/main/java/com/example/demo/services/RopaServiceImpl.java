package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.IRopaDao;
import com.example.demo.models.Ropa;

@Service
public class RopaServiceImpl implements IRopaService{
	
	@Autowired
	private IRopaDao ropaDao;

	@Override
	@Transactional(readOnly= true)
	public Iterable<Ropa> findAllRopa() {
		return ropaDao.findAll();
	}

	@Override
	@Transactional(readOnly= true)
	public Page<Ropa> findAllRopa(Pageable pageable) {
		return ropaDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly= true)
	public Optional<Ropa> findByIdRopa(Long id) {
		return ropaDao.findById(id);
	}

	@Override
	public Ropa saveRopa(Ropa rop) {
		return ropaDao.save(rop);
	}

	@Override
	public void deleteByIdRopa(Long id) {
		ropaDao.deleteById(id);
	}
}