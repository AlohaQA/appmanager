package com.appmanager.qa.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
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

	@FindBy(xpath = "//div[@class=\"left-nav\"]//ul//li[@id=\"settingsDropdown\"]")
	WebElement settingsTab;

	@FindBy(xpath = "//li[@id=\"ddItemUser\"]")
	WebElement userTab;

	@FindBy(xpath = "//button[@class=\"btn btn-primary btn-title-container has-tooltip\"]")
	WebElement inviteUserButton;

	@FindBy(xpath = "//input[@placeholder=\"Search\" and @type=\"search\"]")
	WebElement searchBox;

	@FindBy(xpath = "//button[@type=\"button\" and text()=\"Search\"]")
	WebElement searchButton;

	@FindAll(@FindBy(xpath = "//tr//th[contains(@class,\"sorting\")]"))
	List<WebElement> gridColumns;

	@FindBy(xpath = "//tr[1]//td[@class=\" text-break word-break\"][1]")
	WebElement usernameField;

	@FindAll(@FindBy(xpath = "//tr//td[contains(@class,\"text-break word-break\")]"))
	List<WebElement> allPresentUsername;

	@FindBy(xpath = "//tr[1]//td[@class=\" text-break word-break\"][2]")
	WebElement name;

	@FindAll(@FindBy(xpath = "//tr//td[contains(@class,\"text-break\")]"))
	List<WebElement> GridData;

	@FindBy(xpath = "//tr//td[@class=\"userNotfoundLabel\"]")
	WebElement userNotFound;

	@FindBy(xpath = "//tr//td[1]")
	WebElement SearchedRow;

	@FindBy(xpath = "//button[@id=\"roleDropdown\"]")
	WebElement filterByRole;

	@FindAll(@FindBy(xpath = "//div[@class=\"dropdown-menu show\"]//a"))
	List<WebElement> getFilterByRole;

	@FindBy(xpath = "//div[@aria-labelledby=\"roleDropdown\"and@class=\"dropdown-menu\"]//a[@class=\"dropdown-item\"][2]")
	WebElement adminRole;

	@FindAll(@FindBy(xpath = "//tr//td[3]"))
	List<WebElement> roleValues;

	@FindBy(xpath = "//div[@class=\"dropdown\"]//button[@id=\"actionDropdown\"]")
	WebElement actionButton;

	@FindAll(@FindBy(xpath = "//div[@class=\"dropdown-menu show\"]//a"))
	List<WebElement> actionDropdownItems;

	@FindBy(xpath = "//tr//td[3]")
	WebElement roleValue;
	//Invite User Form PF:
	@FindBy(xpath = "//input[@type=\"text\" and @placeholder=\"First Name\"]")
	WebElement firstNameText;

	@FindBy(xpath = "//input[@type=\"text\" and @placeholder=\"Last Name\"]")
	WebElement lastNameText;

	@FindBy(xpath = "//input[@type=\"email\" and @placeholder=\"Email\"]")
	WebElement email;

	@FindBy(xpath = "//input[@id=\"isLockoutEnabled\" and @type=\"checkbox\"]")
	WebElement lockCheckbox;

	@FindBy(xpath = "//a[@data-toggle=\"tab\" and @href=\"#roles\"]")
	WebElement rolesTab;

	@FindBy(xpath = "//label[@for=\"isAdmin\"]")
	WebElement checkboxAdmin;

	@FindBy(xpath = "//label[@for=\"isSuperUser\"]")
	WebElement checkboxSuperUser;

	@FindBy(xpath = "//label[@for=\"isInstaller\"]")
	WebElement checkboxInstaller;

	@FindBy(xpath = "//label[@for=\"isPartner\"]")
	WebElement checkboxPartner;

	@FindBy(xpath = "//div[@class=\"modal-footer\"]//button[contains(text(),\"Cancel\") ]")
	WebElement cancelButton;

	@FindBy(xpath = "//div[@class=\"modal-footer\"]//button[contains(text(),\"Save\") ]")
	WebElement saveButton;


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

	public String userPageUIText1() {
		commonActions.click(expandCollapseIcon);
		commonActions.click(settingsTab);
		commonActions.click(userTab);
		commonActions.isElementPresent(userPageUIText1);
		String s = commonActions.getText(userPageUIText1);
		commonActions.isElementPresent(userPageUIText2);
		return s;
	}

	public String userPageUIText2() {
		String s = commonActions.getText(userPageUIText2);
		commonActions.isElementPresent(userPageUIText2);
		return s;
	}

	public List<WebElement> presentColumns() {

		commonActions.click(expandCollapseIcon);
		commonActions.click(settingsTab);
		commonActions.click(userTab);
		System.out.println("Below columns present at UsersGrid");
		for (WebElement elements : gridColumns) {

			System.out.println(elements.getText());
		}

		return gridColumns;
	}


	public void inviteUser() {

		commonActions.click(expandCollapseIcon);
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
		commonActions.click(expandCollapseIcon);
		commonActions.click(settingsTab);
		commonActions.click(userTab);
		commonActions.click(inviteUserButton);
		commonActions.enterData(firstNameText, firstname);
		commonActions.enterData(lastNameText, lastname);
		commonActions.enterData(email, emailadress);
		//commonActions.click(lockCheckbox);
		commonActions.click(rolesTab);
		commonActions.click(checkboxAdmin);
		commonActions.click(checkboxSuperUser);
		commonActions.click(saveButton);
		try {
			browserHelper.wait(2000);
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

	public void searchWithUsername() {
		commonActions.click(expandCollapseIcon);
		commonActions.click(settingsTab);
		commonActions.click(userTab);
		System.out.println("Perform Search Using Email Address: ");
		String s1 = usernameField.getText();
		commonActions.click(searchBox);
		commonActions.enterData(searchBox, s1);
		commonActions.click(searchButton);
		if (commonActions.isElementPresent(usernameField) && s1.equals(usernameField.getText())) {
			System.out.println(" Search with username is Completed ");
		} else {
			if (commonActions.isElementPresent(userNotFound))
				System.out.println(" User not found ");
			else {
				System.out.println(" Unable to perform search operation with Email ");

			}
		}

	}

	public void searchWithName() {
		commonActions.click(expandCollapseIcon);
		commonActions.click(settingsTab);
		commonActions.click(userTab);
		System.out.println("Perform Search Using Name: ");
		String s1 = name.getText();
		commonActions.click(searchBox);
		commonActions.enterData(searchBox, s1.substring(0, 3));
		commonActions.click(searchButton);
		if (commonActions.isElementPresent(name) && s1.equals(name.getText())) {
			System.out.println(" Search with username is Completed ");
		} else {
			if (commonActions.isElementPresent(userNotFound))
				System.out.println(" User not found ");
			else {
				System.out.println(" Unable to perform search operation with username ");

			}
		}
	}

	public void searchWithRole() {
		commonActions.click(expandCollapseIcon);
		commonActions.click(settingsTab);
		commonActions.click(userTab);
		System.out.println("Perform Search Using Roles: ");
		commonActions.click(filterByRole);
		List<WebElement> options = getFilterByRole;
		for (WebElement element : options) {
			System.out.println("Searching started----------");
			String s1 = element.getText().toLowerCase();
			commonActions.click(element);
			commonActions.waitFor(2000);
			commonActions.click(searchButton);

			for (WebElement roleValues : roleValues) {
				System.out.println("Validating the searched element with  " + s1 + "  ----------");
				String s2 = roleValues.getText().toLowerCase();
				System.out.println(s2);
				if (s2.contains(s1)) {
					System.out.println("Search with Role: " + s1 + "  is success ");
				} else {
					System.out.println("Search with Role: " + s1 + "  is Failed ");

				}
			}
			commonActions.click(filterByRole);
		}
	}

	public void editExistingUser() {

		inviteUser();
		commonActions.click(expandCollapseIcon);
		commonActions.click(settingsTab);
		commonActions.click(userTab);
		commonActions.click(actionButton);
		List<WebElement> options = actionDropdownItems;
		for (int i = 0; i <= options.size(); i++) {

			if (options.get(i).getText().contains("Settings")) {
				options.get(i).click();
				break;
			}
		}
		commonActions.clear(firstNameText);
		commonActions.enterData(firstNameText, "Test_Anup");
		commonActions.clear(lastNameText);
		commonActions.enterData(lastNameText, "Test_Lakhe");
		commonActions.clear(email);
		commonActions.enterData(email, "anupl@gmail.com");
		commonActions.click(rolesTab);
		commonActions.click(checkboxAdmin);
		commonActions.click(checkboxSuperUser);
		commonActions.click(checkboxAdmin);
		commonActions.click(saveButton);
		commonActions.click(userTab);

		try {
			browserHelper.wait(2000);
		} catch (Throwable e) {
			e.printStackTrace();
		}


	}

	public List<WebElement> allPresentUsernames(){
		return allPresentUsername;
	}

	public void deleteUser(){
		inviteUser();
		commonActions.click(expandCollapseIcon);
		commonActions.click(settingsTab);
		commonActions.click(userTab);
		commonActions.click(actionButton);
		List<WebElement> options = actionDropdownItems;
		for (int i = 0; i <= options.size(); i++) {

			if (options.get(i).getText().contains("Delete")) {
				options.get(i).click();
				break;
			}
		}
		try {
			browserHelper.wait(2000);
		} catch (Throwable e) {
			e.printStackTrace();
		}


	}

}




		


