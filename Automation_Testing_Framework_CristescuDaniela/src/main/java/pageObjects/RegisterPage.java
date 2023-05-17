package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Page {
    private final String ENDPOINT = "/index.php?route=account/register";

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input-firstname")
    private WebElement firstNameInput;
    @FindBy(id = "input-lastname")
    private WebElement lastNameInput;
    @FindBy(id = "input-email")
    private WebElement emailInput;
    @FindBy(id = "input-password")
    private WebElement passwordInput;
    @FindBy(xpath = "//*[@id=\"form-register\"]/div/div/div/input")
    private WebElement privacyCheckBox;
    @FindBy(xpath = "//*[@id=\"form-register\"]/div/div/button")
    private WebElement continueButton;

    public void fillInTheRegisterForm(String firstName, String lastName, String email, String password) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
    }

    public boolean allTheElementsAreDisplayed() {
        return firstNameInput.isDisplayed() && lastNameInput.isDisplayed() && emailInput.isDisplayed() && passwordInput.isDisplayed() &&
                continueButton.isDisplayed() && privacyCheckBox.isDisplayed();
    }

    public RegisterPage toPage() {
        driver.get(url + ENDPOINT);
        return this;
    }
}