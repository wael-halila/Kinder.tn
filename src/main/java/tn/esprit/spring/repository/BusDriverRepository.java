package tn.esprit.spring.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.BusDriver;


@Repository
public interface BusDriverRepository extends JpaRepository<BusDriver, Integer>{
	
	

}
