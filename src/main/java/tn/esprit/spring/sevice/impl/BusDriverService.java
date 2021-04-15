package tn.esprit.spring.sevice.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.BusDriver;

import tn.esprit.spring.repository.BusDriverRepository;


@Service
@Transactional
public class BusDriverService implements IBusDriverService{


	
	@Autowired
	private BusDriverRepository driverRepository;

	
	 public List<BusDriver> getAllDriver() {
	        return driverRepository.findAll();
	    }

	
	@Override
	public BusDriver saveDriver(BusDriver driver) {
		return driverRepository.save(driver);
		
	}

	@Override
	public BusDriver getDriverById(int id) {
		return driverRepository.findById(id).get();
	}

	@Override
	public void deleteDrivereById(int id) {
		driverRepository.deleteById(id);
		
	}
	
	 
		public BusDriver updateDriver (BusDriver driver, int idDriver) {
			// TODO Auto-generated method stub
	    	BusDriver drivers =driverRepository.findById(idDriver).get();
	    	drivers.setAddress(driver.getAddress());
	    	drivers.setFirstName(driver.getFirstName());
	    	drivers.setLastName(driver.getLastName());
	    	drivers.setTelNum(driver.getTelNum());
	    	    	
			return driverRepository.save(drivers);
		}


		


	


	
	
}
