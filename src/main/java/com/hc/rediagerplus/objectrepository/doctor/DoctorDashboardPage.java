package com.hc.rediagerplus.objectrepository.doctor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorDashboardPage {

	@FindBy(xpath = "//span[@class='title' and contains(text(),'Dashboard')]")
	private WebElement doctorDashboardLnk;

	@FindBy(xpath = "//span[@class='title' and contains(text(),'Appointment History')]")
	private WebElement doctorApptHistorylnk;

	@FindBy(xpath = "//span[@class='title' and contains(text(),'Patients')]")
	private WebElement doctorPatientsLink;

	@FindBy(xpath = "//ul[@class='sub-menu']/li/a/span[contains(text(),'Add Patient')]")
	private WebElement doctorAddPatientLink;

	@FindBy(xpath = "//ul[@class='sub-menu']/li/a/span[contains(text(),'Manage Patient')]")
	private WebElement doctorManagePatientLink;

	@FindBy(xpath = "//span[@class='title' and contains(text(),'Search')]")
	private WebElement doctorPatientSearchLnk;

	@FindBy(xpath = "//a[contains(text(),'Update Profile')]")
	private WebElement doctorDashboardUpdateProfileLnk;

	@FindBy(xpath = "//a[contains(text(),'View Appointment History')]")
	private WebElement doctorDashboardViewApptLnk;

	@FindBy(xpath = "//span[@class='username']")
	private WebElement administratorDropdownBtn;

	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-dark']/li/a[contains(text(),'My Profile')]")
	private WebElement doctorDropDownProfileLnk;

	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-dark']/li/a[contains(text(),'Change Password')]")
	private WebElement doctorDropDownChangePwdLnk;

	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-dark']/li/a[contains(text(),'Log Out')]")
	private WebElement doctorDropDownLogoutLnk;

	public DoctorDashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getDoctorDashboardLnk() {
		return doctorDashboardLnk;
	}

	public WebElement getDoctorApptHistorylnk() {
		return doctorApptHistorylnk;
	}

	public WebElement getDoctorPatientsLink() {
		return doctorPatientsLink;
	}

	public WebElement getDoctorAddPatientLink() {
		return doctorAddPatientLink;
	}

	public WebElement getDoctorManagePatientLink() {
		return doctorManagePatientLink;
	}

	public WebElement getDoctorPatientSearchLnk() {
		return doctorPatientSearchLnk;
	}

	public WebElement getDoctorDashboardUpdateProfileLnk() {
		return doctorDashboardUpdateProfileLnk;
	}

	public WebElement getDoctorDashboardViewApptLnk() {
		return doctorDashboardViewApptLnk;
	}

	public WebElement getAdministratorDropdownBtn() {
		return administratorDropdownBtn;
	}

	public WebElement getDoctorDropDownProfileLnk() {
		return doctorDropDownProfileLnk;
	}

	public WebElement getDoctorDropDownChangePwdLnk() {
		return doctorDropDownChangePwdLnk;
	}

	public WebElement getDoctorDropDownLogoutLnk() {
		return doctorDropDownLogoutLnk;
	}

	public void logoutAsDoctor() throws InterruptedException {
		Thread.sleep(2000);
		administratorDropdownBtn.click();
		doctorDropDownLogoutLnk.click();
	}

	public void clickAddPatient() {
		getDoctorPatientsLink().click();
		getDoctorAddPatientLink().click();
	}

	public void clickManagePatient() {
		getDoctorPatientsLink().click();
		getDoctorManagePatientLink().click();
	}

}
