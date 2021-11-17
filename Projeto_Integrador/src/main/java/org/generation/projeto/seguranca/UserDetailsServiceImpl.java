package org.generation.projeto.seguranca;

import java.util.Optional;

import org.generation.projeto.model.Usuario;
import org.generation.projeto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired 
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> user = usuarioRepository.findByEmail(username);
		user.orElseThrow(() -> new UsernameNotFoundException(username + " não encontrado."));
		
		return user.map(UserDetailsImpl :: new).get();
	}
}