package com.ect.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPages {

	WebDriver driver; //Defining globally
	
	//Constructor method it takes 2parameter 
	public SearchPages(WebDriver ldriver) {
		this.driver = ldriver; //passing the value
		
		PageFactory.initElements(driver, this);	
	}
	
	// This \contains\ lines are used for double cots inside double cots used there so (" "" ") "\"container\" (right is" '' ");
	
	@FindBy(linkText="Home") WebElement hometxt; //xpath=//*[text()='Home']
	
	@FindBy(name="frm_search") WebElement srchProduct; //xpath=//*[@name='frm_search']
	
	@FindBy(id="btn_search") WebElement serachbtn; //xpath =//*[@id='btn_search']
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[1]/div[2]/div/div/p/a") WebElement productclick; //xpath=//*[contains(text(),'Add to cart')]
	
	@FindBy(xpath="//*[@id=\"navbarText\"]/ul/li[3]/a") WebElement addcart; //xpath=//*[contains(text(),' Cart ') or //xpath=//*[text()=' Cart ']
	
	@FindBy(xpath="//*[@id=\"cart\"]/div[2]/div/a") WebElement checkout; //xpath=//*[text()='Checkout']
	//locating the web elements
public void searchProduct() {
	hometxt.click();
	srchProduct.sendKeys("Android Tv");
	serachbtn.click();
	productclick.click();
	addcart.click();
	checkout.click();
	
}
}
