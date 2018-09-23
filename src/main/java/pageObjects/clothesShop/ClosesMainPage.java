package pageObjects.clothesShop;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;

public class ClosesMainPage extends BasePage {

    private static final String CLOSES_MAIN_PAGE_ENDPOINT = "http://automationpractice.com/index.php";

    @FindBy(xpath = "//a[@title=\"Women\"]")
    private WebElement womenTab;

    public void open() {
        openPage(CLOSES_MAIN_PAGE_ENDPOINT);
    }

    public WomenClosesPage navigateToWomenTab() {
        womenTab.click();
        return new WomenClosesPage();
    }
}
