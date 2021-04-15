package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.BusDriver;
import tn.esprit.spring.sevice.impl.BusDriverService;


@RestController

@RequestMapping("/driver")
public class BusDriverController {
	
	
	@Autowired
	private BusDriverService driverservice;
	
	
//	http://localhost:8081/SpringMVC/servlet/driver/getDriver
	
	 @GetMapping("/getDriver")
	    public List<BusDriver>showDriver() {
	        return driverservice.getAllDriver();
	    }
	 
	
	//http://localhost:8081/SpringMVC/servlet/driver/saveDriver

	@PostMapping("/saveDriver")
	public String saveDriver(@RequestBody BusDriver driver)   
		{  
			driverservice.saveDriver(driver);  
			return "add successfuly";
		}
	 
	
	//http://localhost:8081/SpringMVC/servlet/driver/deleteDriver/1
	@RequestMapping(value = "/deleteDriver/{id}", method = RequestMethod.DELETE)
	     void deleteDriver(@PathVariable int id) {

		  driverservice.deleteDrivereById(id);
           
	}
	
//	http://localhost:8081/SpringMVC/servlet/driver/updatedriver/2
	
	@PutMapping("/updatedriver/{idDriver}")
	public BusDriver updateDriver(@RequestBody BusDriver driver, @PathVariable("idDriver")int idDriver) {

		return driverservice.updateDriver(driver,idDriver);
	 
	}
	//http://localhost:8081/SpringMVC/servlet/driver/showbyid/2
	
	@GetMapping("/showbyid/{id}")
    public BusDriver showbyid(@PathVariable int id) {
        return driverservice.getDriverById(id);
    }

	
	

}
