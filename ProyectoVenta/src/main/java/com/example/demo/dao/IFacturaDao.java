package com.example.demo.dao;

import com.example.demo.models.Factura;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacturaDao extends JpaRepository<Factura,Long>{
    
}
