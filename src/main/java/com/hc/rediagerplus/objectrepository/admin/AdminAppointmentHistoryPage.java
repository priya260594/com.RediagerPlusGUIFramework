package com.hc.rediagerplus.objectrepository.admin;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hc.rediagerplus.genericutility.WebDriverUtility;

public class AdminAppointmentHistoryPage extends WebDriverUtility{
	@FindBy(xpath="//table[@class='table table-hover']/tbody/tr/td[3]")
	private List<WebElement> listOfPatients;
	
	public AdminAppointmentHistoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public List<WebElement> getListOfPatients() {
		return listOfPatients;
	}
	public void verifyPatientApptInAdmin(WebDriver driver,String patientName) {
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
