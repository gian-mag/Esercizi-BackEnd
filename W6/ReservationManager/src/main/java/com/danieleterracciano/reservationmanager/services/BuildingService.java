package com.danieleterracciano.reservationmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.danieleterracciano.reservationmanager.entities.Building;
import com.danieleterracciano.reservationmanager.repositories.BuildingRepository;

@Service
public class BuildingService {

	@Autowired
	BuildingRepository br;
	
	public void saveBuilding(Building b) {
		br.save(b);
	}
	
	public Optional<Building> getBuildingById(int id) {
		return br.findById(id);
	}
	
	public Page<Building> getAllBuildings(Pageable p){
		return br.findAll(p);
	}
	
	public Page<Building> getAllAndPaginate(Pageable p){
		return br.findAll(p);
	}
	
	public void deleteBuildingById(int id) {
		br.deleteById(id);
	}
	
	public Page<Building> getBuildingByCity(String c, Pageable p){
		return br.findBuildingByCity(c, p);
	}
}
