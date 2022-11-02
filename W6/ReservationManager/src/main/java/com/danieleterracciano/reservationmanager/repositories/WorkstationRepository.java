package com.danieleterracciano.reservationmanager.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.danieleterracciano.reservationmanager.entities.Workstation;
import com.danieleterracciano.reservationmanager.entities.WorkstationType;

@Repository
public interface WorkstationRepository extends PagingAndSortingRepository<Workstation, Integer> {

	@Query(nativeQuery = true, value = "SELECT * FROM workstations WHERE WStype = :t AND city IN (SELECT city FROM buildings WHERE city = :c)")
	public Page<Workstation> findWorkstationsByCityAndWSType(@Param("c") String city, @Param("t") WorkstationType t,
			Pageable p);

	@Query(value = "SELECT u FROM Workstation u WHERE u.WSType = :t")
	public Page<Workstation> findWorkstationByWSType(@Param("t") WorkstationType t, Pageable p);

}
