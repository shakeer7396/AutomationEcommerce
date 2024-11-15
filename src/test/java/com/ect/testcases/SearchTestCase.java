package com.ect.testcases;

import org.testng.annotations.Test;

import com.ect.pages.BaseClass;
import com.ect.pages.Loginpages;
import com.ect.pages.SearchPages;

public class SearchTestCase extends BaseClass {
	@Test
	public void searchProduct() {
		
		lp=new Loginpages(driver); //Declare this using with baseClass initialization;
		lp.portalLogin(username, password);
		
		//Creating an object for accessing the details this object is using this class only so we put there incase all pages we put in base class
		SearchPages sp= new SearchPages(driver);
		sp.searchProduct();
	}

	
}
