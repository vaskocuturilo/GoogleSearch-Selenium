package org.googlesearch.main;

import org.googlesearch.util.DriverMaster;
import org.googlesearch.util.ResultSearch;
import org.googlesearch.util.SearchGoogle;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;


public class GoogleTest extends DriverMaster {

    @Test
    public void GoogleSearch() throws Exception {
        SearchGoogle googlePage, imagesGooglePage;
        ResultSearch allLinksOnMainPage, allImagesOnImagePage;

        googlePage = new SearchGoogle(driver);
        imagesGooglePage = new SearchGoogle(driver);

        allLinksOnMainPage = googlePage.search(SEARCH_TEXT);
        assertTrue(allLinksOnMainPage.getFirstLink().contains(VALIDATE_TEXT));

        allImagesOnImagePage = imagesGooglePage.searchImage();
        assertTrue(allImagesOnImagePage.getFirstImage().contains(VALIDATE_TEXT));

        allLinksOnMainPage = googlePage.search();
        assertTrue(allLinksOnMainPage.getFirstLink().contains(VALIDATE_TEXT));

    }

}











