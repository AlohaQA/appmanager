package com.appmanager.qa.pages;

import com.appmanager.qa.base.TestBase;
import com.appmanager.qa.helperclasses.BrowserHelper;
import com.appmanager.qa.helperclasses.CommonActions;
import com.appmanager.qa.helperclasses.LoggerHelper;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PopflowStudioPage  extends TestBase{
    private WebDriver driver;
    private ExtentTest logger;
    private CommonActions commonActions;
    private BrowserHelper browserHelper;

    Logger log = LoggerHelper.getLogger(PopflowStudioPage.class);

    @FindBy(xpath = "//div[@class=\"container-fluid title-container\"]//div[@class=\"col-sm-10\"]//h6")
    WebElement userPageUIText1;

}
