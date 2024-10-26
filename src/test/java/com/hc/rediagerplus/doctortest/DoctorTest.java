package com.hc.rediagerplus.doctortest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.hc.rediagerplus.genericutility.Baseclass;
import com.hc.rediagerplus.objectrepository.HomePage;
import com.hc.rediagerplus.objectrepository.doctor.AddPatientPage;
import com.hc.rediagerplus.objectrepository.doctor.DoctorDashboardPage;
import com.hc.rediagerplus.objectrepository.doctor.DoctorLoginPage;
import com.hc.rediagerplus.objectrepository.doctor.PatientSearchPage;

public class DoctorTest extends Baseclass {

	@Test
	public void AddPatientByDoctor() throws IOException, InterruptedException {
		String doctorUsername=pLib.getDataFromPropertyFile("doctorUsername");
		String doctorPassword=pLib.getDataFromPropertyFile("doctorPassword");
		
		/***Add Patient***/
		String patientName=eLib.getDataFromExcelFile("Doctor", 1, 2)+jLib.getRandomNumber();
		String patientContactNo=eLib.getDataFromExcelFile("Doctor", 1, 3);
		String patientEmail=patientName+"@gmail.com";
		String gender=eLib.getDataFromExcelFile("Doctor", 1, 4);
		String patientAddress=eLib.getDataFromExcelFile("Doctor", 1, 5);
		String patientAge=eLib.getDataFromExcelFile("Doctor", 1, 6);
		String patientMedicalHistory=eLib.getDataFromExcelFile("Doctor", 1, 7);
		
		HomePage hp=new HomePage(driver);
		hp.clickDoctorLogin(driver);
		DoctorLoginPage dlp=new DoctorLoginPage(driver);
		dlp.loginAsDoctor(doctorUsername, doctorPassword);
		DoctorDashboardPage ddp=new DoctorDashboardPage(driver);
		ddp.clickAddPatient();
		
		AddPatientPage app=new AddPatientPage(driver);
		app.addNewPatient(driver,patientName, patientContactNo, patientEmail, gender, patientAddress, patientAge, patientMedicalHistory);
		
		ddp.getDoctorPatientSearchLnk().click();
		PatientSearchPage psp=new PatientSearchPage(driver);
		psp.searchPatient(patientName);
		psp.verifyPatientSearch(patientName);
	}
}
