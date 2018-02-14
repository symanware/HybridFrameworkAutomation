package com.crm.qa.testcases;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	public static HomePage homePage;
	public static LoginPage loginPage;
	public static ContactsPage contactsPage;
	public static DealsPage dealsPage;
	public static TasksPage tasksPage;
	
	HomePageTest()
	{
		super();
		
	}
	
	@BeforeMethod
	public void setup(){
		
		initialization();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
				
	}
	
	
	@Test(priority=1)
	public void titleTest(){
		
		String title=homePage.verifyTitle();
		Assert.assertEquals(title, "CRMPRO");
	}
	
	@Test(priority=2)
	public void lableTest(){
		
		TestUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyUserName());
	}
		
	@Test(priority=3)
	public void contactsLinkTest(){
		
		TestUtil.switchToFrame();
		contactsPage=homePage.clickOnContactsLink();
		//return new ContactsPage();
	}
	
	@Test(priority=4)
	public void dealsLinkTest(){
		
		TestUtil.switchToFrame();
		dealsPage=homePage.clickOnDealsLink();
	//	return new DealsPage();
	}
	
	@Test(priority=5)
	public void tasksLinkTest(){
		
		TestUtil.switchToFrame();
		tasksPage=homePage.clickOnTasksLink();
		//return new TasksPage();
	}
		
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}
