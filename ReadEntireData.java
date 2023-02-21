package main.java.week7.day1;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadEntireData {
	
public static String[][] readData(String fileName) throws IOException {
		
		
		
		//set up the path for excel
		XSSFWorkbook wb=new XSSFWorkbook("./CreateData/"+fileName+".xlsx");
		
		//get into the sheet
		//XSSFSheet ws = wb.getSheet("Create");//by name
		XSSFSheet ws = wb.getSheetAt(0);//by index
		
		//row count
		int rowCount = ws.getLastRowNum();
		
		//column count
		short columnCount = ws.getRow(0).getLastCellNum();
		
		//to pass data[][]
		String[][] data=new String[rowCount][columnCount];
		
		//get into the row
		for (int i = 1; i <rowCount ; i++) {
			XSSFRow row = ws.getRow(i);
			
		
		//get into the cell
		for(int j=0;j<columnCount;j++) {
		XSSFCell cell = row.getCell(j);
		
		//read the data from cell
		data[i][j]= cell.getStringCellValue();
		//1 0(i=1) if i=1 means
		System.out.println(cell.getStringCellValue());
		
		}
		}
		//close the workbook
		wb.close();
		return data;
	}
	
	
}
