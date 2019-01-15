package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ELTC_046POM {
	private WebDriver driver; 
	
	public ELTC_046POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="formLogin_submitAuth")
	private WebElement loginBtn;
	
	@FindBy(xpath="//*[@id='homepage-course']/div/a")
	private WebElement CourseCatalog;
	
	@FindBy(name="search_term")
	private WebElement SearchBox;
	
	@FindBy(xpath="//*[@id='content-section']/div/div[2]/div[1]/div/div/div[1]/form/div/div/button")
	private WebElement Searchicon;
	
	@FindBy(xpath="//*[@id='content-section']/div/div[2]/div[2]/div/div/div/div[2]/div[4]/div[2]/div/a")
	private WebElement CourseSubscription;
	
	@FindBy(xpath="//*[@id='page']/div/div/div/div/div[2]/h4/a")
	private WebElement TeachercourseLink;
	
	@FindBy(xpath="//*[@id='toolbar']/div/div/a[4]/img")
	private WebElement TeacherUserManagement;
	
	@FindBy(name="user[]")
	private WebElement TeacherClickCheckBox;
	
	//@FindBy(xpath="//*[@id='tablename5c29cedd9ebc1']/tbody/tr[2]/td[5]")
	@FindBy(linkText="Register")
	private WebElement TeacherRegister;
	
	@FindBy(xpath="//*[@id='menuone']/ul[2]/li[2]/a")
	private WebElement logoutBtn;
	
	@FindBy(id="logout_button")
	private WebElement logout;
	
	@FindBy(xpath="//*[@id='content-section']/div/div[3]/div[2]/div/div[4]/div/div[2]/div[1]/h4/a")
	private WebElement CourseLink;
	
	@FindBy(id="istooldesc_829")
	private WebElement Project;
	
	@FindBy(xpath="//*[@id='post-24']/div/div/h3/a")
	private WebElement TaskAssigned;
	
	@FindBy(xpath="//*[@id='toolbar']/div/div/a[1]/img")
	private WebElement Home;
	
	@FindBy(id="add_post_title")
	private WebElement Commenttitle;
	
	@FindBy(xpath="//*[@id='cke_1_contents']/iframe")
	private WebElement CommentText;
	
	@FindBy(id="add_post_save")
	private WebElement SaveBtn;
	
	@FindBy(xpath="//*[@id='content-section']/div/div[2]/div/div[2]")
	private WebElement msgAfterSaving;
	
	
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
	
	public void clickOnCourseCatalog()
	{
		Actions builder = new Actions(driver);
		builder.moveToElement(this.CourseCatalog);
		this.CourseCatalog.click();
	}
	public void sendTextinSearchBox(String SearchBox) {
		this.SearchBox.clear(); 
		this.SearchBox.sendKeys(SearchBox);
	}
	public void clickOnsearchicon(){
		this.Searchicon.click();
	}
	public void clickOnSubscribeBtn()
	{
		Actions builder = new Actions(driver);
		builder.moveToElement(this.CourseSubscription);
		this.CourseSubscription.click();
	}	
	public void clickOnicon(){
		this.logoutBtn.click();
	}
	public void ClickOnLogout(){
		this.logout.click();
	}
	public void clickOnTeachercourseLink(){
		this.TeachercourseLink.click();
	}
	public void clickOnTeacherUserManagement(){
		this.TeacherUserManagement.click();
	}
	public void ClickOnTeacherCheckBox(){
		this.TeacherClickCheckBox.click();
	}
	public void clickOnRegister(){
		this.TeacherRegister.click();
	}
	public void ClickOnCourseLink() {
		this.CourseLink.click();
	}
	public void clickOnProject() {
		this.Project.click();
	}
	public void clickOnTask() {
        this.TaskAssigned.click();
	}
	public void clickOnHome(){
		 this.Home.click();
	}
	public void sendTitle(String Commenttitle){
		this.Commenttitle.clear();
		this.Commenttitle.sendKeys(Commenttitle);
	}
	public void sendCommentText(String CommentText)
	{
        this.CommentText.sendKeys(CommentText);
	}
	public void clickSaveBtn(){
		this.SaveBtn.click();
	}
	public String MsgAfterCommentAdded() 
	{
		return this.msgAfterSaving.getText();
	}
}
