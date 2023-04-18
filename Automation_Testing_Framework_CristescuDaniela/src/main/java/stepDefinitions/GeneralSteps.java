package stepDefinitions;

import contextManagers.ContextKeys;
import contextManagers.TestContext;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import pageObjects.Page;

import java.util.List;


public class GeneralSteps {
    private TestContext testContext;

    public GeneralSteps(TestContext context) {
        testContext = context;
    }

    @Given("^\"([^\"]*)\" is opened$")
    public void isOpened(String page) {
        Page.navigateToPage(page, testContext.getWebDriverManager().getDriver());
        testContext.getScenarioContext().setContext(ContextKeys.PAGE, page);

        boolean verdict = testContext.getWebDriverManager().getDriver().getCurrentUrl().contains(Page.url);
        Assertions.assertTrue(verdict, "The url contains: " + Page.url);
    }

    @When("^\"([^\"]*)\" button is clicked")
    public void buttonIsClicked(String button) {
        Page.clickOnElement(testContext.getScenarioContext().getContext(ContextKeys.PAGE), button, testContext.getWebDriverManager().getDriver());
    }

    @Then("^the new url contains the following string \"([^\"]*)\"$")
    public void theNewUrlContainsTheFollowingString(String contentKey) {
        Boolean stringIsPresentInUrl = testContext.getWebDriverManager().getDriver().getCurrentUrl().contains(contentKey);
        Assertions.assertTrue(stringIsPresentInUrl, "The url contains: " + contentKey);
    }


    @Then("^the following errors (are|are not) displayed on the screen:$")
    public void theFollowingErrorsAreDisplayedOnTheScreen(String condition, List<String> errorMessages) throws InterruptedException {
        Thread.sleep(5000);
        for (int i = 0; i < errorMessages.size(); i++) {
            boolean elementisDisplayed = true;
            try {
                String alertMessage = testContext.getWebDriverManager().getDriver().switchTo().alert().getText();
                elementisDisplayed = false;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (condition.contains("are not"))
                Assert.assertFalse("The error message is not displayed.", elementisDisplayed);
            else {
                Assert.assertTrue("The error message is displayed.", elementisDisplayed);
            }
        }
    }

}
