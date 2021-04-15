package tn.esprit.spring.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Appointement;
import tn.esprit.spring.sevice.impl.AppointementService;



@RestController
public class AppointementController {

	@Autowired
	AppointementService appointementService;
	
	
	//te5dem
	@PostMapping("/appointements/create-appointement/{parentId}/{kindergartenId}")  
	@ResponseBody
	private ResponseEntity<?> addAppointement(@RequestBody Appointement a ,@PathVariable("parentId")int parentId,@PathVariable("kindergartenId")int kindergartenId) throws ParseException   
	{ 
		 return appointementService.createNewAppointement(parentId, kindergartenId, a);

	}

			@DeleteMapping("/appointements/delete-appointement/{appId}")  
			private void deleteAppointement(@PathVariable("appId") int appId)   
			{  
				appointementService.deleteAppointement(appId); 
			}
   
			
			//te5dem
			@PutMapping("/appointement/update-appointement/{ida}")  
			private Appointement updateAppointement(@RequestBody Appointement app, @PathVariable("ida")int idAppointement)   
			{  
				return appointementService.updateAppointement(  app, idAppointement); 
			}
			
			
	//te5dem  
			@GetMapping("/appointements/get-all-appointement")  
			private List<Appointement> getAllApp()   
			{  
				return appointementService.getAllAppointement(); 
			}
	//te5edem
			@GetMapping("/appointement/detail-appointement/{ida}")  
			private Appointement getAppointement(@PathVariable("ida") int idApp)   
			{  
				return appointementService.getAppointementById(idApp);
			} 
	

			
			//te5dem
			@GetMapping("/appointement/{kd}/{d}") 
			private List<Appointement> getAppointementByKindergartenAtDay(@PathVariable("kd") int kindergartenId ,@PathVariable("d") String day)
          { 
				
        		  return appointementService.getAppointementByKindergartenAtDay(kindergartenId,day);
        		  }
   
			
			//te5dem 
			@GetMapping("/appointementt/{parentId}")
			public List<Appointement> getAppointementByParentId(@PathVariable("parentId") int userId ){
				return appointementService.getAppointementByParentId(userId);
			}

			
			//te5dem
			@PutMapping("/appointement/{ad}/{pk}")
			public ResponseEntity<?>  cancelUserAppointmentById(@PathVariable("ad") int appointementId, @PathVariable("pk") int parentIdOrKindergartenId) {
				return appointementService. cancelUserAppointmentById(appointementId,parentIdOrKindergartenId);
			}
			
			
			
			
			
			//te5dem
			@GetMapping("/countAppointement/{kd}/{d}") 
			public int CountAppointement(@PathVariable("kd") int kindergartenId ,@PathVariable("d") String day)
          { 
				
        		  return appointementService.CountAppointement(kindergartenId,day);}
}


