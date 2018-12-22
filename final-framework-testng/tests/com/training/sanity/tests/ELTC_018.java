/*ELTC_018: Admin should able to change the password successfully */
package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ELTC_018POM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class ELTC_018 
{
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private ELTC_018POM ChangePasswordPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private String actualResult;
	private String expectedResult = "Your new profile has been saved";

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		ChangePasswordPOM = new ELTC_018POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	
	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test(priority=1)
	public void validLoginTest() throws InterruptedException {
		//Performing valid login
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("bilkish@1234");
		loginPOM.clickLoginBtn(); 
		Thread.sleep(1000);
		screenShot.captureScreenShot("ELTC_0182");
	}
	@Test(priority=2)
	public void changePasswordTest() throws InterruptedException {
		//Clicking on HomePage
		ChangePasswordPOM.moveandclickhomePage();
		//Click on Edit Profile
		ChangePasswordPOM.clickeditprofile();
		Thread.sleep(1000);
	    //Giving the existing Password
		ChangePasswordPOM.currPassword("bilkish@1234");
		//Giving new Password
		ChangePasswordPOM.newPassword("admin@123");
		//Confirming new Password
		ChangePasswordPOM.cofirmPassword("admin@123");
		//Clicking on save button
		ChangePasswordPOM.clicksavechangeBtn();
		actualResult=ChangePasswordPOM.MsgAfterChangingPassword().trim();
		screenShot.captureScreenShot("ELTC_0182");
	}
}

