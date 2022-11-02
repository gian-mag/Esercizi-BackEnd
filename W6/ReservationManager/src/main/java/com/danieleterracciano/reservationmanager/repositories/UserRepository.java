package com.danieleterracciano.reservationmanager.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.danieleterracciano.reservationmanager.entities.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Integer>{

	
	
}
