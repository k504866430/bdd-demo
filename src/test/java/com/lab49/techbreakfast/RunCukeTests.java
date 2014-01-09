package com.lab49.techbreakfast;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		format = { "pretty", "json:target/cucumber.json"},
		features = {"classpath:features/"},
		glue = { "classpath:com.lab49.techbreakfast.cuke.stepdefinitions", "classpath:com.lab49.techbreakfast.cuke.hooks" }
)
public class RunCukeTests {

}
