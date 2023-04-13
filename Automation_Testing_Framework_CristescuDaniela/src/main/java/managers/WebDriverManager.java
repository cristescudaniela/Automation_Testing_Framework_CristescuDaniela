package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager {

    public WebDriverManager(String webDriverType) {
        this.webDriverType = webDriverType;
    }

    private WebDriver driver;
    private String webDriverType;

    private WebDriver createDriver() {
        switch (webDriverType) {
            case "CHROME":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                System.setProperty("webdriver.chrome.driver", "/Users/danielacristescu/Desktop/Proiectele mele/Automation_Testing_Framework_CristescuDaniela/Automation_Testing_Framework_CristescuDaniela/src/main/resources/drivers/chromedriver");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "FIREFOX":
                System.setProperty("webdriver.gecko,driver", "/Users/danielacristescu/Desktop/Proiectele mele/Automation_Testing_Framework_CristescuDaniela/Automation_Testing_Framework_CristescuDaniela/src/main/resources/drivers/geckodriver");
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Optiunea de web driver indicata nu este valabila! Mai incearca.");
        }
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
            System.out.println("Driver-ul a fost inchis.");
        }
    }
//    public WebDriverManager(){
//        webDriverType = PropertiesManagers.getBrowserType();
//}

}
