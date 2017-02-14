package org.harold.fsm.util;

public class FSMAppUtil {
	public static boolean hasChange(float fare, float money){
		if(money > fare)
			return true;
		return false;
	}
	public static boolean hasNoMoney(float fare){
		if(fare == 0.0)
			return true;
		return false;
	}
}
