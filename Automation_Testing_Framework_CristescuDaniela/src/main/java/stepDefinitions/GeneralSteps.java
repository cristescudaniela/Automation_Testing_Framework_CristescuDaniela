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
        System.out.println("somthing");
        testContext.getWebDriverManager().getDriver().get(adresaUrl);
        System.out.println("nothing");
    }

    @Then("^\"([^\"]*)\" is present within current url$")
    public void isPresentWithinCurrentUrl(String urlKeyWord) throws InterruptedException {
        Thread.sleep(10000);
        Assertions.assertTrue(testContext.getWebDriverManager().getDriver().getCurrentUrl().contains(urlKeyWord));
    }
}
