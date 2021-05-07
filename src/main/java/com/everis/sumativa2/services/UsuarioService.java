package com.everis.sumativa2.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.sumativa2.models.Usuario;
import com.everis.sumativa2.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepository;

	public Usuario save(Usuario usuario) {
		usuario = usuarioRepository.save(usuario);
		return usuario;
	}

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	public void deleteById(Long id) {
		usuarioRepository.deleteById(id);
	}

	public Optional<Usuario> findById(Long id) {
		Optional<Usuario> oa = usuarioRepository.findById(id);
		return oa;
	}
	
	public void actualizarUsuario(@Valid Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	public Usuario findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}
	
	public boolean autenticacion(String email,String password) {
		Usuario usuario = usuarioRepository.findByEmail(email);
		if(usuario == null) {
			return false;
		}else {
			if(password == usuario.getPassword()) {
				return true;
			}else {
				return false;
			}
		}
	}
}
