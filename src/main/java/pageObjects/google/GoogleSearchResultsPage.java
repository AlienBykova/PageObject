package pageObjects.google;

import static java.lang.String.format;
import lombok.SneakyThrows;
import static org.assertj.core.api.Assertions.assertThat;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;

import java.util.stream.IntStream;

public class GoogleSearchResultsPage extends BasePage {

    private String linkByHref = "//a[@href=\"%s\"]";

    @FindBy(id = "pnnext")
    private WebElement next;

    private String pageNumber = "//div[@id=\"foot\"]//a[@aria-label=\"Page %s\"]";

    public void navigateToPage(int pageNumber) {
        findElementByXpath(format(this.pageNumber, pageNumber)).click();
    }

    public void navigateToPageWithNextButton(int pageNumber) {
        IntStream.range(1, pageNumber).forEach(item -> next.click());
    }

    @SneakyThrows
    public void verifyLinkPrescense(String linkHref, boolean isPresent) {
        assertThat(findElementsByXpath(format(linkByHref, linkHref)).size() > 0).as(format("Link %s should be present", linkHref)).isEqualTo(isPresent);
    }
}
