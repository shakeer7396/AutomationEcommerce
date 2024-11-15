package com.ect.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ect.pages.BaseClass;
import com.ect.pages.Loginpages;
import com.ect.utilities.ReadExcelFile;

public class LoginTest extends BaseClass { //extends means what ever in BaseClass we have to access this class
	
	//Accessing the file location in the project
	String fileName = System.getProperty("user.dir")+"\\TestData\\EcommerceTestData.xlsx";
	
	@Test(dataProvider = "logindataProvider") // Its a below method name object of array
public  void verify(String user, String pass) throws IOException { //Manually passing is possible we want read the excel file //Passing 2 values there
		
	//Achieving the Loginpages username and password using object 	
		Loginpages lp = new Loginpages(driver);
		lp.portalLogin(user, pass);  //Calling the login method with the help of portalLogin
		
		if(user.equals("ravi@dhiyotech.in") && pass.equals("Demo")) { //checking the details are correct then only call the method
			
			Assert.assertTrue(true); //TestNG Assert method checking the true or false
			
			lp.logout(); //Calling the logout method
		}
		else {
			captureScreenShot(driver, "verify");
			Assert.assertTrue(false);
		}
}
	
	//Using multiple peoples data so use dataProvider method and return type is string
	
	@DataProvider  //This returns always objects of array
	public String[][] logindataProvider() {
		
		//Reading data from excel file with the help of 
		int row=ReadExcelFile.getRowCount(fileName, "Login"); //2parameters Filename & Sheetname  //getting row count
		int col=ReadExcelFile.getColCount(fileName, "Login"); //2parameters Filename & Sheetname  //getting col count
		
		//Validate row count to prevent NegativeArraySizeException
		if(row <=1) {
			System.out.println("Insuficient data in Excel sheet. No rows to read.");
			return new String[0][0]; //Return an empty array to avoid issues
		}
		String [][] data = new String [row-1] [col]; //Storing the multi-dimensional arrays data with object of array
		
		//Logic for above row and column based on indexes
		//Running the nested loop multi-dimential arrays
		for(int i=1;i<row;i++) {
			for(int j=0;j<col;j++) {
				data[i-1][j]=ReadExcelFile.getCellvalue(fileName, "Login", i, j); //filename,sheetName,row,col format running every time
			}
		}
		return data;
	}
}
//Call Screenshot code To Test case if Test case failed like Login TestCase