package org.auto.myselcuckesproj.myselcukes;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue = {"org.auto.myselcuckesproj.stepdefinitions"},
		format = {
				"pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"}	,
		tags= {"@php_admin_page"}
		)
	
public class TestRunner
{
	
}