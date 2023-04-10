package pageObjects;

import org.openqa.selenium.WebDriver;

public class HomePage extends Page {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    public void clickOnMyAccountButton(){
        myAccountButton.click();
    }
    public void clickOnRegisterButton(){
        registerButton.click();
    }

}
