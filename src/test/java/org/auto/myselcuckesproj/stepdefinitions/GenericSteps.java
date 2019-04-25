package org.auto.myselcuckesproj.stepdefinitions;

import org.auto.myselcukes.manager.WebDriverManager;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class GenericSteps {
@SuppressWarnings("null")
@Given("the user is on the PHPTravels Demo Page$")
public void phptravels_demo_navigate() {
	WebDriverManager driver_manager = new WebDriverManager();
	driver_manager.getDriver();
	driver_manager.closeDriver();
}
//@Then("")

}
