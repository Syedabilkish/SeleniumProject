/*ELTC_049: TO verify whether application allows ADMIN to add classes, subscribe user to class, 
 * subscribe class to course & subscribe class to sessions */
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
import com.training.pom.ELTC_049POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_049 {
	private WebDriver driver;
	private String baseUrl;
	private ELTC_049POM eltc_20POM;
	private static Properties properties;
	private ScreenShot screenShot;
	private String actualResult;
	private String expectedResult = "Update successful:";

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		eltc_20POM = new ELTC_049POM(driver); 
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
		screenShot.captureScreenShot("ELTC_049");
	}
	@Test(priority=2)
	public void addnewuserTest() throws InterruptedException {
        //Performing Clicking on Administration
		eltc_20POM.clicadministration();
		Thread.sleep(2000);
		//Clicking on classes link
		eltc_20POM.clickOnClasseslink();
		Thread.sleep(2000);
		//Clicking On Add class 
		eltc_20POM.clickOnAddClass();
		//Giving the class name
		eltc_20POM.sendclassName("Quick Learn");
		//Giving the Class Description
		eltc_20POM.sendeClassDescription("Quick");
		//Selecting the Group permission
		eltc_20POM.selectGroupPermission();
		//Clicking on Add group
		eltc_20POM.clickOnAddGroup();
		Thread.sleep(2000);
		screenShot.captureScreenShot("ELTC_049");
	}
	@Test(priority=3)
	public void AddingUserTest() throws InterruptedException {
		//Clicking on Subscriber
		eltc_20POM.clickOnSubscribeUser();
		Thread.sleep(2000);
		//Selecting the user on Platform
		eltc_20POM.selectuserOnPlatform();
		Thread.sleep(2000);
		//Clicking on arrow
		eltc_20POM.clickarrowtoAdd();
		Thread.sleep(2000);
		//subscribing the class
		eltc_20POM.clickonSubscribed();
		Thread.sleep(2000);
		//Clicking on Class subscription
		eltc_20POM.clickOnClassSubscription();
		Thread.sleep(2000);
		//Selecting course list
		eltc_20POM.selectCourselist();
		Thread.sleep(2000);
		//clicking on Arrow
		eltc_20POM.clickoncourseArrow();
		Thread.sleep(2000);
		//Clicking on final subscription
		eltc_20POM.clickOnclassSubscribed();
		Thread.sleep(2000);
		//Comparing actual with expected
		actualResult=eltc_20POM.MsgAfterUserAdded().trim();
		Thread.sleep(3000);
		screenShot.captureScreenShot("ELTC_048");
	}
}