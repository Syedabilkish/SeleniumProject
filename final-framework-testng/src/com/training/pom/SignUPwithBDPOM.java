package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SignUPwithBDPOM {
private WebDriver driver; 
	
	public SignUPwithBDPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Sign up!")
	private WebElement SignUp; 
	
	@FindBy(id="registration_firstname")
	private WebElement FirstName;
	
	@FindBy(id="registration_lastname")
	private WebElement LastName;
	
	@FindBy(id="registration_email")
	private WebElement email;
	
	@FindBy(id="username")
	private WebElement username;
	
	@FindBy(id="pass1")
	private WebElement password;
	
	@FindBy(id="pass2")
	private WebElement password2;
	
	@FindBy(id="registration_phone")
	private WebElement phone_no;
	
	@FindBy(xpath="//*[@id='registration']/fieldset/div[12]/div[1]/div/label")
	private WebElement RadioBtn;
	
	@FindBy(id="registration_submit")
	private WebElement submitBtn;
	
	
	
	public void SignUplink() {
		this.SignUp.click();
	}
	
	public void sendFirstName(String FirstName) {
		this.FirstName.clear(); 
		this.FirstName.sendKeys(FirstName); 
	}
	public void sendLastName(String LastName){
		this.LastName.clear(); 
		this.LastName.sendKeys(LastName);
	}
	public void sendEmail(String Email_id){
		this.email.clear(); 
		this.email.sendKeys(Email_id);
	}
	public void sendUserid(String username){
		this.username.sendKeys(username);
	}
	public void sendpassword(String password)
	{
		this.password.sendKeys(password);
	}
	
	public void sendpassword2(String password2){
		this.password2.sendKeys(password2);
	}
	public void sendphoneNo(String phone_no){
		this.phone_no.sendKeys(phone_no);
	}
	public void clickRadioBtn(){
		this.RadioBtn.click();
	}
	public void clickRegistrationBtn() {
		this.submitBtn.click(); 
	}
	
}
