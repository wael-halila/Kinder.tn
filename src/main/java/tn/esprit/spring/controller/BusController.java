package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.KindergartenBus;
import tn.esprit.spring.sevice.impl.BusService;


@RestController
@RequestMapping("/bus")
public class BusController {
	
	@Autowired
	private BusService busService;
	
	
	//http://localhost:8081/SpringMVC/servlet/bus/getBus
	
	 @GetMapping("/getBus")
	    public List<KindergartenBus> showNewDrivereForm() {
	        return busService.getAllBus();
	    }
	
	
	// http://localhost:8081/SpringMVC/servlet/bus/saveBus/{idDriver}/{idU}
	
	 @PostMapping("/saveBus/{idDriver}/{idU}")
		public KindergartenBus AffectBusDriver(@RequestBody KindergartenBus bus, @PathVariable("idDriver")int idDriver,@PathVariable("idU")int idU)   
		{  
			 
			return busService.AffectBusDriver(bus, idDriver,idU);
		}
	 
	//http://localhost:8081/SpringMVC/servlet/bus/deleteBus/{id}

		@DeleteMapping("/deleteBus/{id}")
		public void deleteDriver(@PathVariable("id") int id) {
			busService.deleteBusById(id);
		}
	//http://localhost:8081/SpringMVC/servlet/bus/updateBus/1

		@PutMapping("/updateBus/{idBus}")  
		public KindergartenBus updateBus(@RequestBody KindergartenBus bus, @PathVariable("idBus")int idBus)   
		{  
		
			busService.updateBus(bus, idBus) ;
			return bus;  
		} 
	//http://localhost:8081/SpringMVC/servlet/bus/getBusByDriver/{firstName}

		@GetMapping("/getBusByDriver/{firstName}")
		public List<KindergartenBus> getBusByDriver(@PathVariable String firstName) {
			 List<KindergartenBus> bus = busService.getBusByDriver(firstName);
			return bus;
			}
		
}
