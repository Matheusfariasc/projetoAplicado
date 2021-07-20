//package com.serratec.trabalhoAplicado.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.serratec.trabalhoAplicado.model.Secretaria;
//import com.serratec.trabalhoAplicado.model.Usuario;
//import com.serratec.trabalhoAplicado.repository.SecretariaRepository;
//import com.serratec.trabalhoAplicado.repository.UsuarioRepository;
//
//@Service
//public class SecretariaService {
//	
//
//	@Autowired
//	private SecretariaRepository repositorioSecretaria;
//	
//
//	public List<Secretaria> obterTodos() {
//		return repositorioSecretaria.findAll();
//	}
//	
//	
//	public Optional<Secretaria> obterPorId(Long id) {
//		 Optional<Secretaria> secretaria = repositorioSecretaria.findById(id);	 
//		
//		 return secretaria;
//	}
//	
//	
//
//	public List<Secretaria> obterPorNome(String nome) {
//		List<Secretaria> secretaria = repositorioSecretaria.findByNomeContaining(nome);	
//		
//		return secretaria;
//	}
//	
//	public Secretaria adicionar(Secretaria secretaria) {
//		secretaria.setId(null);
//		
//		return repositorioSecretaria.save(secretaria);
//		
//	}
//	
//	 public Secretaria atualizar(Secretaria secretaria, Long id) {
//		 Optional<Secretaria> secretariaAtualizado = repositorioSecretaria.findById(id);
//		 
//		 secretaria.setId(id);		
//		return repositorioSecretaria.save(secretaria);
//		
//	}
//
//
//	public void deletar(Long id) {
//	    Optional<Secretaria> deletarSecretaria = repositorioSecretaria.findById(id);
//
//	    
//		repositorioSecretaria.deleteById(id);	 
//}
//	
//
//	
//}

