package com.everis.sumativa2.controllers;

import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.sumativa2.models.Usuario;
import com.everis.sumativa2.services.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping("")
	public String inicioUsuario() {
		return "registro.jsp";
	}
	
	@RequestMapping("/insertar")
	public String insertar(
			@RequestParam("nombre") String nombre,
			@RequestParam("email") String email,
			@RequestParam("password") String password){
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setEmail(email);
		usuario.setPassword(password);
		
		usuario = usuarioService.save(usuario);
		return "redirect:/login/guardar";
	}
	
	@RequestMapping("/eliminar/{id}")
	public String eliminarUsuario(@PathVariable("id") Long id) {
	
		usuarioService.deleteById(id);
		return "redirect:/producto";
	}

	@RequestMapping("/editar/{id}")
	public String editarUsuario(@PathVariable("id") Long id,
			Model model) {
		Optional<Usuario> usuario = usuarioService.findById(id);
		model.addAttribute("usuario", usuario);
		return "editarUsuario.jsp";
	}
	
	@RequestMapping("/actualizar/")
	public String actualizarUsuario(
			@Valid @ModelAttribute("producto") Usuario usuario) {
		Optional<Usuario> usuario1 = usuarioService.findById(usuario.getId());
		usuarioService.actualizarUsuario(usuario);
		return "redirect:/usuario";
	}
	
	@PostMapping("/login")
	public String login(
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			HttpSession session,
			Model model){
		if(usuarioService.autenticacion(email, password)) {
			session.setAttribute("email", email);
			session.setAttribute("registrado",1);
			session.setAttribute("contador",100);
			String mail = (String) session.getAttribute("email");
			Integer registrado = (Integer) session.getAttribute("registrado");
			Integer contador = (Integer) session.getAttribute("contador");
			return "producto.jsp";
		}else {
			session.removeAttribute("registrado");
			session.setAttribute("registrado",0);
			//session.invalidate();
			model.addAttribute("mensaje", "Datos erroneos");
			return "login.jsp";
		}
			
	}
	
	@GetMapping("/login")
	public String getLogin(HttpSession session) {
		session.setAttribute("registrado",0);
		return "login.jsp";
	}
	
}
