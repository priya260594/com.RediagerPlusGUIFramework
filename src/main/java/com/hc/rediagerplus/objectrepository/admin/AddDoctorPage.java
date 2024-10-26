package com.hc.rediagerplus.objectrepository.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hc.rediagerplus.genericutility.WebDriverUtility;


public class AddDoctorPage extends WebDriverUtility{

	@FindBy(name="Doctorspecialization")
	private WebElement doctorSpecDropDown;
	
	@FindBy(name="docname")
	private WebElement docNameEdt;
	
	@FindBy(name="clinicaddress")
	private WebElement clinicAddressEdt;
	
	@FindBy(name="docfees")
	private WebElement doctorFeesEdt;
	
	@FindBy(name="doccontact")
	private WebElement doctorContactNoEdt;
	
	@FindBy(name="docemail")
	private WebElement doctorEmailEdt;
	
	@FindBy(name="npass")
	private WebElement doctorpwdEdt;
	
	@FindBy(name="cfpass")
	private WebElement doctorConfirmmpwdEdt;

	@FindBy(name="submit")
	private WebElement submitBtn;
	
	public AddDoctorPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getDoctorSpecDropDown() {
		return doctorSpecDropDown;
	}

	public WebElement getDocNameEdt() {
		return docNameEdt;
	}

	public WebElement getClinicAddressEdt() {
		return clinicAddressEdt;
	}

	public WebElement getDoctorFeesEdt() {
		return doctorFeesEdt;
	}

	public WebElement getDoctorContactNoEdt() {
		return doctorContactNoEdt;
	}

	public WebElement getDoctorEmailEdt() {
		return doctorEmailEdt;
	}

	public WebElement getDoctorpwdEdt() {
		return doctorpwdEdt;
	}

	public WebElement getDoctorConfirmmpwdEdt() {
		return doctorConfirmmpwdEdt;
	}
	
	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	public void addNewDoctor(WebDriver driver,String docSpec, String docName,String clinicAddress, String doctorFee, String docContNo,String doctorEmail,String pwd) {
		doctorSpecDropDown.sendKeys(docSpec);
		docNameEdt.sendKeys(docName);
		clinicAddressEdt.sendKeys(clinicAddress);
		doctorFeesEdt.sendKeys(doctorFee);
		doctorContactNoEdt.sendKeys(docContNo);
		doctorEmailEdt.sendKeys(doctorEmail);
		doctorpwdEdt.sendKeys(pwd);
		scrolltoEnd(driver);
		doctorConfirmmpwdEdt.sendKeys(pwd);
		submitBtn.click();
	}
	public void verifyNewlyAddedDoctor(WebDriver driver) {
		String alertText=getAlertText(driver);
		String expectedText="Doctor info added Successfully";
		Assert.assertEquals(alertText, expectedText);
		confirmAlert(driver);
	}
	
	
	
	
	
	
}
