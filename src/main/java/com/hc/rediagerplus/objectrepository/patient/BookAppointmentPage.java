package com.hc.rediagerplus.objectrepository.patient;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hc.rediagerplus.genericutility.WebDriverUtility;

public class BookAppointmentPage extends WebDriverUtility {

	@FindBy(name = "Doctorspecialization")
	private WebElement doctorSpecDropDown;

	@FindBy(xpath = "//select[@class='form-control' and @name='doctor']")
	private WebElement doctorDropDown;

	@FindBy(name = "appdate")
	private WebElement dateEdt;

	@FindBy(id = "timepicker1")
	private WebElement timeEdt;

	@FindBy(name = "submit")
	private WebElement submitBtn;

	@FindBy(xpath = "//table/tbody/tr[2]/td/input[@class='bootstrap-timepicker-hour form-control']")
	private WebElement hourEdt;

	@FindBy(xpath = "//table/tbody/tr[2]/td/input[@class='bootstrap-timepicker-minute form-control']")
	private WebElement minuteEdt;

	@FindBy(xpath = "//table/tbody/tr[2]/td/input[@class='bootstrap-timepicker-meridian form-control']")
	private WebElement AMOrPMEdt;

	public BookAppointmentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getDoctorSpecDropDown() {
		return doctorSpecDropDown;
	}

	public WebElement getDoctorDropDown() {
		return doctorDropDown;
	}

	public WebElement getDateEdt() {
		return dateEdt;
	}

	public WebElement getTimeEdt() {
		return timeEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public void bookingAppointment(WebDriver driver, String doctorSpecText, String doctorname, String date, String time)
			throws InterruptedException {
		selectByText(doctorSpecDropDown, doctorSpecText);
		scrolltoEnd(driver);
		selectByText(doctorDropDown, doctorname);
		dateEdt.click();
		dateEdt.clear();
		dateEdt.sendKeys(date);
		timeEdt.click();
		timeEdt.clear();
		timeEdt.sendKeys(time);
		submitBtn.click();
	}

	public void verifyBookAppointment(WebDriver driver) throws InterruptedException {
		try{
		waitForAlertToPresent(driver, 5);
	    String actualTxt = getAlertText(driver);
		String expectedTxt = "Your appointment successfully booked";
		Assert.assertEquals(actualTxt, expectedTxt);
		Thread.sleep(2000);
		confirmAlert(driver);}
		catch(Exception e) {}
	}

	public void verifyingDoctorSpecInPatient(String doctorSpecText) {
		doctorSpecDropDown.click();
		List<WebElement> doctorSpecs = getListFromDropdown(doctorSpecDropDown);
		boolean flag = false;
		for (WebElement doctorSpec : doctorSpecs) {
			if (doctorSpec.getText().contains(doctorSpecText)) {
				flag = true;
				break;
			}
		}
		Assert.assertTrue(flag, doctorSpecText);
		selectByText(doctorSpecDropDown, doctorSpecText);
	}

	public void verifyingDoctorNameInPatient(String doctorname) {
		doctorDropDown.click();
		List<WebElement> doctorSpecs = getListFromDropdown(doctorDropDown);
		boolean flag = false;
		for (WebElement doctorSpec : doctorSpecs) {
			if (doctorSpec.getText().contains(doctorname)) {
				flag = true;
				break;
			}
		}
		Assert.assertTrue(flag, doctorname);
	}
}
