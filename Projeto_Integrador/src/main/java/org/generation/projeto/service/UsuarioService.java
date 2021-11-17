package org.generation.projeto.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.apache.commons.codec.binary.Base64;
import org.generation.projeto.model.Usuario;
import org.generation.projeto.model.UsuarioLogin;
import org.generation.projeto.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Optional<Usuario> cadastrarUsuario(Usuario usuario){
		
		if(usuarioRepository.findByEmail(usuario.getEmail()).isPresent())
			return Optional.empty();
		
		usuario.setSenha(criptografarSenha(usuario.getSenha()));
			return Optional.of(usuarioRepository.save(usuario));
	}

	public Optional<Usuario> atualizarUsuario(Usuario usuario){
		
		if(usuarioRepository.findById(usuario.getIdusuario()).isPresent()) {
			
			Optional<Usuario> buscaUsuario = usuarioRepository.findByEmail(usuario.getEmail());
			
			if(buscaUsuario.isPresent()) {
				if (buscaUsuario.get().getIdusuario() != usuario.getIdusuario())
					return Optional.empty();
			}
			
			usuario.setSenha(criptografarSenha(usuario.getSenha()));
				return Optional.of(usuarioRepository.save(usuario));
		}
		
		return Optional.empty();
	}
	 
	public Optional<UsuarioLogin> autenticarUsuario(Optional<UsuarioLogin> usuarioLogin){
		Optional<Usuario> usuario = usuarioRepository.findByEmail(usuarioLogin.get().getUsuariologin());
		
		if(usuario.isPresent()) {
			if(compararSenhas(usuarioLogin.get().getSenhalogin(), usuario.get().getSenha())) {
				
				String token = gerarBasicToken(usuarioLogin.get().getUsuariologin(), usuarioLogin.get().getSenhalogin());
				
				usuarioLogin.get().setIdlogin(usuario.get().getIdusuario());
				usuarioLogin.get().setNomelogin(usuario.get().getNome());
				usuarioLogin.get().setSenhalogin(usuario.get().getSenha());
				usuarioLogin.get().setToken(token);
				
				return usuarioLogin;
			}
		}
		return Optional.empty();
	} 
	
	private String criptografarSenha(String senha) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		return encoder.encode(senha);
	}
	
	private boolean compararSenhas(String senhaDigitada, String senhaBanco) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		return encoder.matches(senhaDigitada, senhaBanco);
	}
	
	private String gerarBasicToken(String email, String password) {
		
		String tokenBase = email + ":" + password;
		byte[] tokenBase64 = Base64.encodeBase64(tokenBase.getBytes(Charset.forName("US-ASCII")));
		return "Basic " + new String(tokenBase64);
	}
}