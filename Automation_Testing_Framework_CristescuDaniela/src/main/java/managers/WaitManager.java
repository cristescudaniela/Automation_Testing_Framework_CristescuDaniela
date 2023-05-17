package managers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitManager {
    private static WebDriverWait wait;
    private static final Logger logger = LogManager.getLogger(WaitManager.class);
    public WaitManager(WebDriver driver){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30), Duration.ofMillis(2000));
    }
    public static void  toBeClickable(WebElement element, WebDriver driver){
        if(wait == null)
            new WaitManager(driver);
        logger.info("Waiting for the button '" + element.getText() + "' to be clickable!");
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void toBeVisible(WebElement element, WebDriver driver){
        if(wait == null) new WaitManager(driver);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
