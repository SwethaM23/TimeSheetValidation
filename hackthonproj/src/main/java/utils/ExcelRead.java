package utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

		public static String[][] getExcelData(){
	//public static void main(String []args) {
			String file="C:\\Users\\2269363\\eclipse-workspace\\hackthonproj\\src\\test\\resources\\Exceldata\\userdetails.xlsx";
			XSSFWorkbook wbook = null;
			try {
				wbook= new XSSFWorkbook(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			XSSFSheet sheet=wbook.getSheetAt(0);
			int rows=sheet.getPhysicalNumberOfRows();
			int columns=sheet.getRow(0).getLastCellNum();
	
			String[][]data=new String [rows-1][columns];
			for(int i=1;i<=rows-1;i++) {
				
				XSSFRow row=sheet.getRow(i);
				for(int j=0;j<columns;j++) {
					XSSFCell cell=row.getCell(j);
					DataFormatter dft=new DataFormatter();
					String val=dft.formatCellValue(cell);
					//System.out.println(val);
					data[i-1][j]=val;
					
				}
			}
		
			return data;
			
			
		}
}

