package org.harold.fsm.service.impl;

import org.harold.fsm.dao.PassengerDao;
import org.harold.fsm.dao.impl.PassengerDaoImpl;
import org.harold.fsm.model.Passenger;
import org.harold.fsm.service.PassengerService;

public class PassengerServiceImpl implements PassengerService {
	
	private PassengerDao passengerDao;
	
	public PassengerServiceImpl(){
		setPassengerDao(new PassengerDaoImpl());
	}

	@Override
	public Long save(Passenger passenger){
		return (Long) passengerDao.save(passenger);
	}
	
	public void setPassengerDao(PassengerDao passengerDao){
		this.passengerDao = passengerDao;
	}
}
