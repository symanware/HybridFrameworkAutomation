package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;


public class ContactsPage extends TestBase{
	
	public HomePage homePage;
	public ContactsPage contactPage;
	
	
	
	@FindBy(xpath="//select[@name='title']")
	WebElement title;
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement fName;
	
	@FindBy(xpath="//input[@id='surname']")
	WebElement lName;
	
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement company;
	
	@FindBy(xpath="//*[@id='contactForm']/table/tbody/tr[1]/td/input[2]")
	WebElement submit;
	
	
	
	public ContactsPage(){
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	public void createNewContact(String tle,String firstName, String lastName,String comp){
		
		
		Select select= new Select(title);
		select.selectByVisibleText(tle);
		
		fName.sendKeys(firstName);
		lName.sendKeys(lastName);
		company.sendKeys(comp);
		submit.click();
		
		
		
		
	}
	
}
