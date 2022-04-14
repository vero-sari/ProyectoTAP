package com.example.demo.controllers;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.example.demo.models.Factura;
import com.example.demo.services.IFacturaService;

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
@RequestMapping("/api/factura")
public class FacturaRestController {
    @Autowired
	private IFacturaService facturaService;
	
	//Crear
			@PostMapping
			public ResponseEntity <?> crearFactura (@RequestBody Factura factura){
				return ResponseEntity.status(HttpStatus.CREATED).body(facturaService.saveFactura(factura));
			}
			
			
			//Buscar por ID
			@GetMapping("/{id}")
				public ResponseEntity<?> BuscarIDFactura(@PathVariable(value= "id") Long facturaId){
					Optional<Factura> oFactura = facturaService.findByIdFactura(facturaId);
					
					if(!oFactura.isPresent()) {
						return ResponseEntity.notFound().build();
					}
					return ResponseEntity.ok(oFactura);
				}
			
			//Modificar
			@PutMapping("/{id}")
			public ResponseEntity<?> modificarFactura (@RequestBody Factura facturaUpdate, @PathVariable(value= "id") Long facturaId){
				Optional<Factura> factura= facturaService.findByIdFactura(facturaId);
				
				if(!factura.isPresent()) {
					return ResponseEntity.notFound().build();
				}
				
				
				factura.get().setApodo(facturaUpdate.getApodo());
				
				
				return ResponseEntity.status(HttpStatus.CREATED).body(facturaService.saveFactura(factura.get()));
			}
			
			//Eliminar
			@DeleteMapping("/{id}")
			public ResponseEntity<?> eliminarFactura(@PathVariable(value= "id") Long facturaId){
				
				if(!facturaService.findByIdFactura(facturaId).isPresent()) {
					return ResponseEntity.notFound().build();
				}
				
				facturaService.deleteByIdFactura(facturaId);
				return ResponseEntity.ok().build();
			}
			
			//Listar Clientes
			@GetMapping
			public List<Factura> ListarFactura (){
				
				List<Factura> factura = StreamSupport
						.stream(facturaService.findAllFacturas().spliterator(), false)
						.collect(Collectors.toList());
				
				return factura;
			}
}
