package com.ect.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	
	//Return type is a WebDriver because when i call this method it should return driver related details
	public static WebDriver startApplication(WebDriver driver, String browser, String url) { //Some details are passing Driver, browser, and url
		
		//We are defining conditions to choose which WebDriver & associated browser needs to open to perform testing.
		if(browser.equals("chrome")){
			WebDriverManager.chromedriver().setup(); //driver setup 
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox")){
			WebDriverManager.firefoxdriver().setup(); //driver setup 
			driver = new FirefoxDriver();
		}
		else if(browser.equals("IE")){
			WebDriverManager.edgedriver().setup(); //driver setup 
			driver = new EdgeDriver();
		}
		else {
			System.out.println("No Browser is Supportable");
		}
		driver.manage().window().maximize(); //Maximizing the window
		driver.get(url); //Getting the url
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS); //Waiting for some time
		
		return driver; // This method return type is WebDriver so return driver
	}
}
