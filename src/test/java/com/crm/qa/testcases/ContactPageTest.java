package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase { 
	
	public ContactsPage contactPage=null;
	public HomePage homePage;
	public LoginPage loginPage;
	
	ContactPageTest(){
		
		super();
	}
	
	@BeforeMethod
	public void setup(){
		
		initialization();
		contactPage= new ContactsPage();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	}
	
	
	@Test(priority=1)
	public void verifyContactsPageLable(){
		
		TestUtil.switchToFrame();
		homePage.clickNewContactLable();
		//Assert.assertTrue(homePage.verifyNewContactLable(),"Contact lable is missing on page");
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		
		Object[][] data= TestUtil.getData();
		return data;
	}
	
	@Test(priority=2,dataProvider="getCRMTestData")
	public void addNewContact(String title, String firstName, String lastName, String company){
		
		TestUtil.switchToFrame();
		homePage.clickNewContactLable();
		contactPage.createNewContact(title, firstName, lastName, company);
		
	}
	
	
	@AfterMethod
	public void tearDown(){
		
	//	driver.quit();
	}

}
