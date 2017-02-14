package org.harold.fsm.model;

import java.io.Serializable;

public class Vehicle implements Serializable{
	private static final long serialVersionUID = -1229628786219324789L;
	private Long id;
	private String code;
	private String route;
	private Float fare;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public Float getFare() {
		return fare;
	}

	public void setFare(Float fare) {
		this.fare = fare;
	}
}
