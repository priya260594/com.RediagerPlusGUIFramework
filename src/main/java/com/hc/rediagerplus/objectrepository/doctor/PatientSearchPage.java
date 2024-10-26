package com.hc.rediagerplus.objectrepository.doctor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PatientSearchPage {
	@FindBy(name="searchdata")
	private WebElement patientSearchByNameEdt;
	
	@FindBy(id="submit")
	private WebElement searchBtn;
	
	@FindBy(xpath="//table[@class='table table-hover']/tbody/tr/td[2]")
	private WebElement displayedPatientName;
	
	public PatientSearchPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getPatientSearchByNameEdt() {
		return patientSearchByNameEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getDisplayedPatientName() {
		return displayedPatientName;
	}

	public void searchPatient(String patientName) {
		patientSearchByNameEdt.sendKeys(patientName);
		searchBtn.click();
	}
	public void verifyPatientSearch(String patientName) {
		Assert.assertEquals(displayedPatientName.getText(), patientName);
	}

}
