package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ELTC_047POM {
 
	private WebDriver driver; 
	
	public ELTC_047POM(WebDriver driver) {
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
	
	@FindBy(linkText="Courses categories")
	private WebElement CoursesCategories;
	
	@FindBy(xpath="//*[@id='content-section']/div/div[2]/a/img")
	private WebElement AddCategory;
	
	@FindBy(name="code")
	private WebElement CategoryCode;
	
	@FindBy(name="name")
	private WebElement CategoryName;
	
	@FindBy(xpath="//*[@id='course_category']/fieldset/div[3]/div[1]/div[1]/label")
	private WebElement yesBtn;
	
	@FindBy(name="submit")
	private WebElement AddtoCategory;
	
	@FindBy(linkText="Create a course")
	private WebElement CreateCourse;
	
	@FindBy(name="title")
	private WebElement Title;
	
	@FindBy(id="visual_code")
	private WebElement code;
	
	@FindBy(name="course_teachers[]")
	private WebElement teacherName;
	
	@FindBy(name="category_code")
	private WebElement courseSelect;
	
	@FindBy(xpath="//*[@id='update_course']/fieldset/div[7]/div[1]/div/button/span[1]")
	private List<WebElement> LanguageSelect;
	
	@FindBy(name="submit")
	private WebElement clcikSubmitBtn;
	
	@FindBy(xpath="//*[@id='page-breadcrumb']/ul/li[1]/a")
	private WebElement msgAfterClass;
	
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
	
	public void clickCoursescategories()
	{
		Actions builder = new Actions(driver);
		builder.moveToElement(this.CoursesCategories);
		this.CoursesCategories.click();
	}
	public void ClickOnAddcategory() 
	{
		Actions builder = new Actions(driver);
		builder.moveToElement(this.AddCategory);
		this.AddCategory.click();
	}
	public void sendCategorycode(String CategoryCode) {
		this.CategoryCode.clear();
		this.CategoryCode.sendKeys(CategoryCode);
	}
	public void sendCategoryname(String CategoryName) {
		this.CategoryName.clear();
		this.CategoryName.sendKeys(CategoryName);
	}
	public void clickyesBtn() {
		this.yesBtn.click(); 
	}
	public void clickOnAddedToCategory() {
		this.AddtoCategory.click(); 
	}
	public void clickOnCreateCourse()
	{
		Actions builder = new Actions(driver);
		builder.moveToElement(this.CreateCourse);
		this.CreateCourse.click();
	}
	public void sendtitle(String Title) {
		this.Title.clear();
		this.Title.sendKeys(Title);
	}
	public void sendcode(String code) {
		this.code.clear();
		this.code.sendKeys(code);
	}
	public void selectTeacher(){
		Select techr = new Select(this.teacherName); 
		techr.deselectAll();
        techr.selectByIndex(3);		
	}
	public void selectcourser(){
		Select techr = new Select(this.courseSelect); 
		//techr.deselectAll();
        techr.selectByIndex(2);	 
	}
	public void selectLanguage(){
		List<WebElement> options = this.LanguageSelect;
		for(int i=0;i<options.size();i++)
		{
		    //Print the text
		    // System.out.println(options.get(i).getText());

		    String optionName = options.get(i).getText();
		    if(optionName.equals("English"))
		    {

		    options.get(i).click();
		    
		    }
		    else{
		    System.out.println("hi");
		    }
		}  
	}
	public void clickSubmitBtn() {
		this.clcikSubmitBtn.click(); 
	}
	public String MsgAfterclassAdded() 
	{
		return this.msgAfterClass.getText();
	}
}




