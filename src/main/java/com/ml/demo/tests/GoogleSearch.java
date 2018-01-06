package com.ml.demo.tests;

import com.ml.demo.pageobjectmodel.applicationpages.GoogleMainPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class GoogleSearch extends BaseTest {

    @Test
    public void googleSearch() {
        GoogleMainPage mainPage = GoogleMainPage.navigateTo("https://www.google.hr/");

        String searchTerm = "Cucumber";
        mainPage.searchTerm(searchTerm);

        Assertions.assertThat(mainPage.verifySearchResults(searchTerm)).isTrue();
    }
}
