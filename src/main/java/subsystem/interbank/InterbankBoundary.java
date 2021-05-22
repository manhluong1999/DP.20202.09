package subsystem.interbank;

import common.exception.UnrecognizedException;
import utils.ApplicationProgrammingInterface;


/*
 * Date: 22/05/2021
 * Author: Minh
 * Subject: DesignPattern - Singleton
 * Reason: Nên áp dụng singleton
 * */

public class InterbankBoundary {

	String query(String url, String data) {
		String response = null;
		try {
			response = ApplicationProgrammingInterface.post(url, data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new UnrecognizedException();
		}
		return response;
	}

}
