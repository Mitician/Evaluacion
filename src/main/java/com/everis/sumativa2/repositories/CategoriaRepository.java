package com.everis.sumativa2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.sumativa2.models.Categoria;

@Repository
public interface CategoriaRepository  extends JpaRepository<Categoria, Long>{
}
