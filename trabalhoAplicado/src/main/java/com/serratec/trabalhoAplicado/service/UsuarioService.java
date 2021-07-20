package com.serratec.trabalhoAplicado.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serratec.trabalhoAplicado.model.Usuario;
import com.serratec.trabalhoAplicado.repository.UsuarioRepository;



@Service
public class UsuarioService {
	

	@Autowired
	private UsuarioRepository repositorioUsuario;
	

	public List<Usuario> obterTodos() {
		return repositorioUsuario.findAll();
	}
	
	
	public Optional<Usuario> obterPorId(Long id) {
		 Optional<Usuario> usuario = repositorioUsuario.findById(id);	 
		
		 return usuario;
	}
	
	

	public List<Usuario> obterPorNome(String nome) {
		List<Usuario> usuario = repositorioUsuario.findByNomeContaining(nome);	
		
		return usuario;
	}
	
	public Usuario adicionar(Usuario usuario) {
		usuario.setId(null);
		
		return repositorioUsuario.save(usuario);
		
	}
	
	 public Usuario atualizar(Usuario usuario, Long id) {
		 Optional<Usuario> usuarioAtualizado = repositorioUsuario.findById(id);
		 
		usuario.setId(id);		
		return repositorioUsuario.save(usuario);
		
	}


	public void deletar(Long id) {
	    Optional<Usuario> deletarUsuario = repositorioUsuario.findById(id);

	    
		repositorioUsuario.deleteById(id);	 
}
	

	
}
