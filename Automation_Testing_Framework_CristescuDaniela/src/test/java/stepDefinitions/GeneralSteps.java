package stepDefinitions;

import contextManagers.TestContext;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;

public class GeneralSteps {
    private TestContext testContext;

    public GeneralSteps(TestContext context) {
        testContext = context;

    }

    @Given("^\"([^\"]*)\" is accessed$")
    public void isAccessed(String adresaUrl) throws Throwable  {
        testContext.getWebDriverManager().getDriver().get(adresaUrl);
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
