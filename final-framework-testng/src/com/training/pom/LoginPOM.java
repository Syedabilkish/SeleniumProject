package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="formLogin_submitAuth")
	private WebElement loginBtn;
	
	@FindBy(xpath="//*[@id='menuone']/ul[2]/li[2]/a/img")
	private WebElement imgCircle;
	
	@FindBy(id="logout_button")
	private WebElement logoutBtn;
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void movemouseimgCircle()
	{
		Actions builder = new Actions(driver);
		builder.moveToElement(this.imgCircle);
		this.imgCircle.click();
	}
	
	public void clicklogoutBtn()
	{
		Actions builder1 = new Actions(driver);
		builder1.moveToElement(this.logoutBtn);
		this.logoutBtn.click();
	}
}
