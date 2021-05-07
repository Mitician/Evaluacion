package com.everis.sumativa2.controllers;

import java.util.List;
import java.util.function.Predicate;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.sumativa2.models.Categoria;
import com.everis.sumativa2.models.Producto;
import com.everis.sumativa2.services.CategoriaService;
import com.everis.sumativa2.services.ProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	ProductoService productoService;
	@Autowired
	CategoriaService categoriaService;
	
	private static final int CANT_PRODUCTOS = 6;
	
	@RequestMapping("")
	public String inicioProducto(HttpSession session, Model model) {
		Integer registrado = (Integer) session.getAttribute("registrado");
		if(registrado==1) {
			model.addAttribute("listaProductos", productoService.findAll());
			Page<Producto> productos= productoService.productosPaginados(0, CANT_PRODUCTOS);
			int totalPagina= productos.getTotalPages();
			model.addAttribute("totalPagina", totalPagina);
			model.addAttribute("productos", productos);
			return "producto.jsp";
		}
		return "login.jsp";
	}
	
	@RequestMapping("/insertar")
	public String insertar(
			@RequestParam("nombre") String nombre,
			@RequestParam("precio") String precio,
			@RequestParam("caracteristicas") String caracteristicas){
		Producto producto = new Producto();
		producto.setNombre(nombre);
		producto.setPrecio(Float.parseFloat(precio));
		producto.setCaracteristicas(caracteristicas);
		
		productoService.save(producto);
		return "redirect:/producto";
	}
	
	@RequestMapping("/eliminar/{id}")
	public String eliminarProducto(@PathVariable("id") Long id, HttpSession session) {
		productoService.deleteById(id);
		return "redirect:/producto";
	}

	@RequestMapping("/editar/{id}")
	public String editarProducto(@PathVariable("id") Long id, HttpSession session,
			Model model) {
		Producto prod= productoService.findById(id);
		List<Categoria> listaCategorias =  categoriaService.findAll();
		model.addAttribute("producto", prod);
		model.addAttribute("listaCategorias", listaCategorias);
		return "editarProducto.jsp";
	}
	
	@RequestMapping("/actualizar")
	public String actualizarProducto(@ModelAttribute("producto") Producto producto, HttpSession session) {
		productoService.save(producto);
		return "redirect:/producto";
	}
	
	@RequestMapping("/paginacion/{numeroPagina}")
	public String paginarProductos(@PathVariable("numeroPagina") int numeroPagina, Model model) {
		Page<Producto> productos= productoService.productosPaginados(numeroPagina-1, CANT_PRODUCTOS);
		int totalPagina= productos.getTotalPages();
		model.addAttribute("totalPagina", totalPagina);
		model.addAttribute("productos", productos);
		return "producto.jsp";
	}
	
	public static Predicate<Producto> filtroNombre(String nombre) {
	    return (Producto l) -> {
	      return l.getNombre().equals(nombre);
	    };
	  }
		
	public String filtrarProductos(@ModelAttribute("producto") Producto producto, HttpSession session, String busqueda) {
		List<Producto> lista = productoService.findAll();
		lista.stream()
		.filter(filtroNombre(busqueda));
		return "lista";
	}
}
