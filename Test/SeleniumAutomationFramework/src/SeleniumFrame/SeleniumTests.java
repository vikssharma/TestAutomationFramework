package SeleniumFrame;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;


public class OS_Version {
	
//	@Test
//	public void firsttest() throws IOException {
//	    Driver.TestSuite("Driver");
//	    FunctionLibrary.WaitForObject(1000);
//        FunctionLibrary.CloseDriver();
//    }
	
	@Before
	public void Secondtest() throws IOException {
	    FunctionLibrary.PerformAction("LaunchIE", "", "", "http://google.com");
    }
	
	@Test
	public void Thirdtest() throws IOException {
	    FunctionLibrary.EnterText("q", "Selenium");
	    FunctionLibrary.WaitForObject(10000);
	    FunctionLibrary.PerformClick("btnG", "Name");
	    Assert.assertEquals("Selenium",FunctionLibrary.GetObjectText("q"));
	    FunctionLibrary.screenshot("Screen1");
	    FunctionLibrary.PerformClick("//*[@id='rso']/div[1]/div[1]/div/h3/a", "Xpath");
	    FunctionLibrary.PerformClick("//*[@id='menu_download']/a", "Xpath");
	    FunctionLibrary.screenshot("Screen2");
	}
	
	@After
	public void Closetest() throws IOException {
	    FunctionLibrary.CloseDriver();
    }
	
}
