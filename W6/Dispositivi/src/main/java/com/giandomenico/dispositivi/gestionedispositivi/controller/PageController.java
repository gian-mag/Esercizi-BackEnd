package com.giandomenico.dispositivi.gestionedispositivi.controller;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.giandomenico.dispositivi.gestionedispositivi.entities.Assegnamento;
import com.giandomenico.dispositivi.gestionedispositivi.entities.Dispositivo;
import com.giandomenico.dispositivi.gestionedispositivi.entities.Ruolo;
import com.giandomenico.dispositivi.gestionedispositivi.entities.TipoDiRuolo;
import com.giandomenico.dispositivi.gestionedispositivi.entities.TipologiaDispositivo;
import com.giandomenico.dispositivi.gestionedispositivi.entities.Utente;
import com.giandomenico.dispositivi.gestionedispositivi.service.DispositivoService;
import com.giandomenico.dispositivi.gestionedispositivi.service.RuoloService;
import com.giandomenico.dispositivi.gestionedispositivi.service.UtenteService;

@RestController
@RequestMapping("/app")
public class PageController {

	@Autowired
	UtenteService us;

	@Autowired
	RuoloService rs;

	@Autowired
	DispositivoService ds;

	@GetMapping("/add-user-admin")
	public String addAdminUser() {
		Utente user = new Utente();
		user.setNome("GiandomenicoLOMBOK");
		user.setCognome("Maggio");
		user.setUsername("Distrutto93");
		user.setActive(true);
		user.setEmail("aiuto@help.me");
		user.setPassword("admin");
		Set<Ruolo> roles = new HashSet<Ruolo>();
		Ruolo admin = rs.getById(1L).get();
		roles.add(admin);
		user.setRoles(roles);

		us.saveUser(user);

		return "User added";
	}

	@GetMapping("/add-user")
	public String addSimpleUser(@RequestParam("nome") String nome, @RequestParam("cognome") String cognome,
			@RequestParam("username") String username, @RequestParam("email") String email,
			@RequestParam("password") String password) {
		Utente user = new Utente();
		user.setNome(nome);
		user.setCognome(cognome);
		user.setUsername(username);
		user.setActive(true);
		user.setEmail(email);
		user.setPassword(password);
		Set<Ruolo> roles = new HashSet<Ruolo>();
		Ruolo admin = rs.getById(2L).get();
		roles.add(admin);
		user.setRoles(roles);

		us.saveUser(user);

		return "Simple User added";
	}

	@GetMapping("/add-devices")
	public String addDevices(@RequestParam("tipologia") TipologiaDispositivo tipologia,
			@RequestParam("assegnazione") Assegnamento assegnazione) {
		Dispositivo device = new Dispositivo();
		device.setAssegnazione(assegnazione);
		device.setTipologia(tipologia);

		ds.saveDevice(device);

		return "Device added";
	}

	@PutMapping("/users/{id}/add-devices")
	public String addDevicesToUser(@PathVariable("id") Long user_id, @RequestParam("dispositivo") Long dispositivo_id) {
		Optional<Dispositivo> d = ds.getDeviceById(dispositivo_id);
		if (d.get().getAssegnazione() != Assegnamento.ASSEGNATO) {
			Optional<Utente> u = us.getUserById(user_id);
			if (u.isPresent()) {
				Assegnamento assStart = Assegnamento.DISPONIBILE;
				Assegnamento assEnd = Assegnamento.ASSEGNATO;
				ds.updateDeviceByUser(u.get(), assStart, dispositivo_id);
				ds.updateDeviceStatus(assEnd, dispositivo_id);
				return "Device added";
			}
		} else {
			return "Il dispositivo è stato già assegnato o è in manutenzione";
		}

		return "Something went wrong";
	}

	@GetMapping("/add-roles")
	public String addRoles() {
		Ruolo roleAdmin = new Ruolo();
		roleAdmin.setTipodiruolo(TipoDiRuolo.ROLE_ADMIN);
		rs.addRole(roleAdmin);

		Ruolo roleUser = new Ruolo();
		roleUser.setTipodiruolo(TipoDiRuolo.ROLE_USER);
		rs.addRole(roleUser);

		return "Roles added";
	}

	@GetMapping("/protected")
	@PreAuthorize("hasRole('ADMIN')")
	public String metodoAuth1() {
		return "se stai vedendo questo sei un admin";
	}

	@GetMapping("/user/{username}")
	@PreAuthorize("hasRole('ADMIN')")
	public Utente getByUsername(@PathVariable("username") String username) {

		Optional<Utente> u = us.getByName(username);
		if (u.isPresent()) {
			return u.get();
		} else {
			return null;
		}
	}

	@GetMapping("/auth-info")
	@PreAuthorize("hasRole('ADMIN')")
	public String getAuthInfo() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			UserDetails u = ((UserDetails) principal);
			Utente user = us.getByName(u.getUsername()).get();
			return String.format("id:%d, email:%s, active:%b", user.getId(), user.getEmail(), user.getActive());
		}
		return "Utente non trovato";
	}
}