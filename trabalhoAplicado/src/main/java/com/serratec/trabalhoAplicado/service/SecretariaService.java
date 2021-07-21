package com.serratec.trabalhoAplicado.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.serratec.trabalhoAplicado.exception.ResourceNotFoundException;
import com.serratec.trabalhoAplicado.model.Secretaria;

import com.serratec.trabalhoAplicado.repository.SecretariaRepository;


@Service
public class SecretariaService {
	

	@Autowired
	private SecretariaRepository repositorioSecretaria;
	
	@Autowired
	private PasswordEncoder passwordEnconder;
	

	public List<Secretaria> obterTodos() {
		return repositorioSecretaria.findAll();
	}
	
	
	public Optional<Secretaria> obterPorId(Long id) {
		 Optional<Secretaria> secretaria = repositorioSecretaria.findById(id);	 
		
		 if(secretaria.isEmpty()) {
			throw new ResourceNotFoundException("Secretario(a) não encontrado por id");
		}
		 
		 return secretaria;
	}
	
	

	public List<Secretaria> obterPorNome(String nome) {
		List<Secretaria> secretaria = repositorioSecretaria.findByNomeContaining(nome);	
		
		if(secretaria.isEmpty()) {
			throw new ResourceNotFoundException("Secretario(a) não encontrado por id");
		}
		return secretaria;
	}
	
	public Secretaria adicionar(Secretaria secretaria) {
		secretaria.setId(null);
		
		String senha = passwordEnconder.encode(secretaria.getSenha());
		secretaria.setSenha(senha);
		
		return repositorioSecretaria.save(secretaria);
		
	}
	
	 public Secretaria atualizar(Secretaria secretaria, Long id) {
		 Optional<Secretaria> secretariaAtualizado = repositorioSecretaria.findById(id);
		 
			if(secretariaAtualizado.isEmpty()) {
				throw new ResourceNotFoundException("Secretario(a) não encontrado por id");
			}
		 secretaria.setId(id);		
		return repositorioSecretaria.save(secretaria);
		
	}


	public void deletar(Long id) {
	    Optional<Secretaria> deletarSecretaria = repositorioSecretaria.findById(id);

	    if(deletarSecretaria.isEmpty()) {
			throw new ResourceNotFoundException("Secretario(a) não encontrado por id");
		}

		repositorioSecretaria.deleteById(id);	 
}
	

	
}

