package com.TestRunner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

//		features = {"Feature/WebOrder_Login_POM.feature"}
		features = {"Feature/WebOrder_CreateMultipleOrder_FromExcel_POM.feature"}
		//features = {"Feature"}
		,glue= "com.weborder.stepdefinition"
		,dryRun=false
		,monochrome=true
		,plugin  = {"pretty","html:CucumberReport/Report.html"}
		//,plugin  = {"pretty","html:CucumberReport/Report.html","rerun:Rerun/failed_scenarios.txt"}
		//Execute all of them Except Sanity
		//,tags="not @smoke"
		// Execute Smoke and Sanity both test cases
		//,tags= "@smoke or @sanity"
		// Execute Smoke and Sanity , but both should be marked together in feature
		//,tags= "@smoke and @sanity"
		//,tags= "@smoke"
		
		)
public class TestRunner_WebOrder {
	

}
