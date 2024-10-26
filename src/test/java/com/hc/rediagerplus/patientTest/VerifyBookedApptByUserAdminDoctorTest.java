package com.hc.rediagerplus.patientTest;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.hc.rediagerplus.genericutility.Baseclass;
import com.hc.rediagerplus.genericutility.RetryAnalyserImpClass;
import com.hc.rediagerplus.genericutility.UtilityClassObject;
import com.hc.rediagerplus.objectrepository.HomePage;
import com.hc.rediagerplus.objectrepository.admin.AdminAppointmentHistoryPage;
import com.hc.rediagerplus.objectrepository.admin.AdminDashboardPage;
import com.hc.rediagerplus.objectrepository.admin.AdminLoginPage;
import com.hc.rediagerplus.objectrepository.doctor.DoctorAppointmenttHistoryPage;
import com.hc.rediagerplus.objectrepository.doctor.DoctorDashboardPage;
import com.hc.rediagerplus.objectrepository.doctor.DoctorLoginPage;
import com.hc.rediagerplus.objectrepository.patient.BookAppointmentPage;
import com.hc.rediagerplus.objectrepository.patient.PatientDashboardPage;
import com.hc.rediagerplus.objectrepository.patient.PatientLoginPage;
import com.hc.rediagerplus.objectrepository.patient.PatientRegistrationPage;

@Listeners(com.hc.rediagerplus.genericutility.ListImpClass.class)
public class VerifyBookedApptByUserAdminDoctorTest extends Baseclass{
	@Test/**(retryAnalyzer = RetryAnalyserImpClass.class)**/
	public void tc04_ST_VerifyBookedApptByUserAdminDoctorTest() throws IOException, InterruptedException {
		String adminUsername=pLib.getDataFromPropertyFile("adminUsername");
		String adminPassword=pLib.getDataFromPropertyFile("adminPassword");
		String doctorUsername=pLib.getDataFromPropertyFile("doctorUsername");
		String doctorPassword=pLib.getDataFromPropertyFile("doctorPassword");
		
		String patientName=eLib.getDataFromExcelFile("Patient", 4, 2)+jLib.getRandomNumber();
		String patientAddress=eLib.getDataFromExcelFile("Patient", 4, 3);
		String patientCity=eLib.getDataFromExcelFile("Patient", 4, 4);
		String gender=eLib.getDataFromExcelFile("Patient", 4, 5);
		String patientEmail=patientName+"@gmail.com";
		String patientPassword=eLib.getDataFromExcelFile("Patient", 4, 7);
		String doctorSpec=eLib.getDataFromExcelFile("Patient", 4, 8);
		String doctorName=eLib.getDataFromExcelFile("Patient", 4, 9);
		String date=eLib.getDataFromExcelFile("Patient", 4, 10);
		String time=eLib.getDataFromExcelFile("Patient", 4, 11);
				
		HomePage hp=new HomePage(driver);
		hp.clickPatientLogin(driver);
		
		/****************Patient Registration****************/
        PatientLoginPage plp=new PatientLoginPage(driver);
        plp.getCreateAccountLink().click();
        PatientRegistrationPage prp=new PatientRegistrationPage(driver);
        prp.createNewPatient(driver,patientName, patientAddress, patientCity, gender, patientEmail, patientPassword);
        prp.verifyPatientRegistration(driver);
        prp.getLoginBtn().click();
        UtilityClassObject.getTest().log(Status.INFO, "Patient Registration is done");
        
       /****************Patient Login****************/
        plp.loginAsPatient(patientEmail, patientPassword);
    	PatientDashboardPage pdp=new PatientDashboardPage(driver);
		pdp.getBookApptLnk().click();
		BookAppointmentPage bpp=new BookAppointmentPage(driver);
		bpp.bookingAppointment(driver, doctorSpec,doctorName, date, time);
		bpp.verifyBookAppointment(driver);
		pdp.logoutAsPatient();
		UtilityClassObject.getTest().log(Status.INFO, "Patient Login is done");
		
		/****************Doctor Login****************/
		UtilityClassObject.getTest().log(Status.INFO, "Doctor Login is started");
		hp.clickDoctorLogin(driver);
        DoctorLoginPage dlp=new DoctorLoginPage(driver);
        dlp.loginAsDoctor(doctorUsername, doctorPassword);
        DoctorDashboardPage ddp=new DoctorDashboardPage(driver);
        ddp.getDoctorApptHistorylnk().click();
        DoctorAppointmenttHistoryPage dahp=new DoctorAppointmenttHistoryPage(driver);
        dahp.verifyPatientApptInDoctor(driver,patientName);
        UtilityClassObject.getTest().log(Status.INFO, "Doctor appointment  is verified");
        ddp.logoutAsDoctor();
        UtilityClassObject.getTest().log(Status.INFO, "Doctor Logout is done");
        
        /****************Admin Login****************/
        UtilityClassObject.getTest().log(Status.INFO, "Admin Login is started");
        hp.clickAdminLogin(driver);
        AdminLoginPage alp=new AdminLoginPage(driver);
		alp.loginAsAdmin(adminUsername, adminPassword);
		AdminDashboardPage adp=new AdminDashboardPage(driver);
		adp.getApptHistoryLink().click();
		AdminAppointmentHistoryPage aahp=new AdminAppointmentHistoryPage(driver);
		aahp.verifyPatientApptInAdmin(driver,patientName);
		adp.logoutAsAdmin();     
		UtilityClassObject.getTest().log(Status.INFO, "Admin Logout is done");
    }
	


}
