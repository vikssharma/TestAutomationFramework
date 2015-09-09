package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
//import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

public class NewTest {
	
	public static WebDriver driver = new InternetExplorerDriver(UtilityFunctions.SetCapabilities());
	
  @Test
  public void f() throws IOException {
	  //This is messsage to print
	  System.out.println("Hello");
	  driver.get("http://google.com");
	  UtilityFunctions Page = new UtilityFunctions(driver);
	  //System.out.println("<img src=\"data:image/png;base64," + 
	//	        ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64) + "\" ></img>");
	  File imageFile1 = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(imageFile1, new File("c:\\tmp\\screenshot.png"));
	  Reporter.log(String.format("SCREENSHOT: <a href='c:\\tmp\\screenshot.png'><img border='0', src='%s' width='80' height ='60'/></a>", "screenShotName", "screenShotName"));
	  System.out.println(imageFile1);
	  Page.txtSearch.sendKeys("Selenium");
	  Page.btnSearch.click();
	  driver.close();
  }
  
  
  
  @Test
  public void f1() {
	  System.out.println("Hello1");
	  UtilityFunctions.Driver("http://google.com");
	  UtilityFunctions.DriverClose();
  }
}
