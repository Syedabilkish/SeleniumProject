/*ELTC_019: To verify after successful login user should able to click on User list to get the listed 
 * user displayed */
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
import com.training.pom.ELTC_019POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_019 {
	private WebDriver driver;
	private String baseUrl;
	private ELTC_019POM eltc_019POM;
	private static Properties properties;
	private ScreenShot screenShot;
	private String actualResult;
	private String expectedResult = "User list";

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		eltc_019POM = new ELTC_019POM(driver); 
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
		//Performing Valid login
		eltc_019POM.sendUserName("admin");
		eltc_019POM.sendPassword("admin@123");
		eltc_019POM.clickLoginBtn(); 
		Thread.sleep(1000);
		screenShot.captureScreenShot("ELTC_019");
	}
	@Test(priority=2)
	public void userlistTest() throws InterruptedException {
		//Clicking on the Administration link 
		eltc_019POM.clicadministration();
		Thread.sleep(2000);
		//Clicking on user list so that the listed user should get displayed
		eltc_019POM.clicuserlist();
		//Comparing the actual and expected result
		actualResult=eltc_019POM.MsgOnClickingUserlist().trim();
		screenShot.captureScreenShot("ELTC_019");
	}
	
}