package org.googlesearch.main;

import org.googlesearch.utils.DriverMaster;
import org.googlesearch.utils.ResultSearch;
import org.googlesearch.utils.SearchGoogle;
import org.junit.Test;

import static org.googlesearch.utils.TestProperties.getProperty;
import static org.junit.Assert.assertTrue;


public class GoogleTest extends DriverMaster {

    @Test
    public void search() throws InterruptedException {

        driver.get(getProperty("GOOGLE_URL"));

        SearchGoogle google = new SearchGoogle(driver);
        ResultSearch resultSearch = google.doSearch(getProperty("SEARCH_TEXT"));
        assertTrue(null,resultSearch.getFirstLink().contains(getProperty("VALIDATE_TEXT")));

        SearchGoogle imagesGooglePage = new SearchGoogle(driver);
        ResultSearch searchImage = imagesGooglePage.doSearchImage();
        assertTrue(null,searchImage.getFirstImage().contains(getProperty("VALIDATE_TEXT")));

        ResultSearch search = google.doSearch();
        assertTrue(null, search.getFirstLink().contains(getProperty("VALIDATE_TEXT")));
    }
}











