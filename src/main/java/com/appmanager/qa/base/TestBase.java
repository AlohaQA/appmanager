package com.appmanager.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.appmanager.qa.util.TestUtil;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;

	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/appmanager/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(); 
		}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		System.out.println("GIT");


}
	public void takeScreenShot() {


		SimpleDateFormat formatter = new SimpleDateFormat("MM_dd_yyyy_hh_mm");
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("/Users/tushar/Automation/appmanager/test-output/FailedTestScreenShots/"+
					formatter.format(new Date()) + "_FailedTestScreen.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exception occurred when copying screenshot to folder.");
		}

	}
}
