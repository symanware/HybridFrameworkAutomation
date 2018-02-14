package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
public class HomePage extends TestBase {

	public static LoginPage loginPage;
	public static ContactsPage contactsPage;
	public static NewContactPage newContactPage;
	
	@FindBy(xpath="//td[contains(text(),'User: Shilpa Manware')]")
	WebElement userNameLable;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement taskLink;
	
	
	
	public HomePage(){
		
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTitle(){
		
		String title=driver.getTitle();
		return title;
	}
	
	public Boolean verifyUserName(){
		
		return userNameLable.isDisplayed();
		
	}
	
	public ContactsPage clickOnContactsLink(){
		
		contactLink.click();
		return new ContactsPage();
	}
	
	public NewContactPage clickOnNewConatctLink(){
		
		newContactLink.click();
		return new NewContactPage();
	}
	public DealsPage clickOnDealsLink(){
		
		dealLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink(){
		
		taskLink.click();
		return new TasksPage();
	}
	
	public void clickNewContactLable(){
		
		
		Actions action= new Actions(driver);
		action.moveToElement(contactLink).build().perform();
		newContactLink.click();
		
	}
	
	
}
