package com.serratec.trabalhoAplicado.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serratec.trabalhoAplicado.model.Endereco;
import com.serratec.trabalhoAplicado.repository.EnderecoRepository;


@Service
public class EnderecoService {
	


	@Autowired
	private EnderecoRepository repositorioEndereco;
	

	public List<Endereco> obterTodos() {
		return repositorioEndereco.findAll();
	}
	
	
	public Optional<Endereco> obterPorId(Long id) {
		 Optional<Endereco> Endereco = repositorioEndereco.findById(id);	 
			 
		return Endereco;
	}
	
	
	public Endereco adicionar(Endereco Endereco) {
		Endereco.setId(null);
		
		return repositorioEndereco.save(Endereco);
		
	}
	
	 public Endereco atualizar(Endereco Endereco, Long id) {
		 Optional<Endereco> EnderecoAtualizado = repositorioEndereco.findById(id);
		 
		Endereco.setId(id);		
		return repositorioEndereco.save(Endereco);
		
	}


	public void deletar(Long id) {
	    Optional<Endereco> deletarEndereco = repositorioEndereco.findById(id);
		
		repositorioEndereco.deleteById(id);	 
}
	

}