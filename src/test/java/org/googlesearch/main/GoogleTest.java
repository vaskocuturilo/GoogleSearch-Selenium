package org.googlesearch.main;

import org.googlesearch.utils.DriverMaster;
import org.googlesearch.utils.ResultSearch;
import org.googlesearch.utils.SearchGoogle;
import org.junit.Assert;
import org.junit.Test;


import static junit.framework.TestCase.assertTrue;
import static org.googlesearch.utils.PropertyLoader.loadProperty;
import static org.googlesearch.utils.TestProperties.getProperties;


public class GoogleTest extends DriverMaster {

    @Test
    public void GoogleSearch() throws InterruptedException {
        driver.get(getProperties("GOOGLE_URL"));


        SearchGoogle googlePage = new SearchGoogle(driver);
        SearchGoogle imagesGooglePage = new SearchGoogle(driver);

        ResultSearch allLinksOnMainPage = googlePage.search(loadProperty("SEARCH_TEXT"));
        assertTrue(allLinksOnMainPage.getFirstLink().contains(getProperties("VALIDATE_TEXT")));

        ResultSearch allImagesOnImagePage = imagesGooglePage.searchImage();
        assertTrue(allImagesOnImagePage.getFirstImage().contains(getProperties("VALIDATE_TEXT")));

        allLinksOnMainPage = googlePage.search();
        assertTrue(allLinksOnMainPage.getFirstLink().contains(getProperties("VALIDATE_TEXT")));
    }
}











