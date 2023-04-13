package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.function.BooleanSupplier;

public abstract class Page {

    public Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"top\"]/div[2]/div[2]/ul/li[2]/div/a/span")
    protected WebElement myAccountButton;
    @FindBy(xpath = "//*[@id=\"top\"]/div[2]/div[2]/ul/li[2]/div/ul/li[1]/a")
    protected WebElement registerButton;

    public void navigateToRegisterPage() {
        myAccountButton.click();
        registerButton.click();
    }

    public void clickOnMyAccountButton() {
        myAccountButton.click();
    }

    public void clickOnRegisterBtn() {
        registerButton.click();
    }

    public boolean registerButtonIsDisplayed() {
        return registerButton.isDisplayed();
    }
}

