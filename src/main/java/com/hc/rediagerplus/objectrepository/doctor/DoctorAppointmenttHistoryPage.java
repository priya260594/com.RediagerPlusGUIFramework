package com.hc.rediagerplus.objectrepository.doctor;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hc.rediagerplus.genericutility.WebDriverUtility;
import com.mysql.cj.jdbc.Driver;

public class DoctorAppointmenttHistoryPage extends WebDriverUtility{
	@FindBy(xpath="//table[@class='table table-hover']/tbody/tr/td[@class='hidden-xs']")
	private List<WebElement> listOfPatients;
	
//	@FindBy(xpath="(//table[@class='table table-hover']/tbody/tr/td[8])[last()]")
//	private WebElement LastCancelButton;
			
	public DoctorAppointmenttHistoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getListOfPatients() {
		return listOfPatients;
	}

	public void cancelParticularApt(WebDriver driver,String selectedPatientName) throws InterruptedException {
		driver.findElement(By.xpath("//td[@class='hidden-xs' and text()='"+selectedPatientName+"']/parent::tr/td/div/a[@title='Cancel Appointment']")).click();
		Thread.sleep(2000);
		confirmAlert(driver);
	}

	public void verifyPatientApptInDoctor(WebDriver driver,String patientName) throws InterruptedException {
		scrolltoEnd(driver);
		boolean flag=false;
        for(WebElement listOfPatient:listOfPatients) {
			if(listOfPatient.getText().equals(patientName)) {
				flag=true;
			}
		}
		Assert.assertTrue(flag);
	}
}
