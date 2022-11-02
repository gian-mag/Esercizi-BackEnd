package com.danieleterracciano.reservationmanager.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.danieleterracciano.reservationmanager.entities.Reservation;

@Repository
public interface ReservationRepository extends PagingAndSortingRepository<Reservation, Integer>{

}
