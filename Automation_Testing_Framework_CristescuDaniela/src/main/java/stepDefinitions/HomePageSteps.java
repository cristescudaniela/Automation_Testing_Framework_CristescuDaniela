package stepDefinitions;

import contextManagers.ContextKeys;
import contextManagers.TestContext;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.jupiter.api.Assertions;
import pageObjects.HomePage;
import pageObjects.Page;

public class HomePageSteps {
    private TestContext testContext;
    private HomePage homePage;

    public HomePageSteps(TestContext testContext) {
        this.testContext = testContext;
        homePage = new HomePage(testContext.getWebDriverManager().getDriver());
    }


}



