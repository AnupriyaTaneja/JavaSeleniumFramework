package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/*@CucumberOptions(features="src/test/java/cucumber",glue="automationtestingframework.stepDefinitions",
monochrome=true,tags="@ErrorValidation",plugin= {"html:target/cucumber.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests{

}*/  //Error validation test passed

@CucumberOptions(features="src/test/java/cucumber",glue="automationtestingframework.stepDefinitions",
monochrome=true,tags="@Regression",plugin= {"html:target/cucumber.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests{

}
