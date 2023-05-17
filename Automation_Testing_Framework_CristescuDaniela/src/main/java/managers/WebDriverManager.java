package managers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class WebDriverManager {

    private WebDriver driver;
    private String webDriverType;
    private static final Logger logger = LogManager.getLogger(WebDriverManager.class);

    public WebDriverManager() {
        webDriverType = TestDataFileReaderManager.getBrowserType();
    }

    private WebDriver createDriver() {
        switch (webDriverType) {
            case "CHROME":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "FIREFOX":
                System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver");
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Optiunea de web driver indicata nu este valabila! Mai incearca.");
        }
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

        return driver;
    }


    public WebDriver getDriver() {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }

    public void closeDriver() {
        if (driver != null) {
            driver.close();
            logger.info("The driver was closed");
        }
    }
}

