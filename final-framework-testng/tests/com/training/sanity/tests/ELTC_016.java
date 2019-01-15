/* For ELTC_106 the below script is written to verify successful logout */
package com.training.sanity.tests;

import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.pom.Logout_ELTC_016POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class ELTC_016 {
	private WebDriver driver;
	private String baseUrl;
	private Logout_ELTC_016POM logoutPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private String actualResult;
	private String expectedResult = "Most popular courses";

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		logoutPOM = new Logout_ELTC_016POM(driver); 
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
		//Performing the login with the below credential
		logoutPOM.sendUserName("admin");
		logoutPOM.sendPassword("admin@123");
		logoutPOM.clickLoginBtn();
		Thread.sleep(1000);
		screenShot.captureScreenShot("ELTC_016");
		
	}
	@Test(priority=2)
	public void validLogoutTest() throws InterruptedException {
		Thread.sleep(1000);
		//Moving mouse on the icon
		logoutPOM.movemouseimgCircle();
		Thread.sleep(1000);
		//Clicking on Logout
		logoutPOM.clicklogoutBtn();
		Thread.sleep(1000);
		//comparing the actual and expected
		actualResult=logoutPOM.MsgAfterlogout().trim();
		Thread.sleep(1000);
		screenShot.captureScreenShot("ELTC_016");
		
	}
}
