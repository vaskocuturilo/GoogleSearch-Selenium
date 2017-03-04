package org.googlesearch.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.googlesearch.util.DriverMaster.ImagesPage;
import static org.googlesearch.util.DriverMaster.NameSearch;
import static org.googlesearch.util.DriverMaster.cssSelectorGoogleMenu;


public class SearchGoogle {
    private final WebDriver driver;

    public SearchGoogle(WebDriver driver) {

        this.driver =driver;
    }
    public ResultSearch search(String text) {
        driver.findElement(By.className(NameSearch)).sendKeys(text +"\n");
        return new ResultSearch(driver);
    }

    public ResultSearch searchImage() {
        driver.findElement(By.xpath(ImagesPage)).click();
        driver.findElement(By.className(NameSearch)).click();
        return new ResultSearch(driver);
    }

    public ResultSearch search() {
        driver.findElement(By.cssSelector(cssSelectorGoogleMenu)).click();
        return new ResultSearch(driver);
    }

}
