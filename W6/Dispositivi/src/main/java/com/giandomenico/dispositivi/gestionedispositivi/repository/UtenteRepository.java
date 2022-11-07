package com.giandomenico.dispositivi.gestionedispositivi.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.giandomenico.dispositivi.gestionedispositivi.entities.Utente;


@Repository
public interface UtenteRepository extends PagingAndSortingRepository<Utente, Long>{

    @Query(
    	       "SELECT u FROM Utente u WHERE nome LIKE concat('%', :n, '%' ) AND cognome LIKE concat('%', :c, '%')"
    	    )
    	    Optional<Utente> findByNameAndLastName(@Param("n") String nome, @Param("c") String cognome);
    
    @Query(
 	       "SELECT u FROM Utente u WHERE username LIKE concat('%', :u, '%' )"
 	    )
 	    Optional<Utente> findByName(@Param("u") String u);
	
}