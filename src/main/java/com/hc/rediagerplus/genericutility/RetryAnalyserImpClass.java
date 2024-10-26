package com.hc.rediagerplus.genericutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class is used to run the particular test script for some count and pass
 * the script
 * 
 * @author Priyanka
 */
public class RetryAnalyserImpClass implements IRetryAnalyzer {
	int count = 0;
	int limitCount = 5;

	public boolean retry(ITestResult result) {

		if (count < limitCount) {
			count++;
			return true;
		}
		return false;
	}
}
