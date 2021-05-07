package com.everis.sumativa2.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.sumativa2.models.Categoria;
import com.everis.sumativa2.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	CategoriaRepository categoriaRepository;

	public Categoria save(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	public List<Categoria> findAll() {
		
		return categoriaRepository.findAll();
	}

	public Optional<Categoria> findById(Long id) {
		Optional<Categoria> oa = categoriaRepository.findById(id);
		return oa;
	}

	public void deleteById(Long id) {
		categoriaRepository.deleteById(id);
	}

	public void actualizarCategoria(@Valid Categoria categoria) {
		// TODO Auto-generated method stub
		categoriaRepository.save(categoria);
	}
}
