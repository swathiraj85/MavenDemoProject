package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PHPTravelsDemoPage {

	final WebDriver driver;
	
@FindBy(how = How.XPATH,using="//*[text()='http://www.phptravels.net']")
public WebElement php_travels_home_page;

@FindBy(how = How.XPATH,using="//*[text()='http://www.phptravels.net/admin']")
public WebElement php_travels_admin_page;

@FindBy(how = How.XPATH,using="//*[text()='http://www.phptravels.net/supplier']")
public WebElement php_travels_supplier_page;

public PHPTravelsDemoPage(WebDriver driver) {
	this.driver = driver;	
	PageFactory.initElements(driver, this);
}

}
