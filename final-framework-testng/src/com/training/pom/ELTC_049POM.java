package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ELTC_049POM {
	private WebDriver driver; 
	
	public ELTC_049POM(WebDriver driver) {
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
	
	@FindBy(linkText="Classes")
	private WebElement classeslink;
	
	@FindBy(xpath="//*[@id='content-section']/div/div[2]/a[2]/img")
	private WebElement AddClass;
	
	@FindBy(id="usergroup_name")
	private WebElement ClassName;
	
	@FindBy(name="description")
	private WebElement ClassDescription;
	
	@FindBy(id="usergroup_visibility")
	private WebElement groupPermission;
	
	@FindBy(id="usergroup_submit")
	private WebElement addGroup;
	
	@FindBy(xpath="//*[@id='27']/td[6]/a[1]/img")
	private WebElement subscribeClassUser;
	
	@FindBy(id="elements_not_in")
	private WebElement userOnPlatform;
	
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
	
	@FindBy(xpath="//*[@id='content-section']/div/div[2]")
	private WebElement msgAfterClassAddition;
	
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
	
	public void clickOnClasseslink()
	{
		Actions builder = new Actions(driver);
		builder.moveToElement(this.classeslink);
		this.classeslink.click();
	}	
	public void clickOnAddClass() {
		this.AddClass.click();
	}
	public void sendclassName(String ClassName) {
		this.ClassName.clear();
		this.ClassName.sendKeys(ClassName);
	}
	public void sendeClassDescription(String ClassDescription) {
		this.ClassDescription.clear();
		this.ClassDescription.sendKeys(ClassDescription);
	}
	public void selectGroupPermission() {
		Select gp = new Select(this.groupPermission); 
        gp.selectByIndex(0);
	}
	public void clickOnAddGroup() {
		this.addGroup.click();
	}
	public void clickOnSubscribeUser(){
		
        this.subscribeClassUser.click();
	}
	public void selectuserOnPlatform(){
		Select up = new Select(this.userOnPlatform); 
        up.selectByIndex(9);
		//prof.selectByVisibleText("Trainer");
	}
	public void clickarrowtoAdd()
	{
        this.arrowToAdd.click();
	}
	public void clickonSubscribed(){
		this.subscribed.click();
	}
	public void clickOnClassSubscription(){
		this.classsubscriber.click();
	}
	public void selectCourselist(){
		Select cp = new Select(this.courseOnPlatform); 
		cp.selectByIndex(3);	
	}
	public void clickoncourseArrow(){
		this.coursearrow.click();
	}
	public void clickOnclassSubscribed(){
		this.classSubscribed.click();
	}
	public String MsgAfterUserAdded() 
	{
		return this.msgAfterClassAddition.getText();
	}
}
