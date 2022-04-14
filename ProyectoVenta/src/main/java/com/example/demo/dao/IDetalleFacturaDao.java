package com.example.demo.dao;

import com.example.demo.models.DetalleFactura;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IDetalleFacturaDao extends JpaRepository<DetalleFactura,Long>{
    
}
