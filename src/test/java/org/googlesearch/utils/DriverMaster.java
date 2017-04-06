package org.googlesearch.utils;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.googlesearch.utils.TestProperties.getProperties;
import static org.googlesearch.utils.TestProperties.readPropertiesFromFile;
import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;
import static org.openqa.selenium.remote.BrowserType.IE;

public class DriverMaster {
    public static final String PROP_FILE = "testdata.properties";
    public static final String ImageName = "i48MSmX01sE18M:";
    public static final String FirstLink = "//*[@class='_Rm' and contains(text(),'www.seleniumhq.org')]";
    public static final String FirstImage = "//*[@class='irc_ho' and contains(text(),'www.seleniumhq.org')]";
    public static final String MainField = "lst-ib";
    public static final String LinkImages = "Images";
    public static final String LinkAll = "All";
    protected WebDriver driver;
    private static final String geckoDriver = "webdriver.gecko.driver";

    @Before
    public void Init () throws IOException {
            readPropertiesFromFile();
            String classpath = DriverMaster.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            classpath = classpath.replaceAll("/target/classes/", "");
            classpath = classpath.substring(1);
            switch (getProperties("Browser")) {
                case FIREFOX:
                    System.setProperty(geckoDriver, classpath + "/src/main/resources/geckodriver.exe");
                    driver = new FirefoxDriver();
                    break;
                case CHROME:
                    System.setProperty(geckoDriver, classpath + "/src/main/resources/chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
                case IE:
                    System.setProperty(geckoDriver, classpath + "/src/main/resources/IEDriverServer.exe");
                    driver = new InternetExplorerDriver();
                    break;
                default:
                    System.setProperty(geckoDriver, classpath + "/src/main/resources/geckodriver.exe");
                    driver = new FirefoxDriver();
                    break;
            }
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }


    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
