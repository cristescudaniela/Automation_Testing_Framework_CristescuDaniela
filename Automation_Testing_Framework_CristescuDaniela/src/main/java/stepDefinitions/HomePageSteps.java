package stepDefinitions;

import contextManagers.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import pageObjects.HomePage;

public class HomePageSteps {
    private TestContext testContext;
    private HomePage homePage;
    public HomePageSteps(TestContext testContext){
        this.testContext = testContext;
        homePage = new HomePage(testContext.getWebDriverManager().getDriver());
    }

    @When("^My account button is clicked$")
    public void myAccountButtonIsClicked() {
        homePage.clickOnMyAccountButton();
    }

    @And("^Register button is clicked$")
    public void registerButtonIsClicked() {
        homePage.clickOnRegisterButton();

    }
}
