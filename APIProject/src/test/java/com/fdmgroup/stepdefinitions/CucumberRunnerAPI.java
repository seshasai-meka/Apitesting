package com.fdmgroup.stepdefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(

		features = "src/test/java/com/fdmgroup/resources/",   
    glue = {"com.fdmgroup.stepdefinitions"},   

       tags= "",

       plugin= {

       		"pretty",

		        "json:Report/cucumberProject.json",

		        "junit:Report/cucumberProject.junit",

		        "html:Report/cucumberProject.html"

	 },

       //color
       
       monochrome = false,

       dryRun = false,

       publish = true	

       )







public class CucumberRunnerAPI {

}
