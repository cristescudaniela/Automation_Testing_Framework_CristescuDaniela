package stepDefinitions;

import contextManagers.TestContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hooks {

    private TestContext testContext;
    private static final Logger logger = LogManager.getLogger(Hooks.class);
    public Hooks(TestContext context){
        testContext = context;
    }
    @Before
    public void setUpBeforeEach(){
        testContext.getWebDriverManager().getDriver().manage().window().maximize();
        logger.info("The test case is started.");
    }
    @After
    public void tearDownAfterEach(){
        testContext.getWebDriverManager().closeDriver();
        logger.info("The test case is finished.");
    }
}
