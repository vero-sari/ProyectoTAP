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


import com.example.demo.models.Ropa;
import com.example.demo.services.IRopaService;


@RestController
@RequestMapping("/api/ropa")
public class RopaRestController {
	
	@Autowired
	private IRopaService ropaService;
	
	//Crear
			@PostMapping
			public ResponseEntity <?> crearRopa(@RequestBody Ropa rop){
				return ResponseEntity.status(HttpStatus.CREATED).body(ropaService.saveRopa(rop));
			}
			
			
			//Listar por ID
			@GetMapping("/{id}")
				public ResponseEntity<?> BuscarIDRopa(@PathVariable(value= "id") Long ropaId){
					Optional<Ropa> oropa = ropaService.findByIdRopa(ropaId);
					
					if(!oropa.isPresent()) {
						return ResponseEntity.notFound().build();
					}
					return ResponseEntity.ok(oropa);
				}
			
			//Modificar
			@PutMapping("/{id}")
			public ResponseEntity<?> modificarRopa (@RequestBody Ropa ropaUpdate, @PathVariable(value= "id") Long ropaId){
				Optional<Ropa> ropa= ropaService.findByIdRopa(ropaId);
				
				if(!ropa.isPresent()) {
					return ResponseEntity.notFound().build();
				}
				
				ropa.get().setMarca(ropaUpdate.getMarca());
				ropa.get().setEstado(ropaUpdate.getEstado());
				ropa.get().setModelo(ropaUpdate.getModelo());
				ropa.get().setDescripcion(ropaUpdate.getDescripcion());
				ropa.get().setTalla(ropaUpdate.getTalla());
				ropa.get().setPrecio(ropaUpdate.getPrecio());
				ropa.get().setColor(ropaUpdate.getColor());
				
				
				return ResponseEntity.status(HttpStatus.CREATED).body(ropaService.saveRopa(ropa.get()));
			}
			
			//Eliminar
			@DeleteMapping("/{id}")
			public ResponseEntity<?> eliminarRopa(@PathVariable(value= "id") Long ropaId){
				
				if(!ropaService.findByIdRopa(ropaId).isPresent()) {
					return ResponseEntity.notFound().build();
				}
				
				ropaService.deleteByIdRopa(ropaId);
				return ResponseEntity.ok().build();
			}
			
			//Listar los vendedores por id
			@GetMapping
			public List<Ropa> ListarRopa (){
				
				List<Ropa> ropa = StreamSupport
						.stream(ropaService.findAllRopa().spliterator(), false)
						.collect(Collectors.toList());
				
				return ropa;
			}
}
	

