package tn.esprit.spring.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.BusDriver;
import tn.esprit.spring.entity.KindergartenBus;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.BusDriverRepository;
import tn.esprit.spring.repository.BusRepository;

import tn.esprit.spring.repository.UserRepository;



@Service
public class BusService implements IBusService {


	@Autowired
	private BusRepository  busRepository;
	@Autowired
	private BusDriverRepository driverRepository;
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<KindergartenBus> getAllBus() {
		// TODO Auto-generated method stub
		 return busRepository.findAll();
	}

	@Override
	 public KindergartenBus AffectBusDriver(KindergartenBus bus, int idDriver, long idU) {
		// TODO Auto-generated method stub
		BusDriver driver =driverRepository.findById(idDriver).get();
		User user=userRepository.findById(idU).get();
		bus.setDriver(driver);
		bus.setUser(user);
		busRepository.save(bus);
		return bus; 
		
	}

	@Override
	public KindergartenBus getBusById(int id) {
		// TODO Auto-generated method stub
		return busRepository.findById(id).get();
	}

	@Override
	public void deleteBusById(int id) {
		busRepository.deleteById(id);		
	}

	@Override
	public KindergartenBus updateBus(KindergartenBus bus, int id) {
		KindergartenBus b=busRepository.findById(id).get();
	//	Driver driver =driverRepository.findById(idDriver).get();
		//User user=userRepository.findById(idU).get();
		b.setCapacity(bus.getCapacity());
		b.setDisponible(bus.getDisponible());
		b.setDeparture(bus.getDeparture());
		b.setDestination(bus.getDestination());
		b.setDriver(bus.getDriver());
		b.setUser(bus.getUser());
		b.setChildren(bus.getChildren());
		b.setTimeA(bus.getTimeA());
		b.setTimeDep(bus.getTimeDep());
		
		
		return busRepository.save(b);
	}
	
	@Override
	public List<KindergartenBus> getBusByDriver(String D) {
		
		return busRepository.getBusByDriver(D);
	}
	 

}
