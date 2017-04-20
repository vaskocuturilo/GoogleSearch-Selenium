package org.googlesearch.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.googlesearch.utils.DriverMaster.FirstImage;
import static org.googlesearch.utils.DriverMaster.FirstLink;
import static org.googlesearch.utils.DriverMaster.ImageName;

public class ResultSearch {
    private final WebDriver driver;

    public ResultSearch(WebDriver driver) {

        this.driver = driver;
    }

    public String getFirstLink() {

        return driver.findElement(By.xpath(FirstLink)).getText();
    }

    public String getFirstImage() {
        driver.findElement(By.name(ImageName)).click();
        return driver.findElement(By.xpath(FirstImage)).getText();
    }
}
