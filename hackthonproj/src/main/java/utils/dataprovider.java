package utils;

import org.testng.annotations.DataProvider;

import utils.ExcelRead;

public class dataprovider {
	@DataProvider(name="userdetails")
	public String[][]getData(){
		String[][] data1=ExcelRead.getExcelData();
		
		
		return  data1;
	}
}
