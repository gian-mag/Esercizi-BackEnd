package com.giandomenico.dispositivi.gestionedispositivi.security;

import java.util.Optional;

import com.giandomenico.dispositivi.gestionedispositivi.entities.Utente;
import com.giandomenico.dispositivi.gestionedispositivi.repository.UtenteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UtenteRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
		Optional<Utente> user = userRepository.findByName(nome);

		if (user.isPresent()) {
			return UserDetailsImpl.build(user.get());
		} else {
			throw new UsernameNotFoundException("User Not Found with username: " + nome);
		}
	}

}
