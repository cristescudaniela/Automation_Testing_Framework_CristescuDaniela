package stepDefinitions;

import contextManagers.TestContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

    private TestContext testContext;
    public Hooks(TestContext context){
        testContext = context;
    }
    @Before
    public void setUpBeforeEachTest(){
        testContext.getWebDriverManager().getDriver();
    }
    @After
    public void tearDownAfterEachTest(){
        testContext.getWebDriverManager().getDriver().close();
    }
}
