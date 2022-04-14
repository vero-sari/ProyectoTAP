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

import com.example.demo.models.Cliente;
import com.example.demo.services.IClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteRestController {
	
	@Autowired
	private IClienteService clienteService;
	
	//Crear
			@PostMapping
			public ResponseEntity <?> crearCliente (@RequestBody Cliente clie){
				return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.saveCliente(clie));
			}
			
			
			//Buscar por ID
			@GetMapping("/{id}")
				public ResponseEntity<?> BuscarIDCliente(@PathVariable(value= "id") Long clienteId){
					Optional<Cliente> oCliente = clienteService.findByIdCliente(clienteId);
					
					if(!oCliente.isPresent()) {
						return ResponseEntity.notFound().build();
					}
					return ResponseEntity.ok(oCliente);
				}
			
			//Modificar
			@PutMapping("/{id}")
			public ResponseEntity<?> modificarCliente (@RequestBody Cliente clienteUpdate, @PathVariable(value= "id") Long clienteId){
				Optional<Cliente> cliente= clienteService.findByIdCliente(clienteId);
				
				if(!cliente.isPresent()) {
					return ResponseEntity.notFound().build();
				}
				
				cliente.get().setNombre(clienteUpdate.getNombre());
				cliente.get().setApellido(clienteUpdate.getApellido());
				cliente.get().setApodo(clienteUpdate.getApodo());
				cliente.get().setContrasena(clienteUpdate.getContrasena());
				cliente.get().setCorreo(clienteUpdate.getCorreo());
				
				return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.saveCliente(cliente.get()));
			}
			
			//Eliminar
			@DeleteMapping("/{id}")
			public ResponseEntity<?> eliminarCliente(@PathVariable(value= "id") Long clienteId){
				
				if(!clienteService.findByIdCliente(clienteId).isPresent()) {
					return ResponseEntity.notFound().build();
				}
				
				clienteService.deleteByIdCliente(clienteId);
				return ResponseEntity.ok().build();
			}
			
			//Listar Clientes
			@GetMapping
			public List<Cliente> ListarCliente (){
				
				List<Cliente> cliente = StreamSupport
						.stream(clienteService.findAllCliente().spliterator(), false)
						.collect(Collectors.toList());
				
				return cliente;
			}
	
}
