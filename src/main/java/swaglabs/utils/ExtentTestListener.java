package swaglabs.utils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentTestListener implements ITestListener {

    ExtentReports extent = ExtentManage.getReportObject();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    	
        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

    	test.fail(result.getThrowable());
    	
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.skip("Test Skipped");
    }

    @Override
    public void onStart(ITestContext context) {

        System.out.println("Test Execution Started");
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();
        System.out.println("Extent Report Generated");
    }
}
