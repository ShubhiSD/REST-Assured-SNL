package snl_service;
import static org.hamcrest.Matchers.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.AfterClass;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.api.CucumberOptions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
@CucumberOptions(
        features = "Feature",
        glue = {"stepDef"},
        tags = {"~@Ignore"},
        format = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        })

public class SnlTest_v1_Cucumber extends AbstractTestNGCucumberTests {
	private TestNGCucumberRunner testNGCucumberRunner;
	
	@BeforeClass
	  public void setBaseUri () {
		 testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
		RestAssured.baseURI = "http://10.0.1.86/snl/rest/v1";
	}
	  @Test(description = "New Board creation", dataProvider = "features",priority=1)
	    public void createBoard(CucumberFeatureWrapper cucumberFeature) {
	        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	    }
	  @Test(description = "Creation new Players and then update newly created player", dataProvider = "features",priority=2)
	    public void addUpdatePalyer(CucumberFeatureWrapper cucumberFeature) {
	        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	    }
	  @DataProvider
	    public Object[][] features() {
	        return testNGCucumberRunner.provideFeatures();
	    }
	 
	    @AfterClass
	    public void tearDownClass() throws Exception {
	        testNGCucumberRunner.finish();
	    }

		}
