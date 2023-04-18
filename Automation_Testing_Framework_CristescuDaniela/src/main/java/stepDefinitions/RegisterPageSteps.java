package stepDefinitions;

import contextManagers.TestContext;
import cucumber.api.java.en.When;
import pageObjects.RegisterPage;
import java.util.Map;

public class RegisterPageSteps {
    private TestContext testContext;
    private RegisterPage registerPage;
    public RegisterPageSteps(TestContext context){
        testContext = context;
        registerPage = new RegisterPage(testContext.getWebDriverManager().getDriver());
    }
    @When("^the register account is populated with below data:$")
    public void theRegisterAccountIsPopulatedWithBelowData(Map<String, String> formData)  {
        String firstName = formData.get("firstName");
        String lastName = formData.get("lastName");
        String email = formData.get("email");
        String password = formData.get("password");
        registerPage.fillInTheRegisterForm(firstName, lastName, email, password);
    }
}
