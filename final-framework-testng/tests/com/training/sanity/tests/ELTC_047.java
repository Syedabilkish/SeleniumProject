/*ELTC_047: TO verify whether application allows ADMIN to create a category & course on the category */
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
import com.training.pom.ELTC_047POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_047 {
	private WebDriver driver;
	private String baseUrl;
	private ELTC_047POM eltc_047POM;
	private static Properties properties;
	private ScreenShot screenShot;
	private String actualResult;
	private String expectedResult = "Course New Course added";

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		eltc_047POM = new ELTC_047POM(driver); 
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
		eltc_047POM.sendUserName("admin");
		eltc_047POM.sendPassword("admin@123");
		eltc_047POM.clickLoginBtn(); 
		Thread.sleep(1000);
		screenShot.captureScreenShot("ELTC_047");
	}
	@Test(priority=2)
	public void userlistTest() throws InterruptedException {
		//Clicking on the Administration link 
		eltc_047POM.clicadministration();
		Thread.sleep(2000);
		//Clicking on Course categories link
		eltc_047POM.clickCoursescategories();
		Thread.sleep(3000);
		//Clicking on add category
		eltc_047POM.ClickOnAddcategory();
		Thread.sleep(3000);
		//Sending Category code
		eltc_047POM.sendCategorycode("BL");
		Thread.sleep(3000);
		//Sending Category Name
		eltc_047POM.sendCategoryname("Blended Learning");
		Thread.sleep(3000);
		//Clicking on yes btn
		eltc_047POM.clickyesBtn();
		Thread.sleep(3000);
		//Clicking on Added
		eltc_047POM.clickOnAddedToCategory();
		Thread.sleep(3000);
		screenShot.captureScreenShot("ELTC_047");
		
	}
	@Test(priority=3)
	public void createnewcourseTest() throws InterruptedException {
		//Clicking on the Administration link 
		eltc_047POM.clicadministration();
		Thread.sleep(2000);
		//Clicking on the Create Course
		eltc_047POM.clickOnCreateCourse();
		Thread.sleep(1000);
		//Giving the Course name
		eltc_047POM.sendtitle("Learn Testing3");
		Thread.sleep(1000);
		//Giving the code
		eltc_047POM.sendcode("LT");
		Thread.sleep(1000);
		//Selecting the teacher
		eltc_047POM.selectTeacher();
		Thread.sleep(1000);
		//Selecting course
		eltc_047POM.selectcourser();
		Thread.sleep(1000);
		//Language selection
		eltc_047POM.selectLanguage();
		Thread.sleep(2000);
		//Final submission
		eltc_047POM.clickSubmitBtn();
		Thread.sleep(2000);
		screenShot.captureScreenShot("ELTC_047_3");
		//Comparing the actual and expected result
		actualResult=eltc_047POM.MsgAfterclassAdded().trim();
		screenShot.captureScreenShot("ELTC_047");
		
	}
}