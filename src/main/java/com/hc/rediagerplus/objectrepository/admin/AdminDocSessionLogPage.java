package com.hc.rediagerplus.objectrepository.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AdminDocSessionLogPage {
	@FindBy(xpath="(//table[@class='table table-hover']/tbody/tr/td[@class='hidden-xs'])[last()]")
	private WebElement recentDoctorLog;
	
	public AdminDocSessionLogPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getRecentDoctorLog() {
		return recentDoctorLog;
	}
	
	public void verifyRecentlyAddedDocName(String doctorEmail) {
		Assert.assertEquals(recentDoctorLog.getText(), doctorEmail);
	}

}
