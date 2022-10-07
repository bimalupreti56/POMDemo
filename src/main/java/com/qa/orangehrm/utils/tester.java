package com.qa.orangehrm.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.beust.jcommander.internal.Lists;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

public class tester {

	static String dataPath = "C:\\Users\\upret\\OneDrive\\Desktop\\POM-Sessions\\src\\test\\resources\\testdata\\TestData.xlsx";
	static Workbook book;
	static Sheet sheet;
	
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(dataPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			try {
				book = WorkbookFactory.create(file);
			} catch (org.apache.poi.openxml4j.exceptions.InvalidFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}

	public static void main(String[] args) throws org.apache.poi.openxml4j.exceptions.InvalidFormatException {
		
		Object [][] data = getTestData("contacts");
		
		
		 
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(data[i][j] + " ");
            }
 
            System.out.println();
        }

	}

}
