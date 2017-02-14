package org.harold.fsm;

import junit.framework.TestCase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.harold.fsm.model.Passenger;
import org.harold.fsm.model.Vehicle;
import org.harold.fsm.service.PassengerService;
import org.harold.fsm.service.VehicleService;
import org.harold.fsm.service.impl.PassengerServiceImpl;
import org.harold.fsm.service.impl.VehicleServiceImpl;

public class FSMAppTest extends TestCase {
	
	private static final Logger log = LogManager.getLogger(FSMAppTest.class);
	
	private PassengerService passengerService;
	private VehicleService vehicleService;

	protected void setUp() throws Exception {
		passengerService = new PassengerServiceImpl();
		vehicleService = new VehicleServiceImpl();
	}

	protected void tearDown() throws Exception {
		passengerService = null;
		vehicleService = null;
	}
	
	public void testPassenger1() throws Exception{
		Passenger passenger = createPassenger();
		Vehicle vehicle = createVehicle();
		
		FSMApp app = new FSMApp();
		log.info("\n\nStarting app...");
		log.info("Passenger will now commute from " + vehicle.getRoute());
		app.commute(vehicle, passenger, 10.0f);
	}
	
	public void testPassenger2() throws Exception{
		Passenger passenger = createPassenger();
		Vehicle vehicle1 = createVehicle1();
		
		FSMApp app = new FSMApp();
		log.info("\n\nStarting app...");
		log.info("Passenger will now commute from " + vehicle1.getRoute());
		app.commute(vehicle1, passenger, 8.0f);
	}

	private Passenger createPassenger() throws Exception{
		log.info("Creating passenger record...");
		Passenger passenger = new Passenger();
		Long id = passengerService.save(passenger);
		passenger.setId(id);
		return passenger;
	}
	
	private Vehicle createVehicle() throws Exception{
		log.info("Creating vehicle record...");
		Vehicle vehicle = new Vehicle();
		vehicle.setCode("14D");
		vehicle.setRoute("Manalili to Ayala");
		vehicle.setFare(8.0f);
		
		Long id = vehicleService.save(vehicle);
		vehicle.setId(id);
		
		return vehicle;
	}
	
	private Vehicle createVehicle1() throws Exception{
		log.info("Creating vehicle record...");
		Vehicle vehicle = new Vehicle();
		vehicle.setCode("12G");
		vehicle.setRoute("Labangon to SM");
		vehicle.setFare(8.0f);
		
		Long id = vehicleService.save(vehicle);
		vehicle.setId(id);
		
		return vehicle;
	} 
}
