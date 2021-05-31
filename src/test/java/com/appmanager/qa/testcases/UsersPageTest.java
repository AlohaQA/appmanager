package com.appmanager.qa.testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.appmanager.qa.base.TestBase;
import com.appmanager.qa.pages.AdminUsersPage;
import com.appmanager.qa.util.TestUtil;
import com.appmanager.qa.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentTest;

import java.util.List;

public class UsersPageTest extends TestBase {

	private LoginPage loginPage;
	private AdminUsersPage usersPage;
	private ExtentTest logger; 
	private String s; 
	

	Logger log = Logger.getLogger(UsersPageTest.class);

	public UsersPageTest() {

		super();
	}

	@BeforeMethod
	public void setup() {

		initialization();
		loginPage = new LoginPage(driver,logger);
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		usersPage = new AdminUsersPage(driver,logger);

	}

	@Test(priority = 1)
	public void verifyAdminUserPageUI(){

		String s = usersPage.userPageUIText1();
		Assert.assertEquals(s,"Users");
		String s1 = usersPage.userPageUIText2();
		Assert.assertEquals(s1," | manage users and permissions.");

			}

	@Test(priority=2)
	public void verifyInviteUserTest() {
		usersPage.inviteUser();
		
	}


	@Test(priority = 3)
	public void verifyColumnsPresentAtUserPageGrid() {

		List<WebElement> Columns = usersPage.presentColumns();
		String[] ExpectedColumns = {"USERNAME ", "NAME ", "ROLES", "EMAIL ADDRESS ", "EMAIL CONFIRM ", "ACTIONS"};
		try{
			for (int i = 0; i <= ExpectedColumns.length; i++) {
				String str = Columns.get(i).getText();
				if (str.equals(ExpectedColumns[i])) {
					Assert.assertEquals(str,ExpectedColumns[i]);
					System.out.println("Passed On:" + str);
				} else {
					Assert.assertEquals(str,ExpectedColumns[i]);
					System.out.println("Failed On:" + str);
				}
			}

		}catch (Throwable e){
			System.out.println(e);
		}
	}

	@Test(priority=4)
	public void verifySearchWithUserName() {

		usersPage.searchWithUsername();

	}

	@Test(priority=5)
	public void verifySearchWithName() {

		usersPage.searchWithName();

	}

	@Test(priority = 6)

	public void verifySearchWithRoles(){
		log.info("\"***************** Search with Role Started *********************\"");
		usersPage.searchWithRole();
	}







		
//	@DataProvider
//	public Object[][] getUsersData() {
//
//		Object data[][] = TestUtil.getTestData("users");
//		return data;
//	}
//
//	@Test(priority=3, dataProvider = "getUsersData")
//	public void verifyInviteMultipleUsersTest(String firstname, String lastname, String emailaddress) {
//
//		usersPage.inviteMultipeUser(firstname, lastname, emailaddress);
//
//	}
	
	@AfterMethod
	
		public void teardown() {

		driver.quit();
		}
	
	
	
}
