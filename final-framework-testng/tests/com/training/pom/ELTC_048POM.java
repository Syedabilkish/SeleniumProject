package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ELTC_048POM {
	private WebDriver driver; 
	
	public ELTC_048POM(WebDriver driver) {
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
	
	@FindBy(linkText="Add a user")
	private WebElement adduser;
	
	@FindBy(id="firstname")
	private WebElement firstName;
	
	@FindBy(id="lastname")
	private WebElement lastName;
	
	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(id="phone")
	private WebElement contactNo;
	
	@FindBy(id="username")
	private WebElement loginId;
	
	//@FindBy(name="password[password_auto]")
	@FindBy(xpath="//*[@id='user_add']/fieldset/div[9]/div[1]/div[2]/label")
	private WebElement enterPassword;
	
	@FindBy(id="password")
	private WebElement passwordenter;
	
	@FindBy(id="status_select")
	private WebElement profile;
	
	@FindBy(name="submit")
	private WebElement addBtn;
	
	@FindBy(xpath="//*[@id='content-section']/div/div[2]/div/div[2]")
	private WebElement msgAfterAddingUser;
	
	@FindBy(linkText="Add users to course")
	private WebElement addUserToCourse;
	
	@FindBy(name="UserList[]")
	private WebElement userList;
	
	@FindBy(name="CourseList[]")
	private WebElement courseList;
	
	@FindBy(xpath="//*[@id='content-section']/div/form[2]/table/tbody/tr[2]/td[2]/button")
	private WebElement AddedToUserList;
	
	@FindBy(xpath="//*[@id='subscribe_user2course']/fieldset/legend")
	private WebElement msgAfterAdding;
	
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
	
	public void clicadduser()
	{
		Actions builder = new Actions(driver);
		builder.moveToElement(this.adduser);
		this.adduser.click();
	}	
	public void sendfirstName(String firstName) {
		this.firstName.clear();
		this.firstName.sendKeys(firstName);
	}
	public void sendlastName(String lastName) {
		this.lastName.clear();
		this.lastName.sendKeys(lastName);
	}
	public void sendemail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	public void sendcontactno(String contactNo) {
		this.contactNo.clear();
		this.contactNo.sendKeys(contactNo);
	}
	public void sendloginid(String loginId) {
		this.loginId.clear();
		this.loginId.sendKeys(loginId);
		
	}
	public void enterpassword(){
		//Select pass = new Select(this.enterPassword); 
        //pass.selectByIndex(0);
        
        this.enterPassword.click();
	}
	public void passwordentered(String passwordenter)
	{
		this.passwordenter.clear();
		this.passwordenter.sendKeys(passwordenter);
	}
	public void selectprofile(){
		Select prof = new Select(this.profile); 
        prof.selectByIndex(0);
		//prof.selectByVisibleText("Trainer");
	}
	public void clickadd()
	{
        this.addBtn.click();
	}
	public void clickonaddUserToCourse(){
		this.addUserToCourse.click();
	}
	public void selectUserlist(){
		Select prof = new Select(this.userList); 
        prof.selectByIndex(7);
		//prof.selectByVisibleText("Trainer");
	}
	public void selectCourselist(){
		Select ul = new Select(this.courseList); 
        //prof.selectByValue("JAVA");
		ul.selectByVisibleText("(LT) Learn Testing");
		
	}
	public void clickonaddedtouserlist(){
		this.AddedToUserList.click();
	}
	public String MsgAfterUserAdded() 
	{
		return this.msgAfterAdding.getText();
	}
}
