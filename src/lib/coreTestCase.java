package lib;

import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;


public class coreTestCase extends TestCase {

    protected AppiumDriver driver;
    protected Platform Platform;


    @Override
    protected void setUp() throws Exception {

        super.setUp();
        this.Platform = new Platform();
        driver = this.Platform.getDriver();

    }

    @Override
    protected void tearDown() throws Exception
    {

        super.tearDown();
        driver.quit();
    }

}
