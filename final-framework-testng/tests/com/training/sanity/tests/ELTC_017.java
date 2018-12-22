package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ELTC_017POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_017 {

	private WebDriver driver;
	private String baseUrl;
	private ELTC_017POM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private String actualResult;
	private String expectedResult = "User";

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new ELTC_017POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		//Performing Login Activity
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		
		loginPOM.clickLoginBtn();
		Thread.sleep(1000);
		
		//Comparing Actual and expected
		actualResult=loginPOM.MsgAfterlogin().trim();
		screenShot.captureScreenShot("ELTC_017");
	}
}
