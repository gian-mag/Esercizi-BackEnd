package com.giandomenico.dispositivi.gestionedispositivi.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.giandomenico.dispositivi.gestionedispositivi.entities.Ruolo;

@Repository
public interface RuoloRepository extends PagingAndSortingRepository<Ruolo, Long> {

}
