package tn.esprit.spring.sevice.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;

import tn.esprit.spring.entity.Appointement;

public interface IAppointementService {

	//void createNewAppointment(int parentId, int kindergardenId, int customerId, LocalDateTime start);

    public ResponseEntity<?> createNewAppointement( long parentId, long kindergartenId, Appointement appointement);
  	
    public void deleteAppointement(int id);
	
    public Appointement updateAppointement(  Appointement ap, int idApp);
	
    public List<Appointement> getAllAppointement();
	
    public Appointement getAppointementById(int id);
    
    List<Appointement> getAppointementByParentId(int userId);

    List<Appointement> getAppointementByKindergartenId(int kindergartenId);

    List<Appointement> getAppointementByKindergartenAtDay(int kindergartenId, String day);

    List<Appointement> getAppointementByCustomerAtDay(int kindergartenId, LocalDate day);

    List<Appointement> getConfirmedAppointementByParentId(int userId);

    List<Appointement> getCanceledAppointementsByParentIdForCurrentMonth(int userId);


	String getCancelNotAllowedReason(int parentId, int kindergardenId, int meetingId);

	 
	ResponseEntity<?>  cancelUserAppointmentById(int appointmentId, int userId);
	//public List<Appointement> getAppointementByKindergartenDirectorAtDay(int providerId, LocalDate day) ;
	public int CountAppointement(int kindergartenId, String day);
	
}
