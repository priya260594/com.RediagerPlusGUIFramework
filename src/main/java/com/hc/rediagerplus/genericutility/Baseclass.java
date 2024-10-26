package com.hc.rediagerplus.genericutility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

/**
 * This class contains all the preconditions and postconditions to handle the
 * test scripts
 * 
 * @author Priyanka
 */
public class Baseclass {

	public JavaUtility jLib = new JavaUtility();
	public DatabaseUtility dLib = new DatabaseUtility();
	public PropertyFileUtility pLib = new PropertyFileUtility();
	public ExcelFileUtility eLib = new ExcelFileUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver = null;

	/**
	 * This method will execute before the suite
	 * 
	 * @throws Throwable
	 */
	@BeforeSuite
	public void configbs() throws Throwable {
		// dLib.getConnection();
		System.out.println("Database connected");
	}

	/**
	 * This method will execute before the class tag
	 * 
	 * @throws IOException
	 */
	@BeforeClass
	public void configbc() throws IOException {
		String BROWSER = pLib.getDataFromPropertyFile("browser");
		String URL = pLib.getDataFromPropertyFile("url");

		System.out.println(BROWSER + " browser is launched");
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new FirefoxDriver();
		}
		sdriver = driver;
		driver.get(URL);
		wLib.waitForPageToLoad(driver, 30);
		wLib.maximizeWindow(driver);
	}

	/**
	 * This method will execute after the close of class tag
	 */
	@AfterClass
	public void configac() {
		driver.quit();
		System.out.println("browser closed");
	}

	/**
	 * This method will execute after the close of suite tag
	 * 
	 * @throws Throwable
	 */
	@AfterSuite
	public void configas() throws Throwable {
		// dLib.closeConnection();
		System.out.println("Database disconnected");

	}
}
