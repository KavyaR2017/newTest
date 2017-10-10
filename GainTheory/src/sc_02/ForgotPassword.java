package sc_02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ForgotPassword 
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
	public void ForgotPasswordTest()
	{
		
		driver.findElement(By.linkText("Forgot Password?")).click();
		String ActualText = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/h4")).getText();
		String ExpectedText = "Reset Password";
		if(ActualText.contains(ExpectedText))
		{
			System.out.println("Test Case Pass");
		}
		
	}
	@AfterTest
	public void TearDown()
	{
		driver.close();
	}

}
