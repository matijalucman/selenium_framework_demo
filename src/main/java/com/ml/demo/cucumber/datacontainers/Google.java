package com.ml.demo.cucumber.datacontainers;

import com.ml.demo.pageobjectmodel.applicationpages.GoogleMainPage;

public class Google {
    private String searchTerm;
    private GoogleMainPage mainPageInstance;

    public GoogleMainPage getMainPageInstance() {
        return mainPageInstance;
    }

    public void setMainPageInstance(GoogleMainPage mainPageInstance) {
        this.mainPageInstance = mainPageInstance;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }
}
