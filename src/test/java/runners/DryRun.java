package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features ="./src/test/resources/features",
		glue="step_definitions",
		dryRun=true,
		tags="@amazonSearchTests"
		// when its true, cucumber only runs the scenario steps that have not been implemented
		)
public class DryRun {

}
