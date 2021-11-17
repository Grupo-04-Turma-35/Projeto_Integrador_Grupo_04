package org.generation.projeto.repository;

import java.util.Optional;

import org.generation.projeto.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	/*
	 * método para procurar tudo a partir pelo email no atributo usuário  
	 */
	
	public Optional<Usuario> findByEmail(String email);

}
