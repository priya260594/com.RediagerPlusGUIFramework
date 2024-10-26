package com.hc.rediagerplus.objectrepository.doctor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hc.rediagerplus.genericutility.WebDriverUtility;

public class AddPatientPage extends WebDriverUtility {

	@FindBy(name="patname")
	private WebElement patientNameEdt;
	
	@FindBy(name="patcontact")
	private WebElement patientContactNoEdt;
	
	@FindBy(name="patemail")
	private WebElement patientEmailEdt;
	
	@FindBy(xpath="//label[@for='rg-male']")
	private WebElement patient_MaleRadioButton;
	
	@FindBy(xpath="//label[@for='rg-female']")
	private WebElement patient_FemaleRadioButton;

	@FindBy(name="pataddress")
	private WebElement patientAddressEdt;
	
	@FindBy(name="patage")
	private WebElement patientAgeEdt;
	
	@FindBy(name="medhis")
	private WebElement patientMedicalHistory;

	@FindBy(name="submit")
	private WebElement submitBtn;
	
	public AddPatientPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getPatientNameEdt() {
		return patientNameEdt;
	}

	public WebElement getPatientContactNoEdt() {
		return patientContactNoEdt;
	}

	public WebElement getPatientEmailEdt() {
		return patientEmailEdt;
	}

	public WebElement getPatient_MaleRadioButton() {
		return patient_MaleRadioButton;
	}

	public WebElement getPatient_FemaleRadioButton() {
		return patient_FemaleRadioButton;
	}

	public WebElement getPatientAddressEdt() {
		return patientAddressEdt;
	}

	public WebElement getPatientAgeEdt() {
		return patientAgeEdt;
	}

	public WebElement getPatientMedicalHistory() {
		return patientMedicalHistory;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	public void addNewPatient(WebDriver driver,String patientName, String patientContactNo,String patientEmail, String gender,String patientAddress, String patientAge,String patientMedlHistory)  {
		patientNameEdt.sendKeys(patientName);
		patientContactNoEdt.sendKeys(patientContactNo);
		patientEmailEdt.sendKeys(patientEmail);
		scrolltoEnd(driver);
		if(gender.equals("Female")) {
			patient_FemaleRadioButton.click();
		}
		else {
			patient_MaleRadioButton.click();
		}
		patientAddressEdt.sendKeys(patientAddress);
		patientAgeEdt.sendKeys(patientAge);
		patientMedicalHistory.sendKeys(patientMedlHistory);
		submitBtn.click();
	}
	
}
