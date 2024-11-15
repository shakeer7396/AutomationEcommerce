package com.ect.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataClass {
	Properties pro;
	//Pass the details of the class using constructor
public ConfigDataClass() { //This constructor will read and load all the properties of this file
	File src = new File("./Configuration/config.properties");//Pass the location of the file
	try {
		FileInputStream fis = new FileInputStream(src);
		pro = new Properties();
		pro.load(fis);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
//Method for fetching browser details 
public String getBrowser() {
	return pro.getProperty("browser");//using property object getProperty for calling the browser, return type is a string add add config file browser name

	
}
//To get the url details
public String getUrl() {
	return pro.getProperty("url");//using property object getProperty for calling the URL, return type is a string add add config file URL name
}
}
