package com.ml.demo.core.pageobjectmodel.applicationpages;

import com.ml.demo.core.actions.ElementActions;
import com.ml.demo.core.driver.Driver;
import com.ml.demo.core.pageobjectmodel.basepages.BasePage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GoogleMainPage extends BasePage {
    @FindBy(id = "lst-ib")
    private WebElement txtSearch;

    @FindBy(css = "#res .r>a")
    private List<WebElement> searchResults;

    private GoogleMainPage() {
        super();
    }

    public static GoogleMainPage navigateTo(String googleUrl) throws Exception {
        Driver.getInstance().get(googleUrl);
        Driver.getInstance().manage().window().maximize();
        return new GoogleMainPage();
    }

    public void searchTerm(String searchTerm) throws Exception {
        ElementActions.setText(txtSearch, searchTerm);
        txtSearch.submit();
    }

    public boolean verifySearchResults(String searchTerm) {
        getWebDriverWaitInstance(10).
                until(isTrue -> searchResults.size() > 0);

        return searchResults.stream().
                allMatch(result -> StringUtils.containsIgnoreCase(result.getText(), searchTerm));
    }
}
