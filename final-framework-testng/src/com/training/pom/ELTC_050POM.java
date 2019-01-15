package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ELTC_050POM {
	private WebDriver driver; 
	
	public ELTC_050POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="formLogin_submitAuth")
	private WebElement loginBtn;
	
	@FindBy(xpath="//*[@id='menuone']/ul[1]/li[7]/a")
	private WebElement administration;
	
	@FindBy(linkText="Add a training session")
	private WebElement AddaSession;
	
	@FindBy(id="add_session_name")
	private WebElement sessionName;
	
	@FindBy(id="add_session_submit")
	private WebElement NextStep;
	
	@FindBy(id="origin")
	private WebElement CourseList;
	
	@FindBy(name="add_course")
	private WebElement addCourse;
	
	@FindBy(name="next")
	private WebElement nextStep2;
	
	@FindBy(id="user_to_add")
	private WebElement portalUserName;
	
	@FindBy(xpath="//*[@id='multiple-add-session']/div[2]/div/button")
	private WebElement finishSessionCreation;
	
	@FindBy(xpath="//*[@id='content-section']/div/form/div/div[2]/div/button[1]")
	private WebElement arrowToAdd;
	
	@FindBy(xpath="//*[@id='content-section']/div/form/button")
	private WebElement subscribed;
	
	@FindBy(xpath="//*[@id='27']/td[6]/a[2]/img")
	private WebElement classsubscriber;
	
	@FindBy(id="elements_not_in")
	private WebElement courseOnPlatform;
	
	@FindBy(xpath="//*[@id='content-section']/div/form/table/tbody/tr[3]/td[2]/button[1]")
	private WebElement coursearrow;
	
	@FindBy(xpath="//*[@id='content-section']/div/form/table/tbody/tr[4]/td/button")
	private WebElement classSubscribed;
	
	@FindBy(xpath="//*[@id='content-section']/div/div[2]/div/h3[1]")
	private WebElement msgafterFinish;
	
	
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
	
	public void clicadministration()
	{
		Actions builder = new Actions(driver);
		builder.moveToElement(this.administration);
		this.administration.click();
	}
	
	public void clickOnaAddaSessionlink()
	{
		Actions builder = new Actions(driver);
		builder.moveToElement(this.AddaSession);
		this.AddaSession.click();
	}	
	public void sendSessionName(String sessionName) {
		this.sessionName.clear();
		this.sessionName.sendKeys(sessionName);
	}
	public void clickOnnextstep() {
		this.NextStep.click();
	}
	public void selectCourselist() {
		Select cl = new Select(this.CourseList); 
        cl.selectByIndex(3);
	}
	public void clickOnAddCourse(){
		 this.addCourse.click();
	}
	public void clickOnnextStep2(){
		this.nextStep2.click();
	}
	public void sendPortalUserName(String portalUserName)
	{
        this.portalUserName.clear();
        this.portalUserName.sendKeys(portalUserName);
	}
	public void clickOnFinishBtn(){
		this.finishSessionCreation.click();
	}
	public String MsgAfterUserAdded() 
	{
		return this.msgafterFinish.getText();
	}
}
