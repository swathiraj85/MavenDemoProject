package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PHPTarvelsAdminLoginPage {

final WebDriver driver;
	
@FindBy(how = How.XPATH,using="//input[@name='email'and not(@id)]")
public WebElement admin_email;

@FindBy(how = How.XPATH,using="//input[@name='password']")
public WebElement admin_passwd;

@FindBy(how = How.XPATH,using="//input[@name='remember']")
public WebElement remember_me;

@FindBy(how = How.XPATH,using="//a[@id='link-forgot']")
public WebElement forgot_passwd;

@FindBy(how = How.XPATH,using="//button/span[text()='Login']")
public WebElement admin_login;

public PHPTarvelsAdminLoginPage(WebDriver driver)
{
	this.driver = driver;
	PageFactory.initElements(driver, this);
}
}
