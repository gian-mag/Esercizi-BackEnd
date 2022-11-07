package com.giandomenico.dispositivi.gestionedispositivi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.giandomenico.dispositivi.gestionedispositivi.entities.Utente;
import com.giandomenico.dispositivi.gestionedispositivi.repository.UtenteRepository;

@Service
public class UtenteService {

	@Autowired
	UtenteRepository ur;
	
	public void saveUser(Utente u) {
		ur.save(u);
	}
	
	public void deleteUserById(Long id) {
		ur.deleteById(id);
	}
	
	public Optional<Utente> getUserById(Long id) {
		return ur.findById(id);
	}
	
	public Page<Utente> getAllUsers(Pageable p){
		return ur.findAll(p);
	}
	
	public Page<Utente> getAllAndPaginate(Pageable p){
		return ur.findAll(p);
	}
	
	public Optional<Utente> getUserByNameAndPaginate(String nome, String cognome) {
		return ur.findByNameAndLastName(nome, cognome);
	}
	
	public Optional<Utente> getByName(String username) {
		return ur.findByName(username);
	}
	
}
