package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ELTC_018POM 
{
	private WebDriver driver; 
	
	public ELTC_018POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="formLogin_submitAuth")
	private WebElement loginBtn;
	
	@FindBy(xpath="//*[@id='menuone']/ul[1]/li[1]/a")
	private WebElement homePage;
	
	@FindBy(xpath="//*[@id='profileCollapse']/div/ul/li[4]/a")
	private WebElement editProfile;
	
	@FindBy(id="profile_password0")
	private WebElement currpassword;
	
	@FindBy(xpath="//*[@id='password1']")
	private WebElement nwpassword;
	
	@FindBy(xpath="//*[@id='profile_password2']")
	private WebElement confirmpassword;
	
	@FindBy(name="apply_change")
	private WebElement savechangeBtn;
	
	@FindBy(xpath="//*[@id='content-section']/div/div[2]/div/div[1]")
	private WebElement passwordChanged;
	
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
	
	public void moveandclickhomePage()
	{
		Actions builder = new Actions(driver);
		builder.moveToElement(this.homePage);
		this.homePage.click();
	}
	
	public void clickeditprofile()
	{
		Actions builder1 = new Actions(driver);
		builder1.moveToElement(this.editProfile);
		this.editProfile.click();
	}
	
	public void currPassword(String currpassword) {
		Actions builder2 = new Actions(driver);
		builder2.moveToElement(this.currpassword); 
		this.currpassword.sendKeys(currpassword); 
	}
	public void newPassword(String nwpassword) {
		this.nwpassword.clear(); 
		this.nwpassword.sendKeys(nwpassword); 
	}
	public void cofirmPassword(String confirmpassword) {
		this.confirmpassword.clear(); 
		this.confirmpassword.sendKeys(confirmpassword);
		}
	public void clicksavechangeBtn(){
		this.savechangeBtn.click();
	}
	public String MsgAfterChangingPassword() 
	{
		return this.passwordChanged.getText();
	}
}

