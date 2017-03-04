package org.googlesearch.util;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

   public class DriverMaster {
       protected static final String SEARCH_TEXT = "selenium";
       protected static final String VALIDATE_TEXT = "www.seleniumhq.org";
       public static final String  FirstLink = "//*[@class='_Rm' and contains(text(),'www.seleniumhq.org')]";
       public static final String ImageName = "i48MSmX01sE18M:";
       public static final String FirstImage = "//*[@class='irc_ho' and contains(text(),'www.seleniumhq.org')]";
       public static final String MainField = "lst-ib";
       public static final String LinkGoogleMenu = "All";
       public static final String ImagesPage = ".//*[@id='hdtb-msb']//a[text()='Images']";
       private static final String HTTP_GOOGLE_COM_NCR = "http://google.com/ncr";
       protected WebDriver driver;

       @Before
       public void SetUp() throws Exception {
           if (driver == null) {
               driver = new FirefoxDriver();
               driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
               driver.manage().window().maximize();
               driver.get(HTTP_GOOGLE_COM_NCR);

           }
       }

       @After
       public void tearDown() throws Exception {
           if (driver != null) {
               driver.quit();
           }
       }
   }
