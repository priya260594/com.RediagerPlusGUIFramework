package com.hc.rediagerplus.objectrepository.patient;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hc.rediagerplus.genericutility.WebDriverUtility;

public class PatientLoginPage {
	@FindBy(name="username")
	private WebElement userNameEdt;
	
	@FindBy(name="password")
	private WebElement passwordEdt;
	
	@FindBy(name="submit")
	private WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Forgot Password')]")
	private WebElement forgotPasswordLink;
	
	@FindBy(xpath="//a[contains(text(),'Create an account')]")
	private WebElement createAccountLink;
	
	public PatientLoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public WebElement getForgotPasswordLink() {
		return forgotPasswordLink;
	}

	public WebElement getCreateAccountLink() {
		return createAccountLink;
	}
	
	public void loginAsPatient(String username, String password) {
		userNameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
	
	
}
