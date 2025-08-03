package org.testing.base;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testing.utilities.objectProperties;
import org.testing.utilities.propertiesHandle;
import org.testing.utilities.reportHandling;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class base {
	public Properties p,p2;
	public ChromeDriver driver;
	public  ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test;
	@BeforeSuite
	public void beforesuite() {
		 spark=  reportHandling.report();
	      report  =new ExtentReports();
	       report.attachReporter(spark);
	}
	@BeforeMethod
	public void beforeMethod( ) throws IOException {
	p=objectProperties.objectLoad("../AutomationExcercise/src/test/object.properties");
	p2=	propertiesHandle.loadProperties("../AutomationExcercise/src/test/uri.properties");
	driver=new ChromeDriver();
	driver.get(p2.getProperty("url"));
	driver.manage().window().maximize();

	}
	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
	@AfterSuite
	public void aftersuite() {
		report.flush();
		
	}

}
