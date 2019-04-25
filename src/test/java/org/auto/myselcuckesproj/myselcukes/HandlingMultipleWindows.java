package org.auto.myselcuckesproj.myselcukes;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import org.testng.ITestResult;
import org.testng.Reporter;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

import com.google.common.io.Files;

import org.auto.myselcukesproj.samplescenarios.RetryFailures;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
public class HandlingMultipleWindows {
	WebDriver driver;

@Parameters("Browser")
@Test(priority=1)
public void openBrowser(String browser)
{
if (browser.equalsIgnoreCase("chrome"))
{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASUS Home\\Projects\\browser_driver\\chromedriver.exe");	 
	 ChromeOptions options =  new ChromeOptions();
	 //options.setHeadless(true);
	 driver = new ChromeDriver();
}
else if (browser.equalsIgnoreCase("ie"))
{
	System.setProperty("webdriver.ie.driver", "C:\\Users\\ASUS Home\\Projects\\browser_driver\\MicrosoftWebDriver.exe");
	driver  =  new InternetExplorerDriver();
}
}
@Test(priority=2)
public void handleWindows()
{
	
	driver.get("https://www.naukri.com/");
	Reporter.log("Browser opened Successfully",true);
	driver.manage().window().maximize();
	String parent_win = driver.getWindowHandle();
	Set<String> s1= driver.getWindowHandles();
	Iterator<String> itr = s1.iterator() ;
	while(itr.hasNext())
	{
		String child_win = (String) itr.next();
		if(!parent_win.equals(child_win))
		{
			driver.switchTo().window(child_win);
			System.out.println("switched to child window" + driver.switchTo().window(child_win).getTitle());	
			driver.switchTo().window(child_win).close();
		}
	}
	
	driver.switchTo().window(parent_win);
	//captureScreenShotWebView(driver,"ss1");
	//captureScreenShotFullView(driver,"ss2");
	driver.close();
	
}
@AfterMethod
public void tearDown(ITestResult result)
{
	if(ITestResult.FAILURE == result.getStatus())
	{
		captureScreenShotFullView(driver,"ss2");		
	}
}
public static void captureScreenShotFullView(WebDriver driver,String name)
{
	try {
		BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(image, "png", new FileOutputStream("C:\\Users\\ASUS Home\\Downloads\\Drivers\\" + name + System.currentTimeMillis() + ".png"));
	} 
	catch (AWTException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
}
public static void captureScreenShotWebView(WebDriver driver,String name)
{
	
	File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	
    try {
    	FileOutputStream fo = new FileOutputStream("C:\\Users\\ASUS Home\\Downloads\\Drivers\\" + name + System.currentTimeMillis() + ".png");
		Files.copy(file,fo);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   
	
	
	
}
}
