package pageObjects.wikipedia;

import lombok.Getter;
import lombok.SneakyThrows;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;

import java.util.List;
import java.util.stream.Collectors;

public class WikipediaMainPage extends BasePage {

    private static String WIKIPEDIA_BASE_URL = "https://en.wikipedia.org/wiki/Main_Page";

    public void openPage() {
        openPage(WIKIPEDIA_BASE_URL);
    }

    @Getter
    @FindAll({@FindBy(tagName = "a")})
    private List<WebElement> allLinks;

    @FindBy(id = "mp-dyk")
    private WebElement didYouKnowContainer;

    @SneakyThrows
    public void goToDidYouKnowContainer() {
        moveToElement(didYouKnowContainer);
    }

    public List<String> getAllLinksText() {
        return allLinks.stream().map(link -> link.getAttribute("title")).distinct().collect(Collectors.toList());
    }
}
