package org.generation.projeto.repository;

import java.util.List;

import org.generation.projeto.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long>{
	
	public List<Tema> findAllByTituloTemaContainingIgnoreCase(String tituloTema); 
}
