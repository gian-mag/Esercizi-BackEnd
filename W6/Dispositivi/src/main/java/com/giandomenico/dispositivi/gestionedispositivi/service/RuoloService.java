package com.giandomenico.dispositivi.gestionedispositivi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giandomenico.dispositivi.gestionedispositivi.entities.Ruolo;
import com.giandomenico.dispositivi.gestionedispositivi.repository.RuoloRepository;


@Service
public class RuoloService {

    @Autowired
    RuoloRepository rr;

    public void addRole(Ruolo r) {
        rr.save(r);
    }
    public Optional<Ruolo> getById(Long id) {
        return rr.findById(id);
    }
}
