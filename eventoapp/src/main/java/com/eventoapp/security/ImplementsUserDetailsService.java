package com.eventoapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.eventoapp.models.Usuario;
import com.eventoapp.repository.UsuarioRepository;

@Service
public class ImplementsUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository ur;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		
		Usuario usuario =  ur.findByLogin(login);
		
		if (usuario == null) {
			throw new UsernameNotFoundException("Usuario nao encontrado");
		}
		
		return new User(usuario.getLogin(), usuario.getPassword(), usuario.isEnabled(), usuario.isAccountNonExpired(),usuario.isCredentialsNonExpired(), usuario.isAccountNonLocked(), usuario.getAuthorities());
	}

}
