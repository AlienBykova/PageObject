import lombok.SneakyThrows;
import org.junit.Test;
import pageObjects.wikipedia.WikipediaMainPage;
import static utils.ScreenshotUtil.getScreenshot;

public class WikipediaTests extends BaseTest{


    @Test
    public void printWikiLinkText(){
        WikipediaMainPage wikipediaMainPage = new WikipediaMainPage();
        wikipediaMainPage.openPage();
        wikipediaMainPage.getAllLinksText().forEach(System.out::println);
    }

    @Test
    @SneakyThrows
    public void screenshotTest() {
        WikipediaMainPage wikipediaMainPage = new WikipediaMainPage();
        wikipediaMainPage.openPage();
        getScreenshot();
        wikipediaMainPage.goToDidYouKnowContainer();
        getScreenshot();
    }
}
