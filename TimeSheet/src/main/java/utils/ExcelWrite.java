package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {
	public static FileOutputStream fileOP;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet = null;
	public static XSSFCell cell = null;
	public static XSSFCell cell2 = null;
	public static XSSFRow row = null;
	public static String exFilePath1 = "src\\test\\resources\\ExcelData\\ProfileDetails.xlsx";

	
	public static void userDetails(String name,String emailId) {

		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("Profile Details");

		for (int i = 1; i <= 2; i++) {
			
			row = ExcelWrite.sheet.getRow(i);
			
			if (row == null)
				row = ExcelWrite.sheet.createRow(i);
		
			cell = row.getCell(0);
			
			if (cell == null)
				cell = row.createCell(0);
			
			cell.setCellValue(name);
			
			cell2 = row.getCell(1);
			
			if (cell2 == null)
				cell2 = row.createCell(1);
			
			cell2.setCellValue(emailId);
			
		}
		
		try {

			fileOP = new FileOutputStream(new File(exFilePath1));
			workbook.write(fileOP);
			fileOP.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}
	


}
