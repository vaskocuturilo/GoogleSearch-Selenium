package org.googlesearch.main;

import org.googlesearch.utils.DriverMaster;
import org.googlesearch.utils.ResultSearch;
import org.googlesearch.utils.SearchGoogle;
import org.junit.Test;


import static junit.framework.TestCase.assertTrue;
import static org.googlesearch.utils.TestProperties.getProperties;


public class GoogleTest extends DriverMaster {

    @Test
    public void GoogleSearch() throws Exception {

        SearchGoogle googlePage = new SearchGoogle(driver);
        ResultSearch allLinksOnMainPage = googlePage.search(getProperties("SEARCH_TEXT"));
        assertTrue(allLinksOnMainPage.getFirstLink().contains(getProperties("VALIDATE_TEXT")));

        SearchGoogle imagesGooglePage = new SearchGoogle(driver);
        ResultSearch allImagesOnImagePage = imagesGooglePage.searchImage();
        assertTrue(allImagesOnImagePage.getFirstImage().contains(getProperties("VALIDATE_TEXT")));

        allLinksOnMainPage = googlePage.search();
        assertTrue(allLinksOnMainPage.getFirstLink().contains(getProperties("VALIDATE_TEXT")));
    }
}











