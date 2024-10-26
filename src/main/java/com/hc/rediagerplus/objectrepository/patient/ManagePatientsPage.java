package com.hc.rediagerplus.objectrepository.patient;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.hc.rediagerplus.genericutility.WebDriverUtility;

public class ManagePatientsPage extends WebDriverUtility{

	public ManagePatientsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void editingPaticularPatient(WebDriver driver,String patientName) {
		scrolltoEnd(driver);
		driver.findElement(By.xpath("//table[@id='sample-table-1']/tbody/tr/td[contains(text(),'"+patientName+"')]/../td/a/i[@class='fa fa-edit']")).click();
	}
	public void viewingPaticularPatient(WebDriver driver,String patientName) {
		scrolltoEnd(driver);
		driver.findElement(By.xpath("//table[@id='sample-table-1']/tbody/tr/td[contains(text(),'"+patientName+"')]/../td/a/i[@class='fa fa-eye']")).click();
	}

}
