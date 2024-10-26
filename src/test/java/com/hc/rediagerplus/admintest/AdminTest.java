package com.hc.rediagerplus.admintest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.hc.rediagerplus.genericutility.Baseclass;
import com.hc.rediagerplus.objectrepository.HomePage;
import com.hc.rediagerplus.objectrepository.admin.AddDoctorPage;
import com.hc.rediagerplus.objectrepository.admin.AddSpecializationPage;
import com.hc.rediagerplus.objectrepository.admin.AdminAppointmentHistoryPage;
import com.hc.rediagerplus.objectrepository.admin.AdminDashboardPage;
import com.hc.rediagerplus.objectrepository.admin.AdminDocSessionLogPage;
import com.hc.rediagerplus.objectrepository.admin.AdminLoginPage;
import com.hc.rediagerplus.objectrepository.doctor.DoctorDashboardPage;
import com.hc.rediagerplus.objectrepository.doctor.DoctorLoginPage;
import com.hc.rediagerplus.objectrepository.patient.BookAppointmentPage;
import com.hc.rediagerplus.objectrepository.patient.PatientDashboardPage;
import com.hc.rediagerplus.objectrepository.patient.PatientLoginPage;

public class AdminTest extends Baseclass{
	@Test
	public void AddDoctorSpecializationByAdminTest() throws Throwable {
		String adminUsername=pLib.getDataFromPropertyFile("adminUsername");
		String adminPassword=pLib.getDataFromPropertyFile("adminPassword");
		String doctorSpec=eLib.getDataFromExcelFile("Admin", 4, 2)+jLib.getRandomNumber();
		
		HomePage hp=new HomePage(driver);
		hp.clickAdminLogin(driver);
		AdminLoginPage alp=new AdminLoginPage(driver);
		alp.loginAsAdmin(adminUsername, adminPassword);
		AdminDashboardPage adp=new AdminDashboardPage(driver);
		adp.clickAddSpecialization();
		AddSpecializationPage asp=new AddSpecializationPage(driver);
		asp.addSpecialization(doctorSpec);
		asp.verifyDocSpecialization(doctorSpec);
		adp.logoutAsAdmin();
	}
	
	@Test
	public void tc_07_VerifyDoctorSessionLogs() throws Throwable{
		String doctorUsername=pLib.getDataFromPropertyFile("doctorUsername");
		String doctorPassword=pLib.getDataFromPropertyFile("doctorPassword");
	    String adminUsername=pLib.getDataFromPropertyFile("adminUsername");
		String adminPassword=pLib.getDataFromPropertyFile("adminPassword");
		
		HomePage hp=new HomePage(driver);
		hp.clickDoctorLogin(driver);
		DoctorLoginPage dlp=new DoctorLoginPage(driver);
		dlp.loginAsDoctor(doctorUsername, doctorPassword);
		DoctorDashboardPage ddp=new DoctorDashboardPage(driver);
		ddp.logoutAsDoctor();
		
		hp.clickAdminLogin(driver);
		AdminLoginPage alp=new AdminLoginPage(driver);
		alp.loginAsAdmin(adminUsername, adminPassword);
		AdminDashboardPage adp=new AdminDashboardPage(driver);
		adp.getDoctorSessionLogsLink().click();
		AdminDocSessionLogPage adsp=new AdminDocSessionLogPage(driver);
		adsp.verifyRecentlyAddedDocName(doctorUsername);
		adp.logoutAsAdmin();
     }
	@Test
	public void VerifyAddedValidDoctorTest() throws EncryptedDocumentException, IOException, InterruptedException {
		String adminUsername=pLib.getDataFromPropertyFile("adminUsername");
		String adminPassword=pLib.getDataFromPropertyFile("adminPassword");	
	
		String doctorSpec=eLib.getDataFromExcelFile("Admin", 7, 2);
		String doctorName=eLib.getDataFromExcelFile("Admin", 7, 3)+jLib.getRandomNumber();
		String doctorClinicAddress=eLib.getDataFromExcelFile("Admin", 7, 4);
		String doctorFee=eLib.getDataFromExcelFile("Admin", 7, 5);
		String doctContactNo=eLib.getDataFromExcelFile("Admin", 7, 6);
		String doctorEmail=doctorName+"@gmail.com";
		String doctorPassword=eLib.getDataFromExcelFile("Admin", 7, 7);

		HomePage hp=new HomePage(driver);
		hp.clickAdminLogin(driver);
        AdminLoginPage alp=new AdminLoginPage(driver);
		alp.loginAsAdmin(adminUsername, adminPassword);
		AdminDashboardPage adp=new AdminDashboardPage(driver);
		adp.clickAddDoctor();
		AddDoctorPage aDP=new AddDoctorPage(driver);
		aDP.addNewDoctor(driver,doctorSpec, doctorName, doctorClinicAddress, doctorFee, doctContactNo, doctorEmail, doctorPassword);
		aDP.verifyNewlyAddedDoctor(driver);
		adp.logoutAsAdmin();
		
		hp.clickDoctorLogin(driver);
        DoctorLoginPage dlp=new DoctorLoginPage(driver);
        dlp.loginAsDoctor(doctorEmail, doctorPassword);
        DoctorDashboardPage ddp=new DoctorDashboardPage(driver);
        ddp.logoutAsDoctor();
	}
	
	@Test
	public void VerifyBookedAppointmentInAdminTest() throws EncryptedDocumentException, IOException, InterruptedException {
		
		String patientUsername=pLib.getDataFromPropertyFile("patientUsername");
		String patientPassword=pLib.getDataFromPropertyFile("patientPassword");
		String adminUsername=pLib.getDataFromPropertyFile("adminUsername");
		String adminPassword=pLib.getDataFromPropertyFile("adminPassword");
		
		String doctorSpec=eLib.getDataFromExcelFile("Patient", 1, 2);
		String doctorName=eLib.getDataFromExcelFile("Patient", 1, 3);
		String date=eLib.getDataFromExcelFile("Patient", 1, 4);
		String time=eLib.getDataFromExcelFile("Patient", 1, 5);
		String PatientName=eLib.getDataFromExcelFile("Patient", 1, 6);
		
		/******************Patient login******************/
		HomePage hp=new HomePage(driver);
		hp.clickPatientLogin(driver);
        PatientLoginPage plp=new PatientLoginPage(driver);
        plp.loginAsPatient(patientUsername, patientPassword);
    	PatientDashboardPage pdp=new PatientDashboardPage(driver);
		pdp.getBookApptLnk().click();
		BookAppointmentPage bpp=new BookAppointmentPage(driver);
		bpp.bookingAppointment(driver, doctorSpec,doctorName, date, time);
		bpp.verifyBookAppointment(driver);
		pdp.logoutAsPatient();
		
		/******************Admin Login******************/
		hp.clickAdminLogin(driver);
		AdminLoginPage alp=new AdminLoginPage(driver);
		alp.loginAsAdmin(adminUsername, adminPassword);
		AdminDashboardPage adp=new AdminDashboardPage(driver);
		adp.getApptHistoryLink().click();
		AdminAppointmentHistoryPage aahp=new AdminAppointmentHistoryPage(driver);
		aahp.verifyPatientApptInAdmin(driver,PatientName);
		adp.logoutAsAdmin();
				
	}

}
