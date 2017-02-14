package org.harold.fsm.util;

public class FSMAppUtil {
	public static boolean hasChange(float fare, float money){
		if(money > fare)
			return true;
		return false;
	}
}
