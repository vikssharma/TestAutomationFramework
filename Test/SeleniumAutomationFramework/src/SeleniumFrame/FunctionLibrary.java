import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.testng.Assert;

public class FunctionLibrary {

	private static WebDriver driver; 
	public static WebElement Object;

	public static void LaunchIE(String url) throws IOException {
		//System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer\\IEDriverServer.exe");
		//DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
		//cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		//driver = new InternetExplorerDriver(cap);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(url);
		driver.get("javascript:document.getElementById('overridelink').click();");
	}

	public static void WaitForObject(Integer NumOfSeconds) throws IOException {

		try {
			Thread.sleep(NumOfSeconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void EnterText(String elementID,String TexttoEnter) throws IOException {
		driver.findElement(By.name(elementID)).sendKeys(TexttoEnter);
		//driver.findElement(By.xpath("//*[@name='q']")).sendKeys(TexttoEnter);
		//driver.findElement(By.cssSelector("#q")).sendKeys(TexttoEnter);
		}

	public static void PerformClick(String PropertyValue,String PropertyType) throws IOException {
		//System.out.println(PropertyType.toUpperCase());
		if(PropertyType == "ID")
		{
			driver.findElement(By.id(PropertyValue)).click();
		}
		if(PropertyType == "Name")
		{
			driver.findElement(By.name(PropertyValue)).click();
		}
		if(PropertyType == "Xpath")
		{
			driver.findElement(By.xpath(PropertyValue)).click();
		}
	}
	
	public static void screenshot(String FileName) throws IOException {
	    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(scrFile, new File("src/Screenshot/" + FileName + ".png"));
	}

	public static String GetObjectText(String elementID) throws IOException {
		String ObjectText = driver.findElement(By.name(elementID)).getAttribute("value");
		return ObjectText;
	}

	public static void CloseDriver() throws IOException {
		driver.close();
		driver.quit();

	}
	
	public static void PerformAction(String Action,String PropertyName, String PropertyValue,String InputData)throws IOException {
		int i=0;
		if(Action.equals("CloseDriver")){
			i = 1;		
		} else if(Action.equals("PerformClick")){
			i = 2;		
		} else if(Action.equals("EnterText")){
			i = 3;		
		} else if(Action.equals("LaunchIE")){
			i = 4;		
		} else if(Action.equals("GetObjectText")){
			i = 5;		
		}else if(Action.equals("LaunchChrome")){
			i = 6;		
		}

		if(PropertyName.equals("ID")){
			if(PropertyValue.equals("dashboard")){
				WebDriverWait wait1 = new WebDriverWait(driver, 200);
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("dashboard")));
			}
			Object = driver.findElement(By.id(PropertyValue));	
		} else if(PropertyName.equals("Name")){
			Object = driver.findElement(By.name(PropertyValue));
		} else if(PropertyName.equals("XPATH")){
			Object = driver.findElement(By.xpath(PropertyValue));
		} 

		switch(i) {
		case 1:
			System.out.println("Vikas");
			break;
		case 2:
			Object.click();
			WaitForObject(20);
			break;
		case 3:
			Object.sendKeys(InputData);
			break;
		case 4:
			System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer\\IEDriverServer.exe");
			DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
			cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			driver = new InternetExplorerDriver(cap);
			//driver.get(InputData);
			driver.navigate().to(InputData);
			//Assert.assertEquals(1, 2);
			break;
		case 5:
			System.out.println(Object.getAttribute("value"));
			//Utility.WriteCapturedValue(Object.getAttribute("value"));
			break;	
		case 6:
			System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
			DesiredCapabilities cap1 = DesiredCapabilities.chrome();
			cap1.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			driver = new ChromeDriver(cap1);
			driver.get(InputData);

			break;	
		}	

	}
}
