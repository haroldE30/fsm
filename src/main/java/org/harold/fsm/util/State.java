package org.harold.fsm.util;

public enum State {
	WAITING_FOR_JEEPNEY(0),
	WAITING_TO_PAY(1),
	WAITING_FOR_CHANGE(2),
	CHANGE_RESOLUTION(3),
	RIDING_JEEPNEY(4),
	WAITING_TO_STOP(5),
	GET_OFF(6);
	
	private int state;
	private State(int state){
		this.state = state;
	}

	public int getState(){
		return state;
	}
}
