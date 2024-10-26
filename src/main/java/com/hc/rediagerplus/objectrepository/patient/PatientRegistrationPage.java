package com.hc.rediagerplus.objectrepository.patient;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hc.rediagerplus.genericutility.WebDriverUtility;

public class PatientRegistrationPage extends WebDriverUtility{

	@FindBy(name="full_name")
	private WebElement fullNameEdt;

	@FindBy(name="address")
	private WebElement addressEdt;

	@FindBy(name="city")
	private WebElement CityEdt;

	@FindBy(xpath="//label[@for='rg-male' and contains(text(),'Male')]")
	private WebElement pat_MaleRadioButton;
	
	@FindBy(xpath="//label[@for='rg-female' and contains(text(),'Female')]")
	private WebElement pat_FemaleRadioButton;

	@FindBy(name="email")
	private WebElement pat_emailEdt;
	
	@FindBy(name="password")
	private WebElement pat_pwdEdt;
	
	@FindBy(name="password_again")
	private WebElement pat_confirmPwdEdt;
	
	@FindBy(name="submit")
	private WebElement submitBtn;
	
	@FindBy(xpath="//a[contains(text(),'Log-in')]")
	private WebElement loginBtn;
	
	public PatientRegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public WebElement getFullNameEdt() {
		return fullNameEdt;
	}

	public WebElement getAddressEdt() {
		return addressEdt;
	}

	public WebElement getCityEdt() {
		return CityEdt;
	}

	public WebElement getPat_MaleRadioButton() {
		return pat_MaleRadioButton;
	}

	public WebElement getPat_FemaleRadioButton() {
		return pat_FemaleRadioButton;
	}

	public WebElement getPat_emailEdt() {
		return pat_emailEdt;
	}

	public WebElement getPat_pwdEdt() {
		return pat_pwdEdt;
	}

	public WebElement getPat_confirmPwdEdt() {
		return pat_confirmPwdEdt;
	}

	public WebElement getsubmitBtn() {
		return submitBtn;
	}
	
	public void createNewPatient(WebDriver driver,String patfullName,String patAddress,String patCity,String gender,String patEmail, String patPassword) throws InterruptedException {
	fullNameEdt.sendKeys(patfullName);
	addressEdt.sendKeys(patAddress);
	CityEdt.sendKeys(patCity);
	if(gender.equals("Female")) {
		pat_FemaleRadioButton.click();
	}
	else {
		pat_MaleRadioButton.click();
	}
	scrolltoEnd(driver);
	pat_emailEdt.sendKeys(patEmail);
	pat_pwdEdt.sendKeys(patPassword);
	pat_confirmPwdEdt.sendKeys(patPassword);
	submitBtn.click();
	}
	
	public void verifyPatientRegistration(WebDriver driver) {
		String actualText=getAlertText(driver);
		String expectedText="Successfully Registered. You can login now";
		Assert.assertEquals(actualText, expectedText);
		confirmAlert(driver);
		scrolltoEnd(driver);
	}
	
	
}
