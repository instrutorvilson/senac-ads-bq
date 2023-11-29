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

import com.example.restapi.entities.Produto;
import com.example.restapi.repositories.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	/*foi aposentada*/
	//List<Produto> produtos = new ArrayList<Produto>();	
	
	@Autowired
	ProdutoRepository repo;
	
	/*
	@GetMapping("/produtos")
	public ResponseEntity<List<Produto>> getProdutos() {
		return ResponseEntity.status(HttpStatus.OK).body(produtos);
	}
	
	@GetMapping("/produtos/{idProduto}")
	public ResponseEntity<Produto> getProduto(@PathVariable("idProduto") int id) {
		Produto prod = null;
		for(Produto pr : produtos) {
			if(pr.getId() == id) {
				prod = pr;
				break;
			}
		}
		if(prod != null)
		   return ResponseEntity.status(HttpStatus.OK).body(prod);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@DeleteMapping("/produtos/{idProduto}")
	public ResponseEntity<Produto> excluirProduto(@PathVariable("idProduto") int id) {
		Produto prod = null;
		for(Produto pr : produtos) {
			if(pr.getId() == id) {
				prod = pr;
				break;
			}
		}
		if(prod != null) {
		   produtos.remove(prod);	
		   return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@PutMapping("/produtos/{idProduto}")
	public ResponseEntity<Produto> alterarProduto(@PathVariable("idProduto") int id, @RequestBody Produto produto ) {
		Produto prod = null;
		for(Produto pr : produtos) {
			if(pr.getId() == id) {
				prod = pr;
				break;
			}
		}
		if(prod != null) {
		   prod.setDescricao(produto.getDescricao());
		   prod.setValorUnitario(produto.getValorUnitario());
		   prod.setEstoque(produto.getEstoque());
		   return ResponseEntity.status(HttpStatus.OK).body(prod);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@PostMapping("/produtos")
	public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto) {
		produto.setId(produtos.size()+1);
		produtos.add(produto);
		return ResponseEntity.status(HttpStatus.CREATED).body(produto);
	}*/
	@GetMapping
	public ResponseEntity<List<Produto>> getProdutos() {
		List<Produto> produtos = repo.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(produtos);
	}
	
	@GetMapping("/{idProduto}")
	public ResponseEntity<Produto> getProduto(@PathVariable("idProduto") Long id) {
		Optional<Produto> opt = repo.findById(id);
		try {
			Produto prod = opt.get();	
			return ResponseEntity.status(HttpStatus.OK).body(prod);
		}
		catch(Exception e) {
		   return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}		
	}
	
	@DeleteMapping("/{idProduto}")
	public ResponseEntity<Produto> excluirProduto(@PathVariable("idProduto") Long id) {
		Optional<Produto> opt = repo.findById(id);
		try {
			Produto prod = opt.get();	
			repo.delete(prod);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		catch(Exception e) {
		   return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@PutMapping("/{idProduto}")
	public ResponseEntity<Produto> alterarProduto(@PathVariable("idProduto") Long id, @RequestBody Produto produto ) {
		Optional<Produto> opt = repo.findById(id);
		try {
			Produto prod = opt.get();	
			prod.setDescricao(produto.getDescricao());
			prod.setEstoque(produto.getEstoque());
			prod.setValorUnitario(produto.getValorUnitario());
			repo.save(prod);
			return ResponseEntity.status(HttpStatus.OK).body(prod);
		}
		catch(Exception e) {
		   return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@PostMapping
	public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto) {
		/*produto.setId(produtos.size()+1l);*/
		//produtos.add(produto);
		Produto prod = repo.save(produto);
		return ResponseEntity.status(HttpStatus.CREATED).body(prod);
	}
}
