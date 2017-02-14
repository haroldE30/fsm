package org.harold.fsm.model;

import java.io.Serializable;

public class Commute implements Serializable{
	private static final long serialVersionUID = 6699035865376371476L;
	private Long id;
	private Long vehicleId;
	private Long passengerId;
	private String state;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getVehicleId() {
		return vehicleId;
	}
	
	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}
	
	public Long getPassengerId() {
		return passengerId;
	}
	
	public void setPassengerId(Long passengerId) {
		this.passengerId = passengerId;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
}
