package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Vendedor;

@Repository
public interface IVendedorDao extends JpaRepository<Vendedor, Long> {

}
