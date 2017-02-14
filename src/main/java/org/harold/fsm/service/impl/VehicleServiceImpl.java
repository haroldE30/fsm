package org.harold.fsm.service.impl;

import org.harold.fsm.dao.VehicleDao;
import org.harold.fsm.dao.impl.VehicleDaoImpl;
import org.harold.fsm.model.Vehicle;
import org.harold.fsm.service.VehicleService;

public class VehicleServiceImpl implements VehicleService {
	
	private VehicleDao vehicleDao;
	
	public VehicleServiceImpl(){
		setVehicleDao(new VehicleDaoImpl());
	}

	@Override
	public Long save(Vehicle vehicle){
		return (Long) vehicleDao.save(vehicle);
	}

	public void setVehicleDao(VehicleDao vehicleDao){
		this.vehicleDao = vehicleDao;
	}
}
