package com.giandomenico.dispositivi.gestionedispositivi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.giandomenico.dispositivi.gestionedispositivi.entities.Assegnamento;
import com.giandomenico.dispositivi.gestionedispositivi.entities.Dispositivo;
import com.giandomenico.dispositivi.gestionedispositivi.entities.Utente;
import com.giandomenico.dispositivi.gestionedispositivi.repository.DispositivoRepository;

@Service
public class DispositivoService {

	@Autowired
	DispositivoRepository dr;
	
	public void saveDevice(Dispositivo u) {
		dr.save(u);
	}
	
	public void deleteDeviceById(Long id) {
		dr.deleteById(id);
	}
	
	public Optional<Dispositivo> getDeviceById(Long id) {
		return dr.findById(id);
	}
	
	public Page<Dispositivo> getAllDevices(Pageable p){
		return dr.findAll(p);
	}
	
	public Page<Dispositivo> getAllAndPaginate(Pageable p){
		return dr.findAll(p);
	}
	
	public void updateDeviceByUser(Utente u, Assegnamento a, Long id) {
		dr.updateDevice(u, a, id);
	}
	
	public void updateDeviceStatus(Assegnamento a, Long id) {
		dr.updateStatus(a, id);
	}
	
}
