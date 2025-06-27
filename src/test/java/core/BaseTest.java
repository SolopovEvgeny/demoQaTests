package core;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public abstract class BaseTest {
    @BeforeMethod
    public void setUp() {
        WebDriverFactory.getDriver().get(ConfigReader.getProperty("base.url"));
    }

    @AfterMethod
    public void tearDown() {
        WebDriverFactory.closeDriver();
    }
}
