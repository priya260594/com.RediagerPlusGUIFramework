package com.hc.rediagerplus.objectrepository.admin;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class AddSpecializationPage {
	@FindBy(name="doctorspecilization")
	private WebElement docSpecializationEdt;
	
	@FindBy(name="submit")
	private WebElement submitBtn;
	
	@FindBy(xpath="//p[contains(text(),'Doctor Specialization added successfully !!')]")
	private WebElement verifyDocSpec;
	
	@FindBy(xpath="(//table[@class='table table-hover']/tbody/tr/td[2])[last()]")
	private WebElement specializationList;
	
	public AddSpecializationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getDocSpecializationEdt() {
		return docSpecializationEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	public void addSpecialization(String docSpec) {
		docSpecializationEdt.sendKeys(docSpec);
		submitBtn.click();
	}
	public void verifyDocSpecialization(String doctorSpec) {
		String actualText=verifyDocSpec.getText();
		String expectedText="Doctor Specialization added successfully !!";
		Assert.assertEquals(actualText, expectedText);
		Assert.assertEquals(specializationList.getText(), doctorSpec);
	}

	
}

