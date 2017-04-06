package org.googlesearch.main;

import org.googlesearch.utils.DriverMaster;
import org.googlesearch.utils.ResultSearch;
import org.googlesearch.utils.SearchGoogle;
import org.junit.Test;

import static org.googlesearch.utils.TestProperties.getProperties;
import static org.junit.Assert.assertTrue;


public class GoogleTest extends DriverMaster {

    @Test
    public void search() throws InterruptedException {

        driver.get(getProperties("GOOGLE_URL"));

        SearchGoogle google = new SearchGoogle(driver);
        ResultSearch resultSearch = google.doSearch(getProperties("SEARCH_TEXT"));
        assertTrue(resultSearch.getFirstLink().contains(getProperties("VALIDATE_TEXT")));

        SearchGoogle imagesGooglePage = new SearchGoogle(driver);
        ResultSearch searchImage = imagesGooglePage.doSearchImage();
        assertTrue(searchImage.getFirstImage().contains(getProperties("VALIDATE_TEXT")));

        ResultSearch search = google.doSearch();
        assertTrue(search.getFirstLink().contains(getProperties("VALIDATE_TEXT")));
    }
}











