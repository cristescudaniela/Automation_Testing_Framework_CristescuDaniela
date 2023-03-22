import managers.WebDriverManager;

public class TestRunner {
    public static void main(String[] args) {
        WebDriverManager webDriverManager = new WebDriverManager("CHROME");
        webDriverManager.getDriver().get("https://www.google.com/");
    }
}
