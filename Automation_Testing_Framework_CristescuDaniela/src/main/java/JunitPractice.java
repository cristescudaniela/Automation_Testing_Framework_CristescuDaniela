import org.junit.jupiter.api.Assertions;
import managers.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import pageObjects.RegisterPage;

public class JunitPractice {
    WebDriverManager webDriverManager = new WebDriverManager("CHROME");
    @BeforeEach
    public void beforeTestProcedure(){
        webDriverManager.getDriver().get("https://demo.opencart.com/");
    }
    @AfterEach
    public void afterTestInstructions(){
        webDriverManager.closeDriver();
    }
    @Test
    @DisplayName("Adresa url a paginii Register este disponibila din pagina Home")
    public void verifyTheRegisterPageIsAccesible() throws InterruptedException {
        HomePage homePage = new HomePage(webDriverManager.getDriver());
        homePage.navigateToRegisterPage();

        boolean urlsIsValid = webDriverManager.getDriver().getCurrentUrl().contains("register");
        Assertions.assertTrue(urlsIsValid, "Adresa url nu este valida");
    }
    @Test
    @DisplayName("Register page elements are displayed")
    public void registerPageElementsAreDisplayed(){
        HomePage homePage = new HomePage(webDriverManager.getDriver());
        homePage.navigateToRegisterPage();

        RegisterPage registerPage = new RegisterPage(webDriverManager.getDriver());
        Assertions.assertTrue(registerPage.allTheEllementsAreDisplayed, "Cel putin unul dintre elemente nu a fost afisat");
    }
}
