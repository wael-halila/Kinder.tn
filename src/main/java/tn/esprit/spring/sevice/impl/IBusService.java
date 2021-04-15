package tn.esprit.spring.sevice.impl;

import java.util.List;


import tn.esprit.spring.entity.KindergartenBus;





public interface IBusService {
	List<KindergartenBus> getAllBus();
	
	KindergartenBus  AffectBusDriver(KindergartenBus bus,int idDriver,long idU);
	KindergartenBus getBusById(int id);
	void deleteBusById(int id);
	KindergartenBus updateBus(KindergartenBus bus, int id);
	List<KindergartenBus> getBusByDriver(String D);
	
}
