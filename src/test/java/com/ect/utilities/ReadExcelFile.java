package com.ect.utilities;

import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Read the excel file related data using Apache poi  && Data-Driven
public class ReadExcelFile {

	//This classes are important for reading excel files so import it
	public static FileInputStream fis; //Its common for streams so declare globally
	public static XSSFWorkbook workBook;
	public static XSSFSheet excelSheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	//Get cell value from excel and pass the values matching with excel like row number col numbers and file name sheet name etc
	public static String getCellvalue(String fileName, String sheetname, int row, int colNo) {

		//Reading the input stream and //There you add through exception or use try catch block for all with Exception
		try {
			fis = new FileInputStream(fileName);
			workBook= new XSSFWorkbook(fis); //Read the workbook and Declare with obj and passing the values
			excelSheet = workBook.getSheet(sheetname); //Add Value for the excel sheet
			cell = excelSheet.getRow(row).getCell(colNo); //Give value of the exact cell

			workBook.close();  //Its imp for closing finally after complete the excel workBook

			return cell.getStringCellValue();  //Return the value 
		} catch (Exception e) {
			return "";  //Return empty values there
		}
	}	

	//Another method for read rows count
	public static int getRowCount(String fileName, String sheetName) {

		//Reading the input stream and //There you add through exception or use try catch block for all with Exception
		try {
			fis = new FileInputStream(fileName);
			workBook= new XSSFWorkbook(fis); //Read the workbook and Declare with obj and passing the values
			excelSheet = workBook.getSheet(sheetName); //Add Value for the excel sheet
			int row = excelSheet.getLastRowNum()+1; //Getting the row value with indexes

			workBook.close();  //Its imp for closing finally after complete the excel workBook

			return row;  //Return the value 
		}catch (Exception e) {
			return 0;  //Return empty values there
		}		
	}

	//Another method for read columns count
	public static int getColCount(String fileName, String sheetName) {

		//Reading the input stream and //There you add through exception or use try catch block for all with Exception
		try {
			fis = new FileInputStream(fileName);
			workBook= new XSSFWorkbook(fis); //Read the workbook and Declare with obj and passing the values
			excelSheet = workBook.getSheet(sheetName); //Add Value for the excel sheet
			int col = excelSheet.getRow(0).getLastCellNum(); //Getting the cell value with indexes

			workBook.close();  //Its imp for closing finally after complete the excel workBook

			return col;  //Return the value 
		}catch (Exception e) {
			return 0;  //Return empty values there
		}		
	}

	//Getting the String values from excel using based on sheetIndexes it returns the String value
	public String getStringData(int sheetIndex,int row,int column) {
		return workBook.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();			
	}

	//Getting the String values from excel using based on sheetName it returns the String value
	public String getStringData(String sheetName,int row,int column) {
		return workBook.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();			
	}

	//Getting the String values from excel using based on sheet Numbers it returns the numeric value
	public double getNumericData(String sheetName,int row,int column) {
		return workBook.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();			
	}

}
