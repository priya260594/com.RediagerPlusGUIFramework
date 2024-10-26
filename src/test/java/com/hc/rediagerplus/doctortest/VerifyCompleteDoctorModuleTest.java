package com.hc.rediagerplus.doctortest;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hc.rediagerplus.genericutility.Baseclass;
import com.hc.rediagerplus.objectrepository.HomePage;
import com.hc.rediagerplus.objectrepository.doctor.AddMedicalHistoryPage;
import com.hc.rediagerplus.objectrepository.doctor.AddPatientPage;
import com.hc.rediagerplus.objectrepository.doctor.DoctorAppointmenttHistoryPage;
import com.hc.rediagerplus.objectrepository.doctor.DoctorDashboardPage;
import com.hc.rediagerplus.objectrepository.doctor.DoctorLoginPage;
import com.hc.rediagerplus.objectrepository.doctor.DoctorProfilePage;
import com.hc.rediagerplus.objectrepository.doctor.PatientSearchPage;
import com.hc.rediagerplus.objectrepository.doctor.ViewParticularPatientPage;
import com.hc.rediagerplus.objectrepository.patient.BookAppointmentPage;
import com.hc.rediagerplus.objectrepository.patient.EditPatientPage;
import com.hc.rediagerplus.objectrepository.patient.ManagePatientsPage;
import com.hc.rediagerplus.objectrepository.patient.PatientDashboardPage;
import com.hc.rediagerplus.objectrepository.patient.PatientLoginPage;

public class VerifyCompleteDoctorModuleTest extends Baseclass{
	@Test
	public void verifyCompleteDoctorModuleTest() throws IOException, InterruptedException {
		String doctorUsername=pLib.getDataFromPropertyFile("doctorUsername");
		String doctorPassword=pLib.getDataFromPropertyFile("doctorPassword");
		String patientUsername=pLib.getDataFromPropertyFile("patientUsername");
		String patientPassword=pLib.getDataFromPropertyFile("patientPassword");
		
		String doctorSpec=eLib.getDataFromExcelFile("Patient", 7, 2);
		String doctorName=eLib.getDataFromExcelFile("Patient", 7, 3);
		String date=eLib.getDataFromExcelFile("Patient", 7, 4);
		String time=eLib.getDataFromExcelFile("Patient", 7, 5);
		String particularPatientName=eLib.getDataFromExcelFile("Patient", 7, 6);
		
		String DoctorClinicAddress=eLib.getDataFromExcelFile("Doctor", 4, 8);
		String DoctorConsultationFee=eLib.getDataFromExcelFile("Doctor", 4, 9);
		String DoctorContactNo=eLib.getDataFromExcelFile("Doctor", 4, 10);
		String PatientAge=eLib.getDataFromExcelFile("Doctor", 4, 11);
		String bloodPressure=eLib.getDataFromExcelFile("Doctor", 4, 12);
		String bloodSugar=eLib.getDataFromExcelFile("Doctor", 4, 13);
		String weight=eLib.getDataFromExcelFile("Doctor", 4, 14);
		String bodyTemp=eLib.getDataFromExcelFile("Doctor", 4, 15);
		String Prescription=eLib.getDataFromExcelFile("Doctor", 4, 16);
		
		String patientName=eLib.getDataFromExcelFile("Doctor", 4, 2)+jLib.getRandomNumber();
		String patientContactNo=eLib.getDataFromExcelFile("Doctor", 4, 3);
		String patientEmail=patientName+"@gmail.com";
		String gender=eLib.getDataFromExcelFile("Doctor", 4, 4);
		String patientAddress=eLib.getDataFromExcelFile("Doctor", 4, 5);
		String patientAge=eLib.getDataFromExcelFile("Doctor", 4, 6);
		String patientMedicalHistory=eLib.getDataFromExcelFile("Doctor", 4, 7);
		
		/****************Patient Book Appointment****************/
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
		
		/****************Doctor Login & Update****************/
		hp.clickDoctorLogin(driver);
		DoctorLoginPage dlp=new DoctorLoginPage(driver);
		dlp.loginAsDoctor(doctorUsername, doctorPassword);
		DoctorDashboardPage ddp=new DoctorDashboardPage(driver);
		ddp.getDoctorDashboardUpdateProfileLnk().click();
		DoctorProfilePage dpp=new DoctorProfilePage(driver);
		dpp.updateDoctorDetails(driver,DoctorClinicAddress, DoctorConsultationFee, DoctorContactNo);
		dpp.verifyDoctorUpdate(driver);
		
		/****************Doctor cancel Appointment****************/
		ddp.getDoctorApptHistorylnk().click();
		DoctorAppointmenttHistoryPage dphp=new DoctorAppointmenttHistoryPage(driver);
		dphp.cancelParticularApt(driver, particularPatientName);
		
		/****************Add Patient****************/
		ddp.clickAddPatient();
		AddPatientPage app=new AddPatientPage(driver);
		app.addNewPatient(driver, patientName, patientContactNo, patientEmail, gender, patientAddress, patientAge, patientMedicalHistory);
		ddp.clickManagePatient();
		
		/****************Edit Particular Patient****************/
		ManagePatientsPage mpp=new ManagePatientsPage(driver);
		mpp.editingPaticularPatient(driver, patientName);
		EditPatientPage editAPatient=new EditPatientPage(driver);
		editAPatient.updatePatientAge(driver, PatientAge);
		
		/****************View Particular Patient****************/
		mpp.viewingPaticularPatient(driver, patientName);
		ViewParticularPatientPage vppp=new ViewParticularPatientPage(driver);
		vppp.clickAddMedHistoryBtn(driver);
		
        /****************Add and verify medical history****************/
		AddMedicalHistoryPage addMedHistory=new AddMedicalHistoryPage(driver);
		addMedHistory.addMedicalHistory(driver, bloodPressure, bloodSugar, weight, bodyTemp, Prescription);
		addMedHistory.verifyAddedMedHistory(driver);
		
		/****************Search Patient and verify****************/
		ddp.getDoctorPatientSearchLnk().click();
		PatientSearchPage psp=new PatientSearchPage(driver);
		psp.searchPatient(patientName);
		psp.verifyPatientSearch(patientName);
		ddp.logoutAsDoctor();
	
	}

}
