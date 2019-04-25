package org.auto.myselcukes.manager;

import java.util.concurrent.TimeUnit;

import org.auto.myselcukes.enums.DriverType;
import org.auto.myselcukes.enums.EnvironmentType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverManager {
private WebDriver driver;
private static DriverType driver_type;
private static EnvironmentType environment_type;


public  WebDriverManager()
{
	driver_type= FileManager.getInstance().getConfigReader().getDriverType();
	environment_type = FileManager.getInstance().getConfigReader().getEnvType();
}
public WebDriver getDriver()
{
	if (driver ==null)
	{
		driver = createDriver();
	}
	return driver;
}
private WebDriver createDriver()
{
	switch(environment_type)
	{
	case LOCAL:
		driver = createLocalDriver();
		break;
	case REMOTE:
		driver = createRemoteDriver();
		break;
	}
	return driver;
}
private WebDriver createLocalDriver()
{
	switch(driver_type)
	{
	case CHROME:
		System.setProperty("webdriver.chrome.driver", FileManager.getInstance().getConfigReader().getDriverPath());		
		driver = new ChromeDriver();
		break;
	case FIREFOX:
		driver = new FirefoxDriver();
		break;
	case IE:
		System.setProperty("webdriver.ie.driver", FileManager.getInstance().getConfigReader().getDriverPath());	
		driver = new InternetExplorerDriver();
		break;
	}
	driver.get(FileManager.getInstance().getConfigReader().getappURL());
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(FileManager.getInstance().getConfigReader().getTimeOut(), TimeUnit.SECONDS);
	return driver;
}
private WebDriver createRemoteDriver()
{
	throw new RuntimeException("Remotedriver is not yet implemented");
}
public void closeDriver()
{
	driver.close();
	driver.quit();
}
}
