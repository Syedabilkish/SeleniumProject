package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ELTC_20POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_20 {
	private WebDriver driver;
	private String baseUrl;
	private ELTC_20POM eltc_20POM;
	private static Properties properties;
	private ScreenShot screenShot;
	private String actualResult;
	private String expectedResult = "The user has been added:";

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		eltc_20POM = new ELTC_20POM(driver); 
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
		//performing valid login
		eltc_20POM.sendUserName("admin");
		eltc_20POM.sendPassword("admin@123");
		eltc_20POM.clickLoginBtn(); 
		Thread.sleep(1000);
		screenShot.captureScreenShot("ELTC_20");
	}
	@Test(priority=2)
	public void addnewuserTest() throws InterruptedException {
        //Performing Clicking on Administration
		eltc_20POM.clicadministration();
		Thread.sleep(2000);
		//Clicking on Add new User
		eltc_20POM.clicadduser();
		Thread.sleep(2000);
		//Giving the first Name
		eltc_20POM.sendfirstName("Rahim1");
		//Giving the last Name
		eltc_20POM.sendlastName("Miah");
		//Giving Email id
		eltc_20POM.sendemail("rahim.pinky@mail.com");
		//Giving Phone no
		eltc_20POM.sendcontactno("1234567890");
		//setting login id
		eltc_20POM.sendloginid("rahim");
		Thread.sleep(3000);
		eltc_20POM.enterpassword();
		Thread.sleep(3000);
		eltc_20POM.passwordentered("rahim");
		Thread.sleep(3000);
		eltc_20POM.selectprofile();
		Thread.sleep(3000);
		eltc_20POM.clickadd();
		Thread.sleep(3000);
		actualResult=eltc_20POM.MsgAfterUserAdded().trim();
		Thread.sleep(3000);
		screenShot.captureScreenShot("ELTC_20");
	}
	
}