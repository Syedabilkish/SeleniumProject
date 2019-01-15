package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.dataproviders.SignUpDataProvider_077;
import com.training.generics.ScreenShot;
import com.training.pom.SignUpPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_077Test {
	private WebDriver driver;
	private String baseUrl;
	private SignUpPOM signupPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		signupPOM = new SignUpPOM(driver);
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

	@Test(dataProvider = "excel-inputs", dataProviderClass = SignUpDataProvider_077.class)
	public void loginDBTest(String FirstName, String LastName, String email, String username, String password, String password2, String phone_no) throws InterruptedException 
	{
		signupPOM.SignUplink();
		signupPOM.sendFirstName(FirstName);
		signupPOM.sendLastName(LastName);
		signupPOM.sendEmail(email);
		signupPOM.sendUserid(username);
		signupPOM.sendpassword(password);
		signupPOM.sendpassword2(password2);
		signupPOM.sendphoneNo(phone_no);
		signupPOM.sendRadioBtn();
		Thread.sleep(2000);
		signupPOM.clickRegistrationBtn();
		Thread.sleep(2000);
		screenShot.captureScreenShot();

	}

}