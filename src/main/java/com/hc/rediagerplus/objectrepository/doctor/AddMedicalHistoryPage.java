package com.hc.rediagerplus.objectrepository.doctor;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hc.rediagerplus.genericutility.WebDriverUtility;

public class AddMedicalHistoryPage extends WebDriverUtility {
	@FindBy(name = "bp")
	private WebElement bloodPressureEdt;

	@FindBy(name = "bs")
	private WebElement bloodSugarEdt;

	@FindBy(name = "weight")
	private WebElement weightEdt;

	@FindBy(name = "temp")
	private WebElement tempEdt;

	@FindBy(name = "pres")
	private WebElement prescriptionEdt;

	@FindBy(name = "submit")
	private WebElement submitBtn;

	public AddMedicalHistoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getBloodPressureEdt() {
		return bloodPressureEdt;
	}

	public WebElement getBloodSugarEdt() {
		return bloodSugarEdt;
	}

	public WebElement getWeightEdt() {
		return weightEdt;
	}

	public WebElement getTempEdt() {
		return tempEdt;
	}

	public WebElement getPrescriptionEdt() {
		return prescriptionEdt;
	}

	public WebElement getsubmitBtn() {
		return submitBtn;
	}

	public void addMedicalHistory(WebDriver driver, String bloodPressure, String bloodSugar, String weight, String temp,
			String prescription) throws InterruptedException {
		scrolltoEnd(driver);
		bloodPressureEdt.sendKeys(bloodPressure);
		bloodSugarEdt.sendKeys(bloodSugar);
		weightEdt.sendKeys(weight);
		tempEdt.sendKeys(temp);
		prescriptionEdt.sendKeys(prescription, Keys.TAB, Keys.TAB, Keys.ENTER);
		Thread.sleep(1000);
	}

	public void verifyAddedMedHistory(WebDriver driver) throws InterruptedException {
		String actualText = getAlertText(driver);
		String expectedText = "Medicle history has been added.";
		Assert.assertEquals(actualText, expectedText);
		Thread.sleep(1000);
		confirmAlert(driver);
	}

}
