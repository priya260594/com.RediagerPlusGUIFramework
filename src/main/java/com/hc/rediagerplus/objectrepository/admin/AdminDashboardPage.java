package com.hc.rediagerplus.objectrepository.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDashboardPage {
	@FindBy(xpath="//span[@class='title' and contains(text(),'Dashboard')]")
	private WebElement ad_dashboardLnk;
	
	@FindBy(xpath="//span[@class='title' and text()=' Doctors ']")
	private WebElement DoctorsLink;
	
	@FindBy(xpath="//ul[@class='sub-menu']/li/a/span[contains(text(),'Doctor Specialization')]")
	private WebElement doctorSpecializationLink;
	
	@FindBy(xpath="//ul[@class='sub-menu']/li/a/span[contains(text(),'Add Doctor')]")
	private WebElement addDoctorLink;
	
	@FindBy(xpath="//ul[@class='sub-menu']/li/a/span[contains(text(),'Manage Doctors')]")
	private WebElement manageDoctorsLink;
	
	@FindBy(xpath="//span[@class='title' and text()=' Users ']")
	private WebElement UsersLink;
	
	@FindBy(xpath="//ul[@class='sub-menu']/li/a/span[contains(text(),'Manage Users')]")
	private WebElement manageUsersLink;
	
	@FindBy(xpath="//span[@class='title' and contains(text(),'Appointment History')]")
	private WebElement apptHistoryLink;
	
	@FindBy(xpath="//span[@class='title' and contains(text(),'Conatctus Queries')]")
	private WebElement contactQueryLink;
	
	@FindBy(xpath="//span[@class='title' and contains(text(),'Doctor Session Logs')]")
	private WebElement doctorSessionLogsLink;
	
	@FindBy(xpath="//span[@class='title' and contains(text(),'User Session Logs')]")
	private WebElement userSessionLogsLink;
	
	@FindBy(xpath="//span[@class='title' and contains(text(),'Reports')]")
	private WebElement reportLink;
	
	@FindBy(xpath="//span[@class='title' and contains(text(),'Patient Search')]")
	private WebElement patientSearchLink;
	
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
	
	public AdminDashboardPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getAd_dashboardLnk() {
		return ad_dashboardLnk;
	}

	public WebElement getDoctorsLink() {
		return DoctorsLink;
	}

	public WebElement getDoctorSpecializationLink() {
		return doctorSpecializationLink;
	}

	public WebElement getAddDoctorLink() {
		return addDoctorLink;
	}

	public WebElement getManageDoctorsLink() {
		return manageDoctorsLink;
	}

	public WebElement getUsersLink() {
		return UsersLink;
	}

	public WebElement getManageUsersLink() {
		return manageUsersLink;
	}

	public WebElement getApptHistoryLink() {
		return apptHistoryLink;
	}

	public WebElement getContactQueryLink() {
		return contactQueryLink;
	}

	public WebElement getDoctorSessionLogsLink() {
		return doctorSessionLogsLink;
	}

	public WebElement getUserSessionLogsLink() {
		return userSessionLogsLink;
	}

	public WebElement getReportLink() {
		return reportLink;
	}

	public WebElement getPatientSearchLink() {
		return patientSearchLink;
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
	
	public void logoutAsAdmin() throws InterruptedException {
		Thread.sleep(3000);
		administratorDropdownBtn.click();
		DropDownLogoutLnk.click();
	}
	
	public void clickAddDoctor() {
		getDoctorsLink().click();
		getAddDoctorLink().click();
	}
	
	public void clickAddSpecialization() {
		getDoctorsLink().click();
		getDoctorSpecializationLink().click();
	}
	

}
