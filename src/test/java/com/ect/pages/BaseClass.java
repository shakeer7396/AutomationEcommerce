package com.ect.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import com.ect.utilities.BrowserFactory;
import com.ect.utilities.ConfigDataClass;
import com.ect.utilities.ReadExcelFile;

public class BaseClass {
	
	//Accessing the file location in the project
		String fileName = System.getProperty("user.dir")+"\\TestData\\EcommerceTestData.xlsx";
	
public	WebDriver driver; //Initializing the WebDriver;
	
//Create an object of ConfigDataClass and using this class properties in base class and import it
	public ConfigDataClass conf = new ConfigDataClass();
	
//Creating an object for accessing ReadExcelFile properties for further search feature purpose and every page also
	public ReadExcelFile rf=new ReadExcelFile();
	
	//Creating an object for accessing Loginpages properties its common for every page
		protected Loginpages lp;  //Initializing the value using in where you want ex- SearchTestCase
	
	//Reading data from excel file with the help of below code
	protected String username= ReadExcelFile.getCellvalue(fileName, "Login", 1, 0); //filename,sheetName,row,col format running every time
	protected String password= ReadExcelFile.getCellvalue(fileName, "Login", 1, 1);
	
	//Using TestNG there	
	@BeforeClass  //It works Before execution of a class
	public void setup() { //We define driver related details there in starting setup
		driver = BrowserFactory.startApplication(driver, conf.getBrowser(), conf.getUrl());//Which values are passed in BrowserFactory parameter same take with obj name
		
	}
	
	public void captureScreenShot(WebDriver driver,String testName) throws IOException 
	 {
		 // Convert webdriver object to TakesScreenshot interface
		 TakesScreenshot screenshot= ((TakesScreenshot)driver);
		 
		 // Step 2 :call getScreenshotAs method to capture image file
		 
		 File src= screenshot.getScreenshotAs(OutputType.FILE);
		 File srcpath=new File("."+"//ScreenShots//"+ testName + ".png");
		 System.out.println("This is screenshot section");

		 // Step 3 : copy image file to destination 
		 FileUtils.copyFile(src, srcpath);
		 
	 }
}
