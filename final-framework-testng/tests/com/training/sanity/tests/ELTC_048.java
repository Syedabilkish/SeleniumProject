/*ELTC_048: TO verify whether application allows ADMIN to create an user & register user to the course */
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
import com.training.pom.ELTC_048POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_048 {
	private WebDriver driver;
	private String baseUrl;
	private ELTC_048POM eltc_20POM;
	private static Properties properties;
	private ScreenShot screenShot;
	private String actualResult;
	private String expectedResult = "Add users to course:";

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		eltc_20POM = new ELTC_048POM(driver); 
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
		eltc_20POM.sendfirstName("Pinky2");
		//Giving the last Name
		eltc_20POM.sendlastName("Ss3");
		//Giving Email id
		eltc_20POM.sendemail("pinky1@mail.com");
		//Giving Phone no
		eltc_20POM.sendcontactno("1234567890");
		//setting login id
		eltc_20POM.sendloginid("pinky10");
		Thread.sleep(2000);
		//Enter Password
		eltc_20POM.enterpassword();
		Thread.sleep(3000);
		//Giving the Password
		eltc_20POM.passwordentered("pink");
		Thread.sleep(1000);
		//Select profile
		eltc_20POM.selectprofile();
		Thread.sleep(1000);
		//Click on add
		eltc_20POM.clickadd();
		Thread.sleep(1000);
		//Clicking on administration link
		eltc_20POM.clicadministration();
		Thread.sleep(2000);
		//Clicking on Add to Course link
		eltc_20POM.clickonaddUserToCourse();
		Thread.sleep(2000);
		//Selecting user from the list
		eltc_20POM.selectUserlist();
		Thread.sleep(2000);
		//Select Course 
		eltc_20POM.selectCourselist();
		Thread.sleep(2000);
		//Clicking on Add to User list
		eltc_20POM.clickonaddedtouserlist();
		Thread.sleep(2000);
	}
	@Test(priority=3)
	public void AddingUserTest() throws InterruptedException {
		//Click On Administration
		eltc_20POM.clicadministration();
		Thread.sleep(2000);
		//Click on Add user to course link
		eltc_20POM.clickonaddUserToCourse();
		Thread.sleep(2000);
		//Select user
		eltc_20POM.selectUserlist();
		Thread.sleep(2000);
		//select course
		eltc_20POM.selectCourselist();
		Thread.sleep(2000);
		//Clicking on Added
		eltc_20POM.clickonaddedtouserlist();
		Thread.sleep(2000);
		//Comparing actual with expected
		actualResult=eltc_20POM.MsgAfterUserAdded().trim();
		Thread.sleep(3000);
		screenShot.captureScreenShot("ELTC_048");
	}
}