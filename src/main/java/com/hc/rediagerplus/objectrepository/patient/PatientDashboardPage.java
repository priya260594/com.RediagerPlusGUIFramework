package com.hc.rediagerplus.objectrepository.patient;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientDashboardPage {
	
	@FindBy(xpath="//span[@class='title' and contains(text(),'Dashboard')]")
	private WebElement dashboardLnk;
	
	@FindBy(xpath="//span[@class='title' and contains(text(),'Book Appointment')]")
	private WebElement bookApptLnk;
	
	@FindBy(xpath="//span[@class='title' and contains(text(),'Appointment History')]")
	private WebElement apptHistoryLnk;
	
	@FindBy(xpath="//span[@class='title' and contains(text(),'Medical History')]")
	private WebElement medicalHistoryLnk;
	
	@FindBy(xpath="//a[contains(text(),'Update Profile')]")
	private WebElement dashboardupdateProfileLnk;
	
	@FindBy(xpath="//a[contains(text(),'View Appointment History')]")
	private WebElement dashboardviewApptLnk;
	
	@FindBy(xpath="//a[contains(text(),'Book Appointment')]")
	private WebElement dashboardBookApptLnk;
	
	@FindBy(xpath="//span[@class='username']")
	private WebElement administratorDropdownBtn;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-dark']/li/a[contains(text(),'My Profile')]")
	private WebElement DropDownProfileLnk;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-dark']/li/a[contains(text(),'Change Password')]")
	private WebElement DropDownChangePwdLnk;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-dark']/li/a[contains(text(),'Log Out')]")
	private WebElement DropDownLogoutLnk;
	
	public PatientDashboardPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}


	public WebElement getDashboardLnk() {
		return dashboardLnk;
	}

	public WebElement getBookApptLnk() {
		return bookApptLnk;
	}

	public WebElement getApptHistoryLnk() {
		return apptHistoryLnk;
	}

	public WebElement getMedicalHistoryLnk() {
		return medicalHistoryLnk;
	}

	public WebElement getDashboardupdateProfileLnk() {
		return dashboardupdateProfileLnk;
	}

	public WebElement getDashboardviewApptLnk() {
		return dashboardviewApptLnk;
	}

	public WebElement getDashboardBookApptLnk() {
		return dashboardBookApptLnk;
	}

	public WebElement getAdministratorDropdownBtn() {
		return administratorDropdownBtn;
	}

	public WebElement getDropDownProfileLnk() {
		return DropDownProfileLnk;
	}

	public WebElement getDropDownChangePwdLnk() {
		return DropDownChangePwdLnk;
	}

	public WebElement getDropDownLogoutLnk() {
		return DropDownLogoutLnk;
	}
	
	public void logoutAsPatient() throws InterruptedException {
		Thread.sleep(3000);
		administratorDropdownBtn.click();
		DropDownLogoutLnk.click();
	}
	
	
	

}
