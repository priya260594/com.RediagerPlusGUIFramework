package com.hc.rediagerplus.genericutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * This class contains the generic methods related to java program
 */
public class JavaUtility {
	/**
	 * This method gets the random number
	 * 
	 * @return
	 */
	public int getRandomNumber() {
		Random ran = new Random();
		int randomNo = ran.nextInt(200);
		return randomNo;
	}

	/**
	 * This method gives the required date in format
	 * 
	 * @param days
	 * @return
	 */
	public String getRequiredDate(int days) {
		Date d = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("MM-yyyy-dd");
		sim.format(d);
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqDate = sim.format(cal.getTime());
		return reqDate;
	}

	/**
	 * This method give the system Date
	 * 
	 * @return
	 */

	public String getSystemDate() {
		String dobj = new Date().toString().replace(":", "_").replace(" ", "_");
		return dobj;
	}
}
