package org.googlesearch.utils;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.googlesearch.utils.TestProperties.getProperty;
import static org.openqa.selenium.remote.BrowserType.*;

public class DriverMaster {
    public static final String PROP_FILE = "testdata.properties";
    public static final String ImageName = "i48MSmX01sE18M:";
    public static final String FirstLink = "//*[@class='_Rm' and contains(text(),'www.seleniumhq.org')]";
    public static final String FirstImage = "//*[@class='irc_ho' and contains(text(),'www.seleniumhq.org')]";
    public static final String MainField = "lst-ib";
    public static final String LinkImages = "Images";
    public static final String LinkAll = "All";
    protected WebDriver driver;

    @Before
    public void Init() throws IOException {
            switch (getProperty("Browser")) {
                case FIREFOX:
                    driver = new FirefoxDriver();
                    break;
                case CHROME:
                    driver = new ChromeDriver();
                    break;
                case IE:
                    driver = new InternetExplorerDriver();
                    break;
                default:
                    driver = new FirefoxDriver();
                    break;
            }
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }

    @After
    public void tearDown() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }
}
