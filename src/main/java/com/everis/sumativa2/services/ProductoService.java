package com.everis.sumativa2.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.everis.sumativa2.models.Producto;
import com.everis.sumativa2.repositories.ProductoRepository;

@Service
public class ProductoService {
	@Autowired
	ProductoRepository productoRepository;
	
	public Page<Producto> productosPaginados(int numeroPagina , int cantElementos){
		PageRequest pageRequest = PageRequest.of(numeroPagina, cantElementos);
		return productoRepository.findAll(pageRequest);
	}
	
	public Producto save(Producto producto) {
		return productoRepository.save(producto);
	}

	public List<Producto> findAll() {
		return productoRepository.findAll();
	}

	public Producto findById(Long id) {
		return productoRepository.findById(id).get();
	}

	public void deleteById(Long id) {
		productoRepository.deleteById(id);
	}

	public void actualizarProducto(@Valid Producto producto) {
		productoRepository.save(producto);
	}
	/*
	public void querysJPQL() {
		//JPQL
		List<Producto> lista1 =productoRepository.findAllProductos();
		List<String> lista2 = productoRepository.findAllProductosNombres();
		List<Producto> lista3 = productoRepository.getProductoWhereId(2L);
		Producto prod= productoRepository.getSingleProductoWhereId(3L);
		
		int respuesta=productoRepository.setNombreForOne("Mouse", 2L);
		int respuesta2=productoRepository.setNombreForAll("Notebook");
		int respuesta3=productoRepository.deleteOneProducto(2L);
		
		List<Object[]> oProductos = productoRepository.findAllProductosWithfilter();
		Object[] vProducto = oProductos.get(0);
		Object productoId= vProducto[0];
		Object productoNombre= vProducto[1];
		System.out.println(productoId+" - "+productoNombre);
	}
	*/
}
