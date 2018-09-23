package pageObjects.google;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;

public class GoogleSearchPage extends BasePage {

    private static final String GOOGLE_SEARCH_ENDPOINT = "https://www.google.com/";

    public void openPage() {
        openPage(GOOGLE_SEARCH_ENDPOINT);
    }

    @FindBy(id = "lst-ib")
    private WebElement searchInputField;

    public GoogleSearchResultsPage searchInGoogle(String text) {
        enterText(searchInputField, text);
        pressEnter();
        return new GoogleSearchResultsPage();
    }

}
