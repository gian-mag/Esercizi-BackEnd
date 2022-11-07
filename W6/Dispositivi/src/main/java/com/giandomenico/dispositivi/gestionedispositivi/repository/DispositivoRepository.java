package com.giandomenico.dispositivi.gestionedispositivi.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.giandomenico.dispositivi.gestionedispositivi.entities.Assegnamento;
import com.giandomenico.dispositivi.gestionedispositivi.entities.Dispositivo;
import com.giandomenico.dispositivi.gestionedispositivi.entities.Utente;


@Repository
@Transactional
public interface DispositivoRepository extends PagingAndSortingRepository<Dispositivo, Long>{

	@Modifying
	@Query(
 	       "UPDATE Dispositivo d SET d.utente = :u WHERE d.assegnazione = :ass AND d.id = :id"
 	    )
 	    void updateDevice(@Param("u") Utente u, @Param("ass") Assegnamento ass, @Param("id") Long id);
	
//	@Modifying
//	@Query( 
//			nativeQuery = true,
//			value = "UPDATE Dispositivo SET utente_id = :u WHERE assegnazione = :ass AND id = :id"
// 	    )
// 	    void updateDevice(@Param("u") Long u, @Param("ass") Assegnamento ass, @Param("id") Long id);
//	
	@Modifying
	@Query(
 	       "UPDATE Dispositivo d SET d.assegnazione = :ass WHERE d.id = :id"
 	    )
 	    void updateStatus(@Param("ass") Assegnamento ass, @Param("id") Long id);
}
