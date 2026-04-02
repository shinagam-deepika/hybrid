package swaglabs.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManage {

	public static ExtentReports extent;

    public static ExtentReports getReportObject()
    {
        String path = System.getProperty("user.dir") 
                + "/reports/extentReport.html";

        ExtentSparkReporter reporter =
                new ExtentSparkReporter(path);

        reporter.config().setReportName("SwagLabs Automation Report");
        reporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);

        extent.setSystemInfo("Tester", "Deepika");
        extent.setSystemInfo("Environment", "QA");

        return extent;
    }
}
