package com.everis.sumativa2.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.everis.sumativa2.models.Usuario;
import com.everis.sumativa2.services.UsuarioService;

@Controller
public class HomeController {
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		session.setAttribute("registrado",0);
		return "login.jsp";
	}
	
	@RequestMapping("/registro")
	public String registro(@Valid @ModelAttribute("usuario") Usuario usuario,Model model) {
		model.addAttribute("usuario", new Usuario());
		return "registro.jsp";
	}
}
