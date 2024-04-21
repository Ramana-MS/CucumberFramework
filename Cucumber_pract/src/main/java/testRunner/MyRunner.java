
package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= "src/test/resource/Features",
                glue= {"stepDefintion","hooks"},
                tags="",
                publish=true,
                
                plugin = {"pretty","html:target/CucumberReports/CucumberReport.html"},
                monochrome = true)


public class MyRunner {
	
	
}



