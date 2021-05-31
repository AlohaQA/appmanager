package com.appmanager.qa.ExtentReportListener;

import com.appmanager.qa.base.TestBase;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener extends TestBase implements ITestListener {


    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("*****************FAILED TEST**********************");
        takeScreenShot();
    }
}
