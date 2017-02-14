package org.harold.fsm.model;

import java.io.Serializable;

public class Passenger implements Serializable{
	private static final long serialVersionUID = -2508184191091968095L;
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
