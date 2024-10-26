package com.hc.rediagerplus.genericutility;

import java.io.IOException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class is used to get all the run time events of the test scripts and to
 * configure extentReport
 * 
 * @author Priyanka
 */
public class ListImpClass implements ITestListener, ISuiteListener {
	ExtentReports report;
	public static ExtentTest test;

	JavaUtility jLib = new JavaUtility();

	/**
	 * This method is executed when the test starts
	 */
	@Override
	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.PASS, result.getMethod().getMethodName() + " is started");
	}

	/**
	 * This method is executed when the test gets success
	 */
	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName() + " is success");
	}

	/**
	 * This method is executed when the test got failure and take the screenshot
	 */
	@Override
	public void onTestFailure(ITestResult result) {
		String testname = result.getMethod().getMethodName();

		WebDriverUtility wLib = new WebDriverUtility();
		String path;
		try {
			path = wLib.takesScreenshot(Baseclass.sdriver, testname + "_" + jLib.getSystemDate() + ".png");
			test.addScreenCaptureFromBase64String(path, testname + "_" + jLib.getSystemDate() + ".png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.log(Status.FAIL, result.getMethod().getMethodName() + " is failed");
	}

	/**
	 * This method is executed when the test got skipped
	 */
	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName() + " is skipped");
		test.log(Status.SKIP, result.getThrowable());
	}

	/**
	 * This method is executed during the starting of the execution and configure
	 * the extent reports
	 */
	@Override
	public void onStart(ISuite suite) {
		ExtentSparkReporter spark = new ExtentSparkReporter(
				"./AdvancedReport/report_" + jLib.getSystemDate() + ".html");
		spark.config().setDocumentTitle("Healthcare_Project");
		spark.config().setReportName("Healthcare_testResults");
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Browser", "chrome");
		report.setSystemInfo("OS", "Windows 11");
	}

	/**
	 * This method is executed in order to save the report
	 */
	@Override
	public void onFinish(ISuite suite) {
		report.flush();
	}

}
