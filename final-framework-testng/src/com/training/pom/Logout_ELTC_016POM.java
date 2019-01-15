
package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Logout_ELTC_016POM {
	private WebDriver driver; 
	
	public Logout_ELTC_016POM(WebDriver driver) {
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
	
	@FindBy(xpath="//*[@id='content-section']/div/div[2]/div[2]/div/section/div[1]/h4")
	private WebElement AfterLogout;
	
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
		builder.moveToElement(this.imgCircle).build().perform();
		this.imgCircle.click();
	}
	
	public void clicklogoutBtn()
	{
		Actions builder1 = new Actions(driver);
		builder1.moveToElement(this.logoutBtn).build().perform();
		this.logoutBtn.click();
	}
	public String MsgAfterlogout() 
	{
		return this.AfterLogout.getText();
	}
}
