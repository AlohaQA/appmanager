package com.appmanager.qa.pages;

import java.util.List;

import com.sun.xml.fastinfoset.util.StringArray;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.appmanager.qa.base.TestBase;
import com.appmanager.qa.helperclasses.BrowserHelper;
import com.appmanager.qa.helperclasses.CommonActions;
import com.appmanager.qa.helperclasses.LoggerHelper;
import com.relevantcodes.extentreports.ExtentTest;

public class AdminUsersPage extends TestBase {

	private WebDriver driver;
	private ExtentTest logger;
	private CommonActions commonActions;
	private BrowserHelper browserHelper;
	
	Logger log = LoggerHelper.getLogger(HomePage.class);

	@FindBy(xpath = "//img[@src=\"/Content/images/btn-menu-open2.png\"]")
	WebElement expandCollapseIcon;

	@FindBy(xpath = "//div[@class=\"container-fluid title-container\"]//div[@class=\"col-sm-10\"]//h6")
	WebElement userPageUIText1;

	@FindBy(xpath = "//div[@class=\"container-fluid title-container\"]//div[@class=\"col-sm-10\"]//span")
	WebElement userPageUIText2;

	@FindBy(xpath="//div[@class=\"left-nav\"]//ul//li[@id=\"settingsDropdown\"]")
	WebElement settingsTab; 
	
	@FindBy(xpath="//li[@id=\"ddItemUser\"]")
	WebElement userTab; 
	
	@FindBy(xpath="//button[@class=\"btn btn-primary btn-title-container has-tooltip\"]")
	WebElement inviteUserButton;
	
	//Invite User Form PF:
	@FindBy(xpath="//input[@type=\"text\" and @placeholder=\"First Name\"]")
	WebElement firstNameText; 
	
	@FindBy(xpath="//input[@type=\"text\" and @placeholder=\"Last Name\"]")
	WebElement lastNameText; 
	
	@FindBy(xpath="//input[@type=\"email\" and @placeholder=\"Email\"]")
	WebElement email; 
	
	@FindBy(xpath="//input[@id=\"isLockoutEnabled\" and @type=\"checkbox\"]")
	WebElement lockCheckbox; 
	
	@FindBy(xpath="//a[@data-toggle=\"tab\" and @href=\"#roles\"]")
	WebElement rolesTab; 
	
	@FindBy(xpath="//label[@for=\"isAdmin\"]")
	WebElement checkboxAdmin; 
	
	@FindBy(xpath="//label[@for=\"isSuperUser\"]")
	WebElement checkboxSuperUser; 
	
	@FindBy(xpath="//label[@for=\"isInstaller\"]")
	WebElement checkboxInstaller; 
	
	@FindBy(xpath="//label[@for=\"isPartner\"]")
	WebElement checkboxPartner; 
	
	@FindBy(xpath="//div[@class=\"modal-footer\"]//button[contains(text(),\"Cancel\") ]")
	WebElement cancelButton;
	
	@FindBy(xpath="//div[@class=\"modal-footer\"]//button[contains(text(),\"Save\") ]")
	WebElement saveButton;
	
	@FindBy(xpath="//input[@placeholder=\"Search\" and @type=\"search\"]")
	WebElement searchBox; 
	
	@FindBy(xpath="//button[@type=\"button\" and text()=\"Search\"]")
	WebElement searchButton; 
	
	// Initialize page factory
	public AdminUsersPage(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		commonActions = new CommonActions(driver, logger);
		browserHelper = new BrowserHelper(driver);
		
		log.info("Initialized page factory of Users Page.");
		// logger.info("Initialized page factory of OSC Home Page.");
		PageFactory.initElements(driver, this);

	}

	public String userPageUIText1(){
		commonActions.isElementPresent(userPageUIText1);
		String str1 = commonActions.getText(userPageUIText1);
		return str1;
	}
	public boolean userPageUIText2(){
		return commonActions.isElementPresent(userPageUIText2);

	}

	public void presentColumns() {
		commonActions.click(expandCollapseIcon);
		commonActions.click(settingsTab);
		commonActions.click(userTab);
		List<WebElement> elements = driver.findElements(By.tagName("//tr[1]//th"));
		for (WebElement element : elements) {

				System.out.println("All columns:"+element.getText());

				}

		}







	
	public void inviteUser() {

		commonActions.click(settingsTab);
		commonActions.click(userTab);		
		commonActions.click(inviteUserButton);
		commonActions.enterData(firstNameText, "amit");
		commonActions.enterData(lastNameText, "mh");
		commonActions.enterData(email, "alohaqa7@gmail.com");
		commonActions.click(lockCheckbox);
		commonActions.click(rolesTab);
		commonActions.click(checkboxAdmin);
		commonActions.click(checkboxSuperUser);
		commonActions.click(saveButton);
//		HashMap<String, String> hm1 = GMail.getGmailData("subject:new link");
//		String s = hm1.get(GMail.link);
//		System.out.println(s);
//		driver.navigate().to(s);
	
	}

	public void inviteMultipeUser(String firstname, String lastname, String emailadress) {
		commonActions.click(settingsTab);
		commonActions.click(userTab);		
		commonActions.click(inviteUserButton);
		commonActions.enterData(firstNameText,firstname);
		commonActions.enterData(lastNameText,lastname);
		commonActions.enterData(email,emailadress);
		commonActions.click(lockCheckbox);
		commonActions.click(rolesTab);
		commonActions.click(checkboxAdmin);
		commonActions.click(checkboxSuperUser);
		commonActions.click(saveButton);
		try {
			browserHelper.wait(2000);
			} catch (InterruptedException e) {
			e.printStackTrace();
			}		
	
	}
		
	public String search(String s) {
		commonActions.click(settingsTab);
		commonActions.click(userTab);
		List<WebElement> list1 = driver.findElements(By.tagName("//tr[1]"));
		System.out.println(list1.size());
		String s1 = list1.get(0).getText();
		commonActions.click(searchBox);
		commonActions.enterData(searchBox, s1);
		commonActions.click(searchButton);
		return s;
	}


		 
		
}	

