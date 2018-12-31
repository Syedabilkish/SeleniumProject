/*ELTC_050: To verify whether application allows ADMIN to create training session */
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
import com.training.pom.ELTC_050POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_050 {
	private WebDriver driver;
	private String baseUrl;
	private ELTC_050POM eltc_20POM;
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
		eltc_20POM = new ELTC_050POM(driver); 
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
		screenShot.captureScreenShot("ELTC_050");
	}
	@Test(priority=2)
	public void addnewuserTest() throws InterruptedException {
        //Performing Clicking on Administration
		eltc_20POM.clicadministration();
		Thread.sleep(2000);
		//Clicking on the link Add a Session
		eltc_20POM.clickOnaAddaSessionlink();
		Thread.sleep(2000);
		//Giving the session name
		eltc_20POM.sendSessionName("New Selenium Session2");
		//Clicking on next step
		eltc_20POM.clickOnnextstep();
		screenShot.captureScreenShot("ELTC_050");
	}
	
	@Test(priority=3)
	public void AddingUserTest() throws InterruptedException {
		//Selecting the course
		eltc_20POM.selectCourselist();
		Thread.sleep(2000);
		//Clicking on add course
		eltc_20POM.clickOnAddCourse();
		Thread.sleep(2000);
		//Clicking on next step again
		eltc_20POM.clickOnnextStep2();
		Thread.sleep(2000);
		//Giving the the User name
		eltc_20POM.sendPortalUserName("Sunil Narine");
		Thread.sleep(2000);
		//Clicking on Finish button
		eltc_20POM.clickOnFinishBtn();
		Thread.sleep(2000);
		//Comparing actual with expected
		actualResult=eltc_20POM.MsgAfterUserAdded().trim();
		Thread.sleep(3000);
		screenShot.captureScreenShot("ELTC_050"); 
	}
}