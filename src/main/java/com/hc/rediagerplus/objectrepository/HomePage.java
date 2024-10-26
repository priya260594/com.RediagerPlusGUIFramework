package com.hc.rediagerplus.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hc.rediagerplus.genericutility.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	@FindBy(xpath = "//li[@class='active']/a[text()='Home']")
	private WebElement homeBtn;
	
	@FindBy(xpath = "//div[@class='top-nav']/ul/li/a[text()='contact']")
	private WebElement contactBtn;
	
	@FindBy(xpath="//div[@class='text list_1_of_2']/h3[text()='Patients']/following-sibling::div[@class='button']/span/a[text()='Click Here']")
	private WebElement patientLink;
	
	@FindBy(xpath="//div[@class='text list_1_of_2']/h3[text()='Doctors Login']/following-sibling::div[@class='button']/span/a[text()='Click Here']")
	private WebElement doctorLink;
	
	@FindBy(xpath="//div[@class='text list_1_of_2']/h3[text()='Admin Login']/following-sibling::div[@class='button']/span/a[text()='Click Here']")
	private WebElement adminLink;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getHomeBtn() {
		return homeBtn;
	}

	public WebElement getContactBtn() {
		return contactBtn;
	}

	public WebElement getPatientLink() {
		return patientLink;
	}

	public WebElement getDoctorLink() {
		return doctorLink;
	}

	public WebElement getAdminLink() {
		return adminLink;
	}
	
	public void clickDoctorLogin(WebDriver driver) {
		scrolltoEnd(driver);
		getDoctorLink().click();
	}
	
	public void clickAdminLogin(WebDriver driver) {
		scrolltoEnd(driver);
		getAdminLink().click();
	}
	
	public void clickPatientLogin(WebDriver driver) {
		scrolltoEnd(driver);
		getPatientLink().click();
	}
	

}
