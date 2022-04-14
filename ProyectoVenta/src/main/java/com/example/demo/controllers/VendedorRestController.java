package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

import com.example.demo.models.Vendedor;
import com.example.demo.services.IVendedorService;

@RestController
@RequestMapping("/api/vendedor")
public class VendedorRestController {
	@Autowired
	private IVendedorService vendedorService;
	
	
	//Crear+
		@PostMapping
		public ResponseEntity <?> crearVendedor(@RequestBody Vendedor vend){
			return ResponseEntity.status(HttpStatus.CREATED).body(vendedorService.save(vend));
		}
		
		
		//Listar por ID
		@GetMapping("/{id}")
			public ResponseEntity<?> BuscarIDVendedor(@PathVariable(value= "id") Long vendedorId){
				Optional<Vendedor> oVendedor = vendedorService.findById(vendedorId);
				
				if(!oVendedor.isPresent()) {
					return ResponseEntity.notFound().build();
				}
				return ResponseEntity.ok(oVendedor);
			}
		
		//Modificar
		@PutMapping("/{id}")
		public ResponseEntity<?> modificarVendedor (@RequestBody Vendedor vendedorUpdate, @PathVariable(value= "id") Long vendedorId){
			Optional<Vendedor> vendedor= vendedorService.findById(vendedorId);
			
			if(!vendedor.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			
			vendedor.get().setApodo(vendedorUpdate.getApodo());
			vendedor.get().setContrasena(vendedorUpdate.getContrasena());
			vendedor.get().setCorreo(vendedorUpdate.getCorreo());
			
			return ResponseEntity.status(HttpStatus.CREATED).body(vendedorService.save(vendedor.get()));
		}
		
		//Eliminar
		@DeleteMapping("/{id}")
		public ResponseEntity<?> eliminarVendedor(@PathVariable(value= "id") Long vendedorId){
			
			if(!vendedorService.findById(vendedorId).isPresent()) {
				return ResponseEntity.notFound().build();
			}
			
			vendedorService.deleteById(vendedorId);
			return ResponseEntity.ok().build();
		}
		
		//Listar Vendedores
		@GetMapping
		public List<Vendedor> ListarVendedor (){
			
			List<Vendedor> vendedor = StreamSupport
					.stream(vendedorService.findAll().spliterator(), false)
					.collect(Collectors.toList());
			
			return vendedor;
		}
}
