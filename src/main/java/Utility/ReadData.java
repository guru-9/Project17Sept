package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import Base.TestBase;

public class ReadData extends TestBase {

	public static String readPropertyFile(String value) throws Exception
	{
		Properties p =new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\gurur\\eclipse-workspace\\Project17Sept\\TestData\\config.properties");
		p.load(file);
		return p.getProperty(value);
		
	}
	
	public static String readExcel(int row , int col) throws Exception
	 {
		 FileInputStream file = new FileInputStream("C:\\Users\\gurur\\eclipse-workspace\\Project17Sept\\TestData\\Data.xlsx");
		  Sheet excel = WorkbookFactory.create(file).getSheet("Sheet1");
		  String value = excel.getRow(row).getCell(col).getStringCellValue();
		  return value;
	 }
	
	public static void captureScreenshot(String name) throws IOException {
	
//		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		File dest = new File("C:\\Users\\DELL\\eclipse-workspace\\Project17Sept\\Screenshot");
//		File
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\gurur\\eclipse-workspace\\Project17Sept\\Screenshot" +name+ ".jpeg");
	    
		FileHandler.copy(source, dest);
	}
	
}
