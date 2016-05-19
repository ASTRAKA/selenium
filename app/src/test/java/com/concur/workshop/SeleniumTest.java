package com.concur.workshop;

import com.concur.workshop.categories.UI;
import com.concur.workshop.pageobject.Form;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * @author AndrejS
 */
@Category(UI.class)
public class SeleniumTest {

    private static final Logger logger = LoggerFactory.getLogger(SeleniumTest.class);
    private static WebDriver driver;

    @BeforeClass
    public static void setUp() throws IOException {
        logger.info("starting webdriver");
        driver = new ChromeDriver(new OwnBuilder().usingAnyFreePort().build());
        logger.info("maximizing the browser");
        driver.manage().window().maximize();
        logger.info("navigating to app");
        // TODO: complete URL to navigate in your browser
//        driver.get("");
    }

    @AfterClass
    public static void teardown() {
        logger.info("killing webdriver");
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    @Category(UI.class)
    @Test
    public void testMessages() {
        Form form = new Form(driver);
        // TODO: write test which will set your name, some message, click sends button and assert that
        // there's added one more line and that the last line contains the text you added
    }

    /**
     * call this method to slow down the test
     *
     * @param pauseMls pause in milliseconds
     */
    private void pause(long pauseMls) {
        try {
            Thread.sleep(pauseMls);
        } catch (InterruptedException ignore) {
        }
    }

    /**
     * This method returns unique String every time it's called
     *
     * @return unique string
     */
    private String getUniqueString() {
        return String.valueOf(System.currentTimeMillis());
    }

    /**
     * custom implementation to find chromedriver in resources for win / mac
     *
     * @author AndrejS
     */
    private static class OwnBuilder extends ChromeDriverService.Builder {

        @Override
        protected File findDefaultExecutable() {
            String path;
            if (isWindows()) {
                path = this.getClass().getResource("chromedriver.exe").getPath();
            } else {
                path = this.getClass().getResource("chromedriver").getPath();
            }
            return new File(path);
        }

        private boolean isWindows() {
            return System.getProperty("os.name").toLowerCase().startsWith("windows");
        }

    }
}
