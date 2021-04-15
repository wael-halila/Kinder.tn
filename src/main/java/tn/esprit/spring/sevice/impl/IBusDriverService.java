package tn.esprit.spring.sevice.impl;

import java.util.List;


import tn.esprit.spring.entity.BusDriver;


public interface IBusDriverService {

	
List<BusDriver> getAllDriver();
	BusDriver saveDriver(BusDriver driver);
BusDriver getDriverById(int id);
void deleteDrivereById(int id);
public BusDriver updateDriver(BusDriver driver, int id);
}
