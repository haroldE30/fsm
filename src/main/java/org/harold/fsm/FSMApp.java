package org.harold.fsm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.harold.fsm.model.Commute;
import org.harold.fsm.model.Passenger;
import org.harold.fsm.model.Vehicle;
import org.harold.fsm.service.CommuteService;
import org.harold.fsm.service.PassengerService;
import org.harold.fsm.service.VehicleService;
import org.harold.fsm.service.impl.CommuteServiceImpl;
import org.harold.fsm.service.impl.PassengerServiceImpl;
import org.harold.fsm.service.impl.VehicleServiceImpl;
import org.harold.fsm.util.FSMAppUtil;
import org.harold.fsm.util.State;

public class FSMApp {
	
	private static final Logger log = LogManager.getLogger(FSMApp.class);
	
	private VehicleService vehicleService;
	private PassengerService passengerService;
	private CommuteService commuteService;
	
	public FSMApp(){
		setVehicleService(new VehicleServiceImpl());
		setPassengerService(new PassengerServiceImpl());
		setCommuteService(new CommuteServiceImpl());
	}
	
	public void commute(Vehicle vehicle, Passenger passenger, float fare){
		int state = State.WAITING_FOR_JEEPNEY.getState();
		boolean arrive = false;
		while(!arrive){
			State currentState = State.values()[state];
			switch(currentState){
			case WAITING_FOR_JEEPNEY:{
				log.info("Waiting for Jeepney.");
				saveCommute(createCommute(vehicle, passenger, "WAITING_FOR_JEEPNEY"));
				log.info("Passenger board a jeepney.");
				state = State.WAITING_TO_PAY.getState();
				break;
			}
			case WAITING_TO_PAY:{
				log.info("Waiting to Pay.");
				saveCommute(createCommute(vehicle, passenger, "WAITING_TO_PAY"));
				log.info("Passenger pass the money.");
				state = State.WAITING_FOR_CHANGE.getState();
				break;
			}
			case WAITING_FOR_CHANGE:{
				log.info("Waiting for Change.");
				saveCommute(createCommute(vehicle, passenger, "WAITING_FOR_CHANGE"));
				if(FSMAppUtil.hasChange(vehicle.getFare(), fare)){
					log.info("Receive Change.");
					state = State.RIDING_JEEPNEY.getState();
				}else{
					log.info("No Change.");
					state = State.CHANGE_RESOLUTION.getState();
				}
				break;
			}
			case CHANGE_RESOLUTION:{
				log.info("Change Resolution.");
				saveCommute(createCommute(vehicle, passenger, "CHANGE_RESOLUTION"));
				log.info("Resolve.");
				state = State.WAITING_TO_STOP.getState();
				break;
			}
			case RIDING_JEEPNEY:{
				log.info("Riding Jeepney.");
				saveCommute(createCommute(vehicle, passenger, "RIDING_JEEPNEY"));
				log.info("Click coin on roof.");
				state = State.WAITING_TO_STOP.getState();
				break;
			}
			case WAITING_TO_STOP:{
				log.info("Waiting to stop.");
				saveCommute(createCommute(vehicle, passenger, "WAITING_TO_STOP"));
				log.info("Get Off");
				state = State.GET_OFF.getState();
				break;
			}
			case GET_OFF:
				arrive = true;
				break;
			}
		}
	}
	
	private Commute createCommute(Vehicle vehicle, Passenger passenger, String state){
		Commute commute = new Commute();
		commute.setVehicleId(vehicle.getId());
		commute.setPassengerId(passenger.getId());
		commute.setState(state);
		return commute;
	}
	
	private void saveCommute(Commute commute) {
		try{
			log.info("Saving passenger " + commute.getPassengerId() + 
					" using vehicle " + commute.getVehicleId() +
					" when " + commute.getState());
			commuteService.persist(commute);
		}catch(Exception e){
			log.error("Problem saving commute for passenger " 
					+ commute.getPassengerId() + 
					" using vehicle " + commute.getVehicleId() +
					" when " + commute.getState());
		}
	}
	
	public VehicleService getVehicleService() {
		return vehicleService;
	}

	public void setVehicleService(VehicleService vehicleService) {
		this.vehicleService = vehicleService;
	}

	public PassengerService getPassengerService() {
		return passengerService;
	}

	public void setPassengerService(PassengerService passengerService) {
		this.passengerService = passengerService;
	}

	public CommuteService getCommuteService() {
		return commuteService;
	}

	public void setCommuteService(CommuteService commuteService) {
		this.commuteService = commuteService;
	}
}
