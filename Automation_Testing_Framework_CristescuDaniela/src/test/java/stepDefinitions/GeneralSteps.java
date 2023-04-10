package stepDefinitions;

import contextManagers.TestContext;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.jupiter.api.Assertions;

public class GeneralSteps {
    private TestContext testContext;

    public GeneralSteps(TestContext context) {
        testContext = context;

    }

    @Given("^\"([^\"]*)\" is accessed$")
    public void isAccessed(String adresaUrl){
        testContext.getWebDriverManager().getDriver().get(adresaUrl);
    }

    @Then("^\"([^\"]*)\" is present within current url$")
    public void isPresentWithinCurrentUrl(String urlKeyWord)  {
        Assertions.assertTrue(testContext.getWebDriverManager().getDriver().getCurrentUrl().contains(urlKeyWord));
    }
}
