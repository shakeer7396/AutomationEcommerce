package com.ect.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpages {
	WebDriver driver; //Initializing
	
	//Using constructor class for easy to use any other classes also, now all information in the constructor
	public Loginpages(WebDriver ldriver) { //driver details are always available in baseclass
		
		this.driver=ldriver;
		PageFactory.initElements(driver, this); //PageFactory class is available in selenium, passing driver in initElement is use for Assignee using anywhere purpose
		
	}

	//Locate Every element one by one with FindBy method passing through WebElement
	@FindBy(xpath="//*[@id=\"navbarText\"]/ul/li[2]/a") WebElement logimage;
	
	@FindBy(id="email") WebElement email;
	
	@FindBy(id="password") WebElement pass;
	
	@FindBy(id="customerloginForm") WebElement sub;
	
	@FindBy(xpath="//*[@id='navbarText']/ul/li[2]/div/button") WebElement logoutimage;
	
	//@FindBy(xpath="//*[@id='navbarText']/ul/li[2]/div/div/a[2]") WebElement logoutclick;
	@FindBy(xpath ="//*[text()='Logout']") WebElement logoutclick;
	
	//Giving access for above elements for Login method
	public void portalLogin(String username, String password) {
		logimage.click();
		
		email.sendKeys(username);
		
		pass.sendKeys(password);
		
		sub.click();		
	}
	
	//Logout method
	public void logout() {
		logoutimage.click();
		
		logoutclick.click();
	}
	
	
	
}
