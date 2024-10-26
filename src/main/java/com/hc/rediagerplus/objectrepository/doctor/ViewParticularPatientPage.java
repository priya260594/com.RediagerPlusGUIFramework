package com.hc.rediagerplus.objectrepository.doctor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hc.rediagerplus.genericutility.WebDriverUtility;

public class ViewParticularPatientPage extends WebDriverUtility {
	@FindBy(xpath="//button[contains(text(),'Add Medical History')]")
	private WebElement addMedHistoryBtn;
	
	public ViewParticularPatientPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getAddMedHistoryBtn() {
		return addMedHistoryBtn;
	}
	public void clickAddMedHistoryBtn(WebDriver driver) {
		scrolltoEnd(driver);
		getAddMedHistoryBtn().click();
    }
	

}
