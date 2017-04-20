package org.googlesearch.main;

import org.googlesearch.utils.DriverMaster;
import org.googlesearch.utils.ResultSearch;
import org.googlesearch.utils.SearchGoogle;
import org.junit.Test;


import static junit.framework.TestCase.assertTrue;
import static org.googlesearch.utils.PropertyLoader.loadProperty;

public class GoogleTest extends DriverMaster {

    @Test
    public void GoogleSearch() throws InterruptedException {
        driver.get(loadProperty("GOOGLE_URL"));

        SearchGoogle googlePage = new SearchGoogle(driver);
        SearchGoogle imagesGooglePage = new SearchGoogle(driver);

        ResultSearch allLinksOnMainPage = googlePage.search(loadProperty("SEARCH_TEXT"));
        assertTrue(allLinksOnMainPage.getFirstLink().contains(loadProperty("VALIDATE_TEXT")));

        ResultSearch allImagesOnImagePage = imagesGooglePage.searchImage();
        assertTrue(allImagesOnImagePage.getFirstImage().contains(loadProperty("VALIDATE_TEXT")));

        allLinksOnMainPage = googlePage.search();
        assertTrue(allLinksOnMainPage.getFirstLink().contains(loadProperty("VALIDATE_TEXT")));
    }
}











