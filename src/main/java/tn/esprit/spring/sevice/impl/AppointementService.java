package tn.esprit.spring.sevice.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import tn.esprit.spring.repository.UserRepository;

import tn.esprit.spring.entity.Appointement;

import tn.esprit.spring.entity.Roles;
import tn.esprit.spring.entity.StatusApp;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.AppointementRepository;


@Service
public class AppointementService  implements IAppointementService {
	
	private static final int NUMBER_OF_CANCELATION_PER_MONTH = 3;
	

	@Autowired
	private AppointementRepository appointementRepository;
	
	@Autowired
	private UserRepository userRepository;


	
	
	@Override
	public void deleteAppointement(int id) {
		appointementRepository.deleteById(id);
	
	}

	
	public Appointement updateAppointement( Appointement app, int idApp) {
		Appointement a = appointementRepository.findById(idApp).get() ;
		appointementRepository.delete(a);
    	// a.setIdAppointement(app.getIdAppointement());
		return appointementRepository.save(app);
		 
		
	
	}

	
	public List<Appointement> getAllAppointement() {
		
		List<Appointement> appointements = (List<Appointement>) appointementRepository.findAll();
		List<Appointement> result =  new ArrayList<Appointement>();
		appointements.forEach(a ->result.add(a));
		return result;
	}

	@Override
	public Appointement getAppointementById(int id) {
	
		return appointementRepository.findById(id).get();
	}


	public ResponseEntity<?> createNewAppointement(long parentId, long kindergartenId, Appointement appointement) {
		
		
		List<Appointement> results = new ArrayList<>();
		results = (List<Appointement>) appointementRepository.findAll();

		
		
		try{
			for(int i=0 ; i<results.size();i++) {
				if(appointement.getStartDate()!=null) {
					if(appointement.getStartDate().isBefore(results.get(i).getStartDate())
				
							|| appointement.getStartDate().compareTo((results.get(i).getStartDate())) ==1
							) 
				
						return ResponseEntity.ok("appointement exist at : "+appointement.getStartDate());

	
				}	
								
			}
			User parent =userRepository.findById(parentId).get();

			// System.out.println("Role is  "+parent.getRole().getRoles());
			if(parent.getRole().getRoles().equals(Roles.Parent)) {
				
	 			appointement.setStatus(StatusApp.SCHEDULED);
	 			appointement.setCreatedAt(LocalDateTime.now());
	 			appointement.setUsers(userRepository.findByidUser(parent.getIdUser()));
				
				appointement.setKindergarten(userRepository.findDirectorKindergerten(kindergartenId));
				
				appointementRepository.save(appointement);
			
				return ResponseEntity.ok(" Meet created succesfully on:"+appointement.getStartDate()+", started at: "+appointement.getTime()+"\n parent affected is "
				+appointement.getUsers().getFirstName()+" and kindergarden director is "+appointement.getKindergarten().getUser().getFirstName()); 
				
			}	
			return ResponseEntity.ok("echec");
			
		}catch(NoSuchElementException e) {
			return ResponseEntity.ok("there is no parent with this Id ");
	
		}
	
	}


		public List<Appointement> getAppointementByParentId(int userId) {
			List<Appointement> appointement = (List<Appointement>) appointementRepository.findAll();
			List<Appointement>result = new ArrayList<>();
	
			for(Appointement a :appointement) {
				if(a.getUsers().getRole().getRoles().equals(Roles.Parent)) {
					result.add(a);
				}
			}
		return result;
	}

	
	public List<Appointement> getAppointementByKindergartenId(int kindergardenId) {
		return null;
	}


	public List<Appointement> getAppointementByKindergartenAtDay(int kindergartenId, String day) {
		
		System.out.println("kindergartenId"+kindergartenId);
		System.out.println("day "+day);
		LocalDate l = LocalDate.parse(day);
		
		System.out.println("localDate: "+l);
		
        return appointementRepository.getAppointementByKindergartenAtDay(kindergartenId, l);
	}



	
	public List<Appointement> getCanceledAppointementsByParentIdForCurrentMonth(int userId) {
		return null;
	}

	  @Override
	    public ResponseEntity<?>  cancelUserAppointmentById(int appointementId, int parentId) {
	        Appointement  appointement = appointementRepository.findById(appointementId).get();
			//Kindergarten kindergarten = userRepository.findDirectorKindergerten(parentIdOrKindergartenId);

			LocalDateTime localDateTime1 = appointement.getStartDate().atStartOfDay();
			User parent =userRepository.findParent(Roles.Parent,parentId);
			if (appointement.getUsers().equals(parent) ){
				
			
			if(appointement.getStatus().equals(StatusApp.CANCELED)) {
				return ResponseEntity.ok ("appointement already canceled ");}
			
			else if(LocalDateTime.now().plusDays(1).isAfter(localDateTime1)) {
				return ResponseEntity.ok("the appointement is programmed in less than 24 hours, it cannot be canceled");
				
			}
			
				
		      
			else 
	    
	        	{ appointement.setStatus(StatusApp.CANCELED);
	            User canceler = userRepository.findByidUser(parentId);
	            appointement.setCanceler(canceler);
	            appointement.setCanceledAt(LocalDateTime.now());
	            appointementRepository.save(appointement);
	           
	                
	            	return ResponseEntity.ok("Successfully canceled ! "); } }
	            
	        else {
	        	return ResponseEntity.ok("Unauthorized");
	        }
	  }

	    

	
	@Override
	public String getCancelNotAllowedReason(int parentId,int kindergardenId, int appointementId) {
		User parent = userRepository.findParent(Roles.Parent, parentId);
		Appointement appointement = appointementRepository.findById(appointementId).get();
	      LocalDateTime localDateTime1 = appointement.getStartDate().atStartOfDay();


		System.out.println("callll =="+LocalDateTime.now().plusDays(-1).toLocalDate());
		if(appointement.getUsers().equals(parent)) {
			if(appointement.getStatus().equals(StatusApp.SCHEDULED)) {
					return "cannot cancel meeting SCHEDULED";

				
			}
			
			
			else if(LocalDateTime.now().plusDays(-1).isAfter(localDateTime1)) {
				return "meeting which will be in less than 24 hours cannot be canceled";
				
			}
			
			else if(appointementRepository.findParentIdCanceledAfterDate(parentId,LocalDateTime.now()
					.with(TemporalAdjusters.firstDayOfMonth())).size() >= NUMBER_OF_CANCELATION_PER_MONTH){
				return "you exceeded maximum number of cancelations per month";
			}
			
			 
		
		}
		
			
		return null;
	}


	
	public int CountAppointement(int kindergartenId, String day) {
		List <Appointement> app =(List<Appointement>) getAppointementByKindergartenAtDay(kindergartenId, day);
		return app.size();
	}


	@Override
	public List<Appointement> getAppointementByCustomerAtDay(int kindergartenId, LocalDate day) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Appointement> getConfirmedAppointementByParentId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}


	
	 

	}



