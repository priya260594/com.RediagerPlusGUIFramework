package com.hc.rediagerplus.objectrepository.patient;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hc.rediagerplus.genericutility.WebDriverUtility;

public class EditPatientPage extends WebDriverUtility {
	@FindBy(name="patage")
	private WebElement updatePatientAge;
	
	@FindBy(name="submit")
	private WebElement updateBtn;
	
	public EditPatientPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getUpdatePatientAge() {
		return updatePatientAge;
	}
	
	public WebElement getUpdateBtn() {
		return updateBtn;
	}
	
	public void updatePatientAge(WebDriver driver,String patientAge) {
		scrolltoEnd(driver);
		updatePatientAge.clear();
		updatePatientAge.sendKeys(patientAge);
		updateBtn.click();
	}

}
