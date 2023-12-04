package com.example.restapi.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import com.example.restapi.entities.Categoria;
import com.example.restapi.entities.Categoria;
import com.example.restapi.repositories.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
		
	@Autowired
	CategoriaRepository repo;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> getCategorias() {
		List<Categoria> categorias = repo.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(categorias);
	}
	
	@GetMapping("/{idCategoria}")
	public ResponseEntity<Categoria> getCategoria(@PathVariable("idCategoria") Long id) {
		Optional<Categoria> opt = repo.findById(id);
		try {
			Categoria prod = opt.get();	
			return ResponseEntity.status(HttpStatus.OK).body(prod);
		}
		catch(Exception e) {
		   return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}		
	}
	
	@DeleteMapping("/{idCategoria}")
	public ResponseEntity<Categoria> excluirCategoria(@PathVariable("idCategoria") Long id) {
		Optional<Categoria> opt = repo.findById(id);
		try {
			Categoria prod = opt.get();	
			repo.delete(prod);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		catch(Exception e) {
		   return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@PutMapping("/{idCategoria}")
	public ResponseEntity<Categoria> alterarCategoria(@PathVariable("idCategoria") Long id, @RequestBody Categoria Categoria ) {
		Optional<Categoria> opt = repo.findById(id);
		try {
			Categoria prod = opt.get();	
			prod.setDescricao(Categoria.getDescricao());
			repo.save(prod);
			return ResponseEntity.status(HttpStatus.OK).body(prod);
		}
		catch(Exception e) {
		   return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@PostMapping
	public ResponseEntity<Categoria> salvarCategoria(@RequestBody Categoria Categoria) {
		/*Categoria.setId(Categorias.size()+1l);*/
		//Categorias.add(Categoria);
		Categoria prod = repo.save(Categoria);
		return ResponseEntity.status(HttpStatus.CREATED).body(prod);
	}
}
