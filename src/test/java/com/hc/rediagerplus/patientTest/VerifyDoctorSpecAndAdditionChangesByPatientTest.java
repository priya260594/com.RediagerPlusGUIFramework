package com.hc.rediagerplus.patientTest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.hc.rediagerplus.genericutility.Baseclass;
import com.hc.rediagerplus.objectrepository.HomePage;
import com.hc.rediagerplus.objectrepository.admin.AddDoctorPage;
import com.hc.rediagerplus.objectrepository.admin.AddSpecializationPage;
import com.hc.rediagerplus.objectrepository.admin.AdminDashboardPage;
import com.hc.rediagerplus.objectrepository.admin.AdminLoginPage;
import com.hc.rediagerplus.objectrepository.patient.BookAppointmentPage;
import com.hc.rediagerplus.objectrepository.patient.PatientDashboardPage;
import com.hc.rediagerplus.objectrepository.patient.PatientLoginPage;

public class VerifyDoctorSpecAndAdditionChangesByPatientTest extends Baseclass{

	@Test
	public void VerifyDoctorSpecAndAdditionChangesByPatient() throws IOException, InterruptedException {
		String adminUsername=pLib.getDataFromPropertyFile("adminUsername");
		String adminPassword=pLib.getDataFromPropertyFile("adminPassword");
		
		String patientUsername=pLib.getDataFromPropertyFile("patientUsername");
		String patientPassword=pLib.getDataFromPropertyFile("patientPassword");
		
		String doctorSpec=eLib.getDataFromExcelFile("Admin", 13, 2);
		String doctorName=eLib.getDataFromExcelFile("Admin", 13, 3)+jLib.getRandomNumber();
		String doctorClinicAddress=eLib.getDataFromExcelFile("Admin", 13, 4);
		String doctorFee=eLib.getDataFromExcelFile("Admin", 13, 5);
		String doctContactNo=eLib.getDataFromExcelFile("Admin", 13, 6);
		String doctorEmail=doctorName+"@gmail.com";
		String doctorpassword=eLib.getDataFromExcelFile("Admin", 13, 7);
		
        /******************Admin Login******************/
		HomePage hp=new HomePage(driver);
		hp.clickAdminLogin(driver);
        AdminLoginPage alp=new AdminLoginPage(driver);
		alp.loginAsAdmin(adminUsername, adminPassword);
		AdminDashboardPage adp=new AdminDashboardPage(driver);
		adp.clickAddSpecialization();
		AddSpecializationPage asp=new AddSpecializationPage(driver);
		asp.addSpecialization(doctorSpec);
		adp.clickAddDoctor();
		AddDoctorPage aDP=new AddDoctorPage(driver);
		aDP.addNewDoctor(driver,doctorSpec, doctorName, doctorClinicAddress, doctorFee, doctContactNo, doctorEmail, doctorpassword);
		aDP.verifyNewlyAddedDoctor(driver);
		adp.logoutAsAdmin();
		
		/******************Patient Login******************/
		hp.clickPatientLogin(driver);
        PatientLoginPage plp=new PatientLoginPage(driver);
        plp.loginAsPatient(patientUsername, patientPassword);
        PatientDashboardPage pdp=new PatientDashboardPage(driver);
		pdp.getBookApptLnk().click();
		BookAppointmentPage bpp=new BookAppointmentPage(driver);
		bpp.verifyingDoctorSpecInPatient(doctorSpec);
		bpp.verifyingDoctorNameInPatient(doctorName);
		pdp.logoutAsPatient();
		}
}
