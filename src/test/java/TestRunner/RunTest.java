package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {".//FeatureFile/DoctorDetails.feature",
							".//FeatureFile/Surgeries.feature",
							".//FeatureFile/VerifySubmitButton.feature"},
							glue = "StepDefinition",
									plugin= {"pretty", "html:c_reports/myreport.html", 
											  "rerun:target/rerun.txt",
											  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
									         })
						

public class RunTest {

}
