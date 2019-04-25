package org.auto.myselcukesproj.samplescenarios;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class JscriptSamples {
	

	public static void main(String[] args) throws IOException, InterruptedException, AWTException {
		String str = "hello string";
System.out.println(str.indexOf("e"));	
	System.setProperty("webdriver.chrome.driver","C:\\Users\\ASUS Home\\Projects\\browser_driver\\chromedriver.exe");
	//FirefoxProfile profile = new FirefoxProfile();
	//profile.setAcceptUntrustedCertificates(true);
	DesiredCapabilities cap =  DesiredCapabilities.chrome();
	cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	WebDriver driver = new ChromeDriver();
	//driver.get("C:\\Users\\ASUS Home\\Desktop\\fileupload.html");
	Runtime.getRuntime().exec("C:\\Users\\ASUS Home\\Desktop\\AutoIt_Auth.exe");
	driver.get("https://www.engprod-charter.net");
	
				Robot rb = new Robot();
	rb.keyPress(KeyEvent.VK_A);
	Thread.sleep(2000);
	rb.keyRelease(KeyEvent.VK_A);
	Thread.sleep(2000);
	rb.keyPress(KeyEvent.VK_TAB);
	Thread.sleep(2000);
	rb.keyRelease(KeyEvent.VK_TAB);
	rb.keyPress(KeyEvent.VK_A);
	Thread.sleep(2000);
	rb.keyRelease(KeyEvent.VK_A);
	Thread.sleep(2000);
	rb.keyPress(KeyEvent.VK_ENTER);
	Thread.sleep(2000);
	rb.keyRelease(KeyEvent.VK_ENTER);
	//driver.manage().window().maximize();
	//Thread.sleep(3000);
	//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	//driver.findElement(By.xpath("//input[@type='file']")).click();
	//Thread.sleep(5000);
	//Runtime.getRuntime().exec("C:\\Users\\ASUS Home\\Desktop\\AutoIt_FileUpload.exe");
	
	
	//((JavascriptExecutor)driver).executeScript("document.getElementById('lst-ib').value='swathiraj';");


	}
	


}
