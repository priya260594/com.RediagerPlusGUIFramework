package com.hc.rediagerplus.objectrepository.doctor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hc.rediagerplus.genericutility.WebDriverUtility;

public class DoctorProfilePage extends WebDriverUtility{
	@FindBy(name="Doctorspecialization")
	private WebElement docSpecDropdown;
	
	@FindBy(name="docname")
	private WebElement doctorName;
	
	@FindBy(name="clinicaddress")
	private WebElement doctorClinicAddress;
	
	@FindBy(name="docfees")
	private WebElement doctorFee;
	
	@FindBy(name="doccontact")
	private WebElement doctorContactNo;
	
	@FindBy(name="submit")
	private WebElement updateBtn;
	
	public DoctorProfilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getDocSpecDropdown() {
		return docSpecDropdown;
	}

	public WebElement getDoctorName() {
		return doctorName;
	}

    public WebElement getDoctorClinicAddress() {
		return doctorClinicAddress;
	}

	public WebElement getDoctorFee() {
		return doctorFee;
	}

	public WebElement getDoctorContactNo() {
		return doctorContactNo;
	}
	
	public WebElement getUpdateBtn() {
		return updateBtn;
	}
	
	public void updateDoctorDetails(WebDriver driver,String clinicAddress,String docFee,String contactNo) {
		doctorClinicAddress.clear();
		doctorClinicAddress.sendKeys(clinicAddress);
		doctorFee.clear();
		doctorFee.sendKeys(docFee);
		doctorContactNo.clear();
		doctorContactNo.sendKeys(contactNo);
		scrolltoEnd(driver);
		updateBtn.click();
	}
	
	public void verifyDoctorUpdate(WebDriver driver) throws InterruptedException {
		String actualText=getAlertText(driver);
		String expectedText="Doctor Details updated Successfully";
		Assert.assertEquals(actualText, expectedText);
		Thread.sleep(1000);
		confirmAlert(driver);
	}
	
}
