package coverFoxUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility {
	
	public static String readDataFromExcel(String fileName, String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		Reporter.log("reading data from excel sheet",true);

		FileInputStream myFile=new FileInputStream(System.getProperty("user.dir")+"\\"+fileName+".xlsx");

		String value = WorkbookFactory.create(myFile).getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();

		return value;
		
	}
	
	public static void takeScreenShot(WebDriver driver, String fileName) throws IOException {
		
		Reporter.log("Taking screenshot", true);
		String timeStamp= new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());

		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File dest=new File(System.getProperty("user.dir")+"\\screenShots\\"+fileName+timeStamp+".png");
		
		Reporter.log("saving screenshot at location "+dest, true);

		FileHandler.copy(src, dest);
		
	}
	
	
	public static String readDataFromPropertiesFile(String key) throws IOException {
		//String filePath = System.getProperty("user.dir")+"\\fbTest.properties"; //it will locate our properties file
		//now to read data from properties file create obj of FIS class
		
		FileInputStream myFile=new FileInputStream(System.getProperty("user.dir")+"\\fbTest.properties");  //reduce one step
		
		//now we have to load the properties file
		
		Properties prop=new Properties();
		Reporter.log("reading data from properties file "+key,true);

		prop.load(myFile);
		
	//now we have to get the value from file 
		
		String value = prop.getProperty(key);  //this will give value of key
		
		return value;
		
	}
	
}
