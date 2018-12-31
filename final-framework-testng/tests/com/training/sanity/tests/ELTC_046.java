/*ELTC_046: To verify whether application allows student to comment on the task assigned in the project
 * Note: If the course is not subscribed by the student then the task can not be assigned to the student */
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
import com.training.pom.ELTC_046POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_046 {
	private WebDriver driver;
	private String baseUrl;
	private ELTC_046POM eltc_20POM;
	private static Properties properties;
	private ScreenShot screenShot;
	private String actualResult;
	private String expectedResult = "You comment has been added";

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		eltc_20POM = new ELTC_046POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		
	}

	
	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
	@Test(priority=1)
	public void validLoginTest() throws InterruptedException {
		//performing valid login as a student
		eltc_20POM.sendUserName("student8");
		eltc_20POM.sendPassword("student");
		eltc_20POM.clickLoginBtn(); 
		Thread.sleep(1000);
		//Clicking on Course Catalog
		eltc_20POM.clickOnCourseCatalog();
		Thread.sleep(2000);
		//Searching for course
		eltc_20POM.sendTextinSearchBox("New Course Student");
		Thread.sleep(2000);
		//Clicking on the search icon
		eltc_20POM.clickOnsearchicon();
		Thread.sleep(2000);
		//Subscribing the course
		eltc_20POM.clickOnSubscribeBtn();
		Thread.sleep(2000);
		//Performing Logout
		eltc_20POM.clickOnicon();
		Thread.sleep(2000);
		eltc_20POM.ClickOnLogout();
		Thread.sleep(2000);
		screenShot.captureScreenShot("ELTC_046");
	}
	@Test(priority=2)
	public void teacherassigningroleTest() throws InterruptedException {
        //login as Teacher
		eltc_20POM.sendUserName("teacher");
		eltc_20POM.sendPassword("teacher");
		eltc_20POM.clickLoginBtn(); 
		Thread.sleep(1000);
		//Clicking on the Course
		eltc_20POM.clickOnTeachercourseLink();
		Thread.sleep(2000);
		//Clicking on Project
		eltc_20POM.clickOnProject();
		Thread.sleep(2000);
		//Clicking On User Management
		eltc_20POM.clickOnTeacherUserManagement();
		Thread.sleep(2000);
		//Performing Registration
		eltc_20POM.ClickOnTeacherCheckBox();
		Thread.sleep(2000);
		eltc_20POM.clickOnRegister();
		Thread.sleep(2000);
		//Performing Logout
		eltc_20POM.clickOnicon();
		Thread.sleep(2000);
		eltc_20POM.ClickOnLogout();
		Thread.sleep(2000);
		screenShot.captureScreenShot("ELTC_046");
		
	}
	@Test(priority=3)
	public void studenttaskTest() throws InterruptedException {
		//Again login as a student
		eltc_20POM.sendUserName("student8");
		eltc_20POM.sendPassword("student");
		eltc_20POM.clickLoginBtn(); 
		Thread.sleep(1000);
		//Clicking on subscribed course link
		eltc_20POM.clickOnTeachercourseLink();
		Thread.sleep(2000);
		//Clicking on Project
		eltc_20POM.clickOnProject();
		Thread.sleep(2000);
		//Clicking on the task
		eltc_20POM.clickOnTask();
		Thread.sleep(2000);
		//Clicking on Home
		eltc_20POM.clickOnHome();
		Thread.sleep(2000);
		//Clicking on the task
		eltc_20POM.clickOnTask();
		Thread.sleep(2000);
		//Sending the title 
		eltc_20POM.sendTitle("My Task Completed");
		Thread.sleep(4000);
		//Sending the text
		eltc_20POM.sendCommentText("Done");
		Thread.sleep(2000);
		//clicking on save
		eltc_20POM.clickSaveBtn();
		Thread.sleep(2000);
		//Comparing actual and expected
		actualResult=eltc_20POM.MsgAfterCommentAdded().trim();
		Thread.sleep(3000);
		screenShot.captureScreenShot("ELTC_046");
	}
}