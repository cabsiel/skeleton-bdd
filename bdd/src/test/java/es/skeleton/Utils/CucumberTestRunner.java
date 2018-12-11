package es.skeleton.Utils;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
        			"resources/features"
        			},
        glue = {
        		"es.skeleton"
        		},
        strict = true,
        monochrome = true,
        plugin = { 
                "json:target/reports/cucumber/cucumber.json",
                "html:target/reports/cucumber/cucumber.html"
                }
)
public class CucumberTestRunner {}