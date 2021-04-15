package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.KindergartenBus;
@Repository
public interface BusRepository extends JpaRepository<KindergartenBus, Integer> {
	
	@Query("SELECT b FROM KindergartenBus b WHERE b.driver.firstName =:firstName")
	public List<KindergartenBus> getBusByDriver(@Param("firstName")String D);

}
