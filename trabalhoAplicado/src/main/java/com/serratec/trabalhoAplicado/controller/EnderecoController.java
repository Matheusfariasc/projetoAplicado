package com.serratec.trabalhoAplicado.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serratec.trabalhoAplicado.model.Endereco;
import com.serratec.trabalhoAplicado.service.EnderecoService;




@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {

	
	@Autowired
	private EnderecoService servicoEndereco;
		

	@GetMapping 
	public List<Endereco> obterTodos() {
		return servicoEndereco.obterTodos();
	}
	
	@GetMapping("/{id}")
	public Optional<Endereco> obterPorId(@PathVariable("id")Long id){
		return servicoEndereco.obterPorId(id);
	}
	
	@PostMapping
	public Endereco adicionar(@RequestBody Endereco Endereco) {		
		return servicoEndereco.adicionar(Endereco);
	}
	
	@PutMapping("/{id}")
	public Endereco atualizar(@PathVariable(value = "id")Long id, @RequestBody Endereco Endereco){
		return servicoEndereco.atualizar(Endereco, id);
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable(value = "id")Long id) {
		servicoEndereco.deletar(id);
	}
		
}