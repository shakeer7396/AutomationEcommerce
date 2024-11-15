package com.ect.utilities;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

//implements is a keyword
public class ListenerClass implements ITestListener {
	
	//This classes are important for generating reports
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	
	
	//Values are assigned based on above classes 
	public void configureReport()
	{
		htmlReporter= new ExtentSparkReporter("ExtentListenerReportDemo.html");
		reports= new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		//add system information/environments info to reports
		reports.setSystemInfo("Machine", "RaviPc");
		reports.setSystemInfo("OS","Windows11");
		
		
		htmlReporter.config().setDocumentTitle("Extent Listener Report Demo");
		htmlReporter.config().setReportName("This is my first Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
	}
	
	//All 8 methods for run test listener interface came ready-made from github (Success, Failure, Skip) are most imp
	public void onTestStart(ITestResult result) {
		 System.out.println("the test started");  
	  }

	
	  public void onTestSuccess(ITestResult result) {
	  System.out.println("Name of the test method successfully excuted "+result.getName());
	   test=reports.createTest(result.getName());
	   test.log(Status.PASS, MarkupHelper.createLabel("Name of the passed test case is: "+result.getName(),ExtentColor.GREEN));
	  }

	
	  public void onTestFailure(ITestResult result) {
	    System.out.println("Name of test method failed:"+result.getName());
	    
	    String failedTest =result.getName();
	    String screeshot="./ScreenShots/";
	    test=reports.createTest(result.getName());
	    test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed  test case is: "+result.getName(),ExtentColor.RED))
	    .addScreenCaptureFromPath(screeshot +failedTest + ".png" );
	   
	    
	    String screenShotPath= System.getProperty("user.dir") +"\\ScreenShots\\" + result.getName() + ".png";
	    
	    File screenShotFile = new File(screenShotPath);
	    
	    if(screenShotFile.exists())
	    {
	    	test.fail("Captured Screenshot is below:" +test.addScreenCaptureFromPath(screenShotPath));
	    }
	  }


	  public void onTestSkipped(ITestResult result) {
	    System.out.println("Name of test method skipped "+result.getName());
	    test=reports.createTest(result.getName());
	    test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skip test case is: "+result.getName(),ExtentColor.YELLOW));
	  }


	  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	  
	  }

	
	  public void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	  }

	 
	  public void onStart(ITestContext context) {
	    configureReport();
	    System.out.println("On start method invoked.....");
	  }

	
	  public void onFinish(ITestContext context) {
	    System.out.println("On Finished method invoked.....");
	    reports.flush();// it is mandatory to call flush method to ensure information is written ti the started reporter. 
	  }
	

}
