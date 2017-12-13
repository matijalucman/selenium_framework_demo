package com.ml.demo.cucumber.stepdefinitions;

import com.ml.demo.cucumber.datacontainers.Google;
import com.ml.demo.pageobjectmodel.applicationpages.GoogleMainPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;

public class GoogleSearch {
    private Google google;

    public GoogleSearch (Google google) {
        this.google = google;
    }

    @Given("^I have opened Google main page$")
    public void openGooglePage() {
        try {
            google.setMainPageInstance(GoogleMainPage.navigateTo("https://www.google.hr"));
        }
        catch (Exception e) {
            Assertions.fail("Error occurred during Google main page opening: " + e);
        }
    }

    @When("^I search term (.*)$")
    public void searchTerm(String searchTerm) {
        try {
            google.setSearchTerm(searchTerm);
            google.getMainPageInstance().searchTerm(searchTerm);
        }
        catch (Exception e) {
            Assertions.fail("Error occurred during term searching: " + e);
        }

    }

    @Then("^I will get results that contain searched term$")
    public void verifySearchResults() {
        Assertions.assertThat(google.getMainPageInstance().
                verifySearchResults(google.getSearchTerm())).isTrue();
    }
}
