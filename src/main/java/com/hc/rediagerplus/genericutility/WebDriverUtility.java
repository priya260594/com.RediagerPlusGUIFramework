package com.hc.rediagerplus.genericutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains webdriver related generic methods
 * 
 * @author Priyanka
 */
public class WebDriverUtility {

	/**
	 * This generic method can maximize the window
	 * 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This generic method can scroll to end
	 * 
	 * @param driver
	 */
	public void scrolltoEnd(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");

	}

	/**
	 * This generic method can confirm the alert
	 * 
	 * @param driver
	 */
	public void confirmAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * This generic method is to get the alert text
	 * 
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	/**
	 * This generic method is used to get the select using visible text
	 * 
	 * @param element
	 * @param text
	 */
	public void selectByText(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	/**
	 * This generic method is used to get the list of drop down text
	 * 
	 * @param element
	 * @return
	 */
	public List<WebElement> getListFromDropdown(WebElement element) {
		Select sel = new Select(element);
		List<WebElement> options = sel.getOptions();
		return options;
	}

	/**
	 * This generic method is used to switch between the window
	 * 
	 * @param driver
	 * @param partialUrl
	 */
	public void switchToWindow(WebDriver driver, String partialUrl) {
		Set<String> winIds = driver.getWindowHandles();
		Iterator<String> it = winIds.iterator();
		while (it.hasNext()) {
			String winId = it.next();
			driver.switchTo().window(winId);
			if (driver.getCurrentUrl().contains(partialUrl)) {
				break;
			}
		}
	}

	/**
	 * This generic method is used to wait until the page gets load
	 * 
	 * @param driver
	 * @param durationInSeconds
	 */
	public void waitForPageToLoad(WebDriver driver, int durationInSeconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(durationInSeconds));
	}

	/**
	 * This generic method is used to wait until the element is visible
	 * 
	 * @param driver
	 * @param durationInSeconds
	 * @param element
	 */
	public void waitForElementToVisible(WebDriver driver, int durationInSeconds, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This generic method is used to wait until the element is clickable
	 * 
	 * @param driver
	 * @param durationInSeconds
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, int durationInSeconds, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This generic method is used to wait until the alert is present
	 * 
	 * @param driver
	 * @param durationInSeconds
	 */
	public void waitForAlertToPresent(WebDriver driver, int durationInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	/**
	 * This generic method is used to take the screenshot
	 * 
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
	public String takesScreenshot(WebDriver driver, String screenshotName) throws IOException {
		JavaUtility jLib = new JavaUtility();
		TakesScreenshot ts = (TakesScreenshot) driver;
		String path = ts.getScreenshotAs(OutputType.BASE64);
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./Screenshots/" + jLib.getSystemDate() + ".png");
		FileUtils.copyFile(src, dst);
		return path;

	}
}
