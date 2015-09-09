package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UtilityFunctions {
	//this constructor will initialize page objects

	public static WebDriver driver;
	
	public UtilityFunctions(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "q")
	public WebElement txtSearch;
	
	@FindBy(name = "btnG")
	public WebElement btnSearch;
	
	public static DesiredCapabilities SetCapabilities()
	{
		System.setProperty("webdriver.ie.driver", "D:\\IE Driver\\IEDriverServer.exe");
		DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
		cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		return cap;  
	}
	public static void Driver(String url)
	{
		driver = new InternetExplorerDriver(SetCapabilities());
		driver.get(url);
		
	}
	public static void DriverClose()
	{
		driver.close();
	}
	

}
