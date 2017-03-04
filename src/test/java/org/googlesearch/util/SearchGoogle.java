package org.googlesearch.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.googlesearch.util.DriverMaster.ImagesPage;
import static org.googlesearch.util.DriverMaster.MainField;
import static org.googlesearch.util.DriverMaster.LinkGoogleMenu;


public class SearchGoogle {
    private final WebDriver driver;

    public SearchGoogle(WebDriver driver) {

        this.driver =driver;
    }
    public ResultSearch search(String text) {
        driver.findElement(By.id(MainField)).sendKeys(text +"\n");
        return new ResultSearch(driver);
    }

    public ResultSearch searchImage() {
        driver.findElement(By.xpath(ImagesPage)).click();
        driver.findElement(By.id(MainField)).click();
        return new ResultSearch(driver);
    }

    public ResultSearch search() {
        driver.findElement(By.linkText(LinkGoogleMenu)).click();
        return new ResultSearch(driver);
    }

}
