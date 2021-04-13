package tn.esprit.spring.repository;



import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Score;

public interface ScoreRepository extends CrudRepository<Score, Integer> {


	
	@Query("SELECT s FROM Score s WHERE s.child.idKid =:idKid")
	Score getScoreByIdkid(@Param("idKid")int idKid);
	
	
	
	@Modifying
	@Query("Update Score s Set s.score=:valeur where s.id =:id")
	void updateScoreById(@Param("valeur")int valeur,@Param("id")int id);
	
	

	

}
