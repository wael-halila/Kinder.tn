package tn.esprit.spring.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Appointement;
import tn.esprit.spring.entity.Kindergarten;
import tn.esprit.spring.entity.User;

@Repository
public interface AppointementRepository extends CrudRepository<Appointement,Integer>{

	
	@Query("SELECT a FROM Appointement a WHERE a.users.idUser =:userId and a.canceler.idUser =:userId and a.canceledAt >= :date ")
	List<Appointement>findParentIdCanceledAfterDate(@Param("userId")int userId,@Param("date")LocalDateTime date);
	
	
	@Query("SELECT a.users FROM   Appointement a  WHERE a.users.idUser =:userId")
   	User findParentAppointement(@Param("userId")int userId);
	
	

	@Query("SELECT a.users FROM   Appointement a  WHERE a.users.idUser =:userId")
   	User findKindergartenDirectorAppointement(@Param("userId")int userId);

	@Query("SELECT a.kindergarten FROM   Appointement a  WHERE a.kindergarten.id =:idkinder")
   	Kindergarten findKindergarten(@Param("idkinder")int idkinder);

	

	

	User findByUsers(User idUser);
	
	@Query("SELECT a FROM Appointement a WHERE a.id =:id ")
	Appointement findAppointement(@Param("id") int id);

 @Query("select a from Appointement a where a.kindergarten.id = :idUser and  a.startDate =:dayStart")
	    List<Appointement> getAppointementByKindergartenAtDay(@Param("idUser") int providerId, @Param("dayStart") LocalDate localDateTime);


 
}
