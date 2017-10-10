package sc_01; //UNABLE TO CHECK WITH BLANK FIELDS //HOW TO TEST CHECK BOX

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Access 
{
	FirefoxDriver driver;
	@BeforeTest
	public void SetUp()
	{
		driver = new FirefoxDriver();
		driver.get("http://athena.gaintheory.tools/v2/");
		driver.manage().window().maximize();
		
	}
	@Test
	public void VerifyingAccess() throws IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\Kavya\\Desktop\\KavyaUserTestData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet ws = wb.getSheet("Sheet3");
		int RowCount = ws.getLastRowNum();
		
		
		
		for(int i=1;i<=RowCount;i++)
		{
			Row r = ws.getRow(i);
			Cell Data = r.getCell(0);
		 WebElement username=	driver.findElement(By.id("username"));
		 username.sendKeys(Data.toString());
		 
		 Cell Data1 = r.getCell(1);
		 WebElement password = driver.findElement(By.name("password"));
		 password.sendKeys(Data1.toString());
		 
		 WebElement Access = driver.findElement(By.id("btn_submit"));
		 Access.click();
		 
		 Sleeper.sleepTightInSeconds(5);
		 
		 
		 
		 String ExpectedURL = "https://auth.gaintheory.tools/auth/realms/";
		 String ActualURL = driver.getCurrentUrl();
		 String URL = "http://athena.gaintheory.tools/v2/#/main";
		 
		 if(ActualURL.contains(URL))
		 {
			 
			 
			 System.out.println("Login pass - Test Case Pass");
			 
		 }
		 else
		 {
			 System.out.println("Login failed- Test Case Pass");
			 driver.navigate().back();
			 driver.findElement(By.id("loginRestartLink")).click();
		 }
		 
		 }	
		
	}
	@AfterTest
	public void TearDown()
	{
		driver.close();
	}
	

}
