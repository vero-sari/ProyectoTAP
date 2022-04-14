package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.example.demo.models.DetalleFactura;
import com.example.demo.services.IDetalleFacturaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/detalle")
public class DetalleRestController {
    @Autowired
	private IDetalleFacturaService detalleService;
	
	//Crear
			@PostMapping
			public ResponseEntity <?> crearDetalle (@RequestBody DetalleFactura detalle){
				return ResponseEntity.status(HttpStatus.CREATED).body(detalleService.saveDetalle(detalle));
			}
			
			
			//Buscar por ID
			@GetMapping("/{id}")
				public ResponseEntity<?> BuscarIDDetalle(@PathVariable(value= "id") Long detalleId){
					Optional<DetalleFactura> oDetalle = detalleService.findByIdDetalle(detalleId);
					
					if(!oDetalle.isPresent()) {
						return ResponseEntity.notFound().build();
					}
					return ResponseEntity.ok(oDetalle);
				}
			
			//Modificar
			@PutMapping("/{id}")
			public ResponseEntity<?> modificarDetalle (@RequestBody DetalleFactura detalleUpdate, @PathVariable(value= "id") Long detalleId){
				Optional<DetalleFactura> detalle= detalleService.findByIdDetalle(detalleId);
				
				if(!detalle.isPresent()) {
					return ResponseEntity.notFound().build();
				}
				
				detalle.get().setCantidad(detalleUpdate.getCantidad());
				detalle.get().setTotal(detalleUpdate.getTotal());
				
				
				return ResponseEntity.status(HttpStatus.CREATED).body(detalleService.saveDetalle(detalle.get()));
			}
			
			//Eliminar
			@DeleteMapping("/{id}")
			public ResponseEntity<?> eliminarDetalle(@PathVariable(value= "id") Long detalleId){
				
				if(!detalleService.findByIdDetalle(detalleId).isPresent()) {
					return ResponseEntity.notFound().build();
				}
				
				detalleService.deleteByIdDetalle(detalleId);
				return ResponseEntity.ok().build();
			}
			
			//Listar Clientes
			@GetMapping
			public List<DetalleFactura> ListarDetalle (){
				
				List<DetalleFactura> detalle = StreamSupport
						.stream(detalleService.findAllDetalle().spliterator(), false)
						.collect(Collectors.toList());
				
				return detalle;
			}
}
