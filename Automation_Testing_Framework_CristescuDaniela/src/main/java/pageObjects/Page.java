package pageObjects;

import managers.TestDataFileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public abstract class Page {
    public final WebDriver driver;
    public static final String url = TestDataFileReaderManager.getApplicationUrl();

    @FindBy(xpath = "//*[@id=\"top\"]/div[2]/div[2]/ul/li[2]/div/a/span")
    protected WebElement myAccountButton;
    @FindBy(xpath = "//*[@id=\"top\"]/div[2]/div[2]/ul/li[2]/div/ul/li[1]/a")
    protected WebElement registerButton;

    public Page(WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
    }

    public static void navigateToPage(String page, WebDriver driver) {
        Method method;
        try {
            method = Class.forName("pageObjects." + page).getMethod("toPage");
            method.invoke(Class.forName("pageObjects." + page).getConstructor(WebDriver.class).newInstance(driver));
        } catch (NoSuchMethodException | ClassNotFoundException | IllegalAccessException | InstantiationException |
                 InvocationTargetException exception) {
            exception.printStackTrace();
        }
    }

    public static void clickOnElement(Object pageName, String elementName, WebDriver driver) {
        WebElement button= getElement(pageName, elementName, driver);
        button.click();
    }

    public static boolean elementisDisplayed(Object pageName, String elementName, WebDriver driver) {
        return getElement(pageName, elementName, driver).isDisplayed();
    }

    public static WebElement getElement(Object pageName, String elementName, WebDriver driver) {
        WebElement webElement = null;
        Class clazz = null;
        try {
            clazz = Class.forName("pageObjects." + pageName.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Field field = null;
        try {
            field = clazz.getDeclaredField(elementName);
        } catch (NoSuchFieldException e) {
            Class superClass = clazz.getSuperclass();
            try {
                field = superClass.getDeclaredField(elementName);
            } catch (NoSuchFieldException err) {
                err.printStackTrace();
            }
        } finally {
            field.setAccessible(true);
            try {
                webElement = (WebElement) field.get(clazz.getConstructor(WebDriver.class).newInstance(driver));
            } catch (IllegalAccessException | NoSuchMethodException | InstantiationException |
                     InvocationTargetException | SecurityException exception) {
                exception.printStackTrace();
            }
        }
        if (webElement == null) throw new RuntimeException("No such element on the page");
        return webElement;
    }


    public void navigateToRegisterPage() {
        myAccountButton.click();
        registerButton.click();
    }

}
